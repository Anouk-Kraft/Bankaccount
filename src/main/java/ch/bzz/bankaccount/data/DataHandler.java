package ch.bzz.bankaccount.data;

import ch.bzz.bankaccount.model.Konto;
import ch.bzz.bankaccount.model.Settings;
import ch.bzz.bankaccount.model.TransferBill;


import ch.bzz.bankaccount.service.Config;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public class DataHandler {
    private static DataHandler instance = null;
    private static List<Konto> kontoList;
    private static List<TransferBill> transferBillList;
    private static List<Settings> settingsList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
        setTransferBillList(new ArrayList<>());
        readTransferBillJSON();
        setKontoList(new ArrayList<>());
        readAccountListJSON();
        setSettings(new ArrayList<>());
        readSettingsListJSON();
    }



    /**
     * gets the only instance of this class
     * @return
     */
    public static DataHandler getInstance() {
        if (instance == null)
            instance = new DataHandler();
        return instance;
    }


        /**
     * reads all Transfers
     * @return list of transfers
     */
        public List<TransferBill> readAllTransfers() {

        return getTransferBillList();
    }

    /**
     * reads a transfer by its number
     * @param transferNumber
     * @return the Transfers (null=not found)
     */

    public static TransferBill readTransfersBytransferNumber(int transferNumber) {
        TransferBill transferBill = null;
        for (TransferBill entry : getTransferBillList()) {
            if (entry.getTransferNumber() == (transferNumber)) {
                transferBill = entry;
            }
        }
        return transferBill;
    }

    /**
     * inserts a new transferBill into the bookList
     *
     * @param transferBill the transferBill to be saved
     */
    public static void insertTransfer(TransferBill transferBill) {
        getTransferList().add(transferBill);
        writeTransferJSON();
    }

    /**
     * updates the transferList
     */
    public static void updateTransfer() {
        writeTransferJSON();
    }

    /**
     * deletes a transfer identified by the transferNumber
     * @param transferNumber  the key
     * @return  success=true/false
     */
    public static boolean deleteTransfer(int transferNumber) {
        TransferBill transferBill = readTransfersBytransferNumber(transferNumber);
        if (transferBill != null) {
            getTransferList().remove(transferBill);
            writeTransferJSON();
            return true;
        } else {
            return false;
        }
    }


    /**
     * reads all Settings
     * @return list of settings
     */

    public List<Settings> readAllSettings() {

        return getSettingsList();
    }

    /**
     * inserts a new Setting into the settings
     *
     * @param settings the settings to be saved
     */
    public static void insertSettings(Settings settings) {
        getSettingsList().add(settings);
        writeSettingsJSON();
    }

    /**
     * updates the settingList
     */
    public static void upadteSettings() {
        writeSettingsJSON();
    }

    /**
     * deletes a setting identified by the settingId
     * @param settingId  the key
     * @return  success=true/false
     */
    public static boolean deleteSetting(int settingId) {
        Settings settings = readSettingsBySettingId(settingId);
        if (settings != null) {
            getSettingsList().remove(settings);
            writeSettingsJSON();
            return true;
        } else {
            return false;
        }
    }

    /**
     * reads a setting by its id
     * @param settingsId
     * @return the Settings (null=not found)
     */

    public static Settings readSettingsBySettingId(int settingsId) {
        Settings settings = null;
        for (Settings entry : getSettingsList()) {
            if (entry.getSettingsId() == (settingsId)) {
                settings = entry;
            }
        }
        return settings;
    }


    /**
     * reads all Kontos
     * @return list of kontos
     */
    public List<Konto> readAllKontos() {
        return getKontoList();
    }

    /**
     * reads a konto by its number
     * @param kontoNumber
     * @return the Konto (null=not found)
     */

    public static Konto readKontoByKontoNumber(int kontoNumber) {
        Konto konto = null;
        for (Konto entry : getKontoList()) {
            if (entry.getKontoNumber() == (kontoNumber)) {
                konto = entry;
            }
        }
        return konto;
    }

    /**
     * inserts a new Account into the Accountlist
     *
     * @param konto the konto to be saved
     */
    public static void insertAccount(Konto konto) {
        getAccountList().add(konto);
        writebankAccountJSON();
    }

    /**
     * updates the accountlist
     */
    public static void updateAccount() {
        writebankAccountJSON();
    }

    /**
     * deletes a setting identified by the accountId
     * @param accountId  the key
     * @return  success=true/false
     */
    public static boolean deleteAccount(int accountId) {
        Konto konto = readKontoByKontoNumber(accountId);
        if (konto != null) {
            getAccountList().remove(konto);
            writebankAccountJSON();
            return true;
        } else {
            return false;
        }
    }
    /**
     * reads the Transfers from the JSON-file
     */
    private static void readTransferBillJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("transfersJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            TransferBill[] transfers = objectMapper.readValue(jsonData, TransferBill[].class);
            for (TransferBill transfer : transfers) {
                getTransferBillList().add(transfer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * writes the transferList to the JSON-file
     */
    private static void writeTransferJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = Config.getProperty("transfersJSON");
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getTransferList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the Settings from the JSON-file
     */
    private static void readSettingsListJSON() {
        try{
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("settingsJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Settings[] settings = objectMapper.readValue(jsonData, Settings[].class);
            for (Settings settings1 : settings) {
                getSettingsList().add(settings1);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * writes the transferList to the JSON-file
     */
    private static void writeSettingsJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = Config.getProperty("settingsJSON");
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getSettingsList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    /**
     * writes the Kontolist to the JSON-file
     */
    private static void writebankAccountJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = Config.getProperty("bankAccountJSON");
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getAccountList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the Settings from the JSON-file
     */
    private static void readAccountListJSON() {
        try{
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("bankAccountJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Konto[] kontos = objectMapper.readValue(jsonData, Konto[].class);
            for (Konto konto : kontos) {
                getAccountList().add(konto);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }





    /**
     * gets kontolist
     *
     * @return value of kontolist
     */
    private static List<Konto> getKontoList() {
        return kontoList;
    }

    /**
     * sets kontolist
     *
     * @param kontoList the value to set
     */
    private void setKontoList(List<Konto> kontoList) {
        this.kontoList = kontoList;
    }

    /**
     * gets transferList
     *
     * @return value of transferList
     */
    private static List<TransferBill> getTransferBillList() {
        return transferBillList;
    }

    /**
     * sets transferList
     *
     * @param transferBillList the value to set
     */
    private void setTransferBillList(List<TransferBill> transferBillList) {
        this.transferBillList = transferBillList;
    }


    /**
     * gets settingsList
     *
     * @return value of settingsList
     */
    private List<Settings> getSettings() {
        return settingsList;
    }

    /**
     * sets settingsList
     *
     * @param settingsList the value to set
     */
    private void setSettings(List<Settings> settingsList) {
        this.settingsList = settingsList;
    }

    /**
     * gets transferList
     *
     * @return value of transferList
     */

    private static List<TransferBill> getTransferList() {
        if (transferBillList == null) {
           setTransferList (new ArrayList<>());
            readTransferBillJSON();
        }

        return transferBillList;
    }

    /**
     * sets transferList
     *
     * @param transferList the value to set
     */

    private static void setTransferList(List<TransferBill> transferList) {
        DataHandler.transferBillList = transferList;
    }

    /**
     * gets settingsList
     *
     * @return value of settingsList
     */

    private static List<Settings> getSettingsList() {
        if (settingsList == null) {
            setSettingsList (new ArrayList<>());
            readSettingsListJSON();
        }

        return settingsList;
    }

    /**
     * sets settingsList
     *
     * @param settingsList the value to set
     */

    private static void setSettingsList(List<Settings> settingsList) {
        DataHandler.settingsList = settingsList;
    }


    /**
     * gets settingsList
     *
     * @return value of settingsList
     */

    private static List<Konto> getAccountList() {
        if (kontoList == null) {
            setKontolist (new ArrayList<>());
            readAccountListJSON();
        }

        return kontoList;
    }

    /**
     * sets kontoList
     *
     * @param kontoList the value to set
     */

    private static void setKontolist(List<Konto> kontoList) {
        DataHandler.kontoList = kontoList;
    }
}
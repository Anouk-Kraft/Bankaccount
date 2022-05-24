package ch.bzz.bankaccount.data;

import ch.bzz.bankaccount.model.Konto;
import ch.bzz.bankaccount.model.Settings;
import ch.bzz.bankaccount.model.TransferBill;


import ch.bzz.bankaccount.service.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public class DataHandler {
    private static List<Konto> kontoList;
    private static List<TransferBill> transferBillList;
    private static List<Settings> settingsList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {

    }



    /**
     * reads all Kontos
     * @return list of kontos
     */
    public static List<Konto> readAllKontos() {
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
     * reads all Transfers
     * @return list of transfers
     */

    public static List<TransferBill> readAllTransfers() {

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
     * reads all Settings
     * @return list of settings
     */

    public static List<Settings> readAllSettings() {

        return getSettingsList();
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
     * reads the Konto from the JSON-file
     */
    private static void readKontoJSON() {
        try {
            String path = Config.getProperty("bankAccountJSON");
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(path)
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Konto[] kontos = objectMapper.readValue(jsonData, Konto[].class);
            for (Konto konto : kontos) {
                getKontoList().add(konto);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
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
     * reads the Settings from the JSON-file
     */
    private static void readSettingsJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("settingsJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Settings[] settings = objectMapper.readValue(jsonData, Settings[].class);
            for (Settings setting : settings) {
                getSettingsList().add(setting);
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
        if (kontoList==null) {
            setKontoList(new ArrayList<>());
            readKontoJSON();
        }

        return kontoList;
    }

    /**
     * sets kontolist
     *
     * @param kontoList the value to set
     */
    private static void setKontoList(List<Konto> kontoList) {
        DataHandler.kontoList = kontoList;
    }

    /**
     * gets transferList
     *
     * @return value of transferList
     */
    private static List<TransferBill> getTransferBillList() {
        if (transferBillList==null) {
            setTransferBillList(new ArrayList<>());
            readTransferBillJSON();
        }
        return transferBillList;
    }

    /**
     * sets transferList
     *
     * @param transferBillList the value to set
     */
    private static void setTransferBillList(List<TransferBill> transferBillList) {
        DataHandler.transferBillList = transferBillList;
    }


    /**
     * gets settingsList
     *
     * @return value of settingsList
     */
    private static List<Settings> getSettingsList() {
        if (settingsList==null) {
            setSettings(new ArrayList<>());
            readSettingsJSON();
        }
        return settingsList;
    }

    /**
     * sets settingsList
     *
     * @param settingsList the value to set
     */
    private static void setSettings(List<Settings> settingsList) {
        DataHandler.settingsList = settingsList;
    }


}
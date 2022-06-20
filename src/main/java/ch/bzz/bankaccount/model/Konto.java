package ch.bzz.bankaccount.model;


import ch.bzz.bankaccount.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.*;
import javax.ws.rs.FormParam;

/*
This class is my main page where you see your account
 */
public class Konto {

    @FormParam("kontoNumber")
    @Size(min=1, max=10000)
    @NotNull
    private String kontoNumber;

    @FormParam("name")
    @Size(min=3, max=30)
    @NotNull
    private String name;

    @FormParam("nachname")
    @Size(min=3, max=30)
    @NotNull
    private String nachname;

    @FormParam("amount")
    @DecimalMin(value ="0.05")
    @DecimalMax(value = "1000000.00")
    @NotNull
    private double amount;

    @FormParam("iBanNr")
    @Pattern(regexp = "[a-zA-Z]{2}[0-9]{18,22}")
    @NotNull
    private String iBanNr;


    @JsonIgnore
    TransferBill transferBill;

    /**
     * gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     *
     * @param name the value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets nachname
     *
     * @return value of nachname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * sets nachname
     *
     * @param nachname the value to set
     */
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    /**
     * gets amount
     *
     * @return value of amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * sets amount
     *
     * @param amount the value to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * gets iBanNr
     *
     * @return value of iBanNr
     */
    public String getiBanNr() {
        return iBanNr;
    }

    /**
     * sets iBanNr
     *
     * @param iBanNr the value to set
     */
    public void setiBanNr(String iBanNr) {
        this.iBanNr = iBanNr;
    }

    /**
     * gets kontoNumber
     *
     * @return value of kontoNumber
     */
    public String getKontoNumber() {
        return kontoNumber;
    }

    /**
     * sets kontoNumber
     *
     * @param kontoNumber the value to set
     */
    public void setKontoNumber(String kontoNumber) {
        this.kontoNumber = kontoNumber;
    }

    /**
     * gets transferBill
     *
     * @return value of transferBill
     */
    public TransferBill getTransferBill() {
        return transferBill;
    }

    /**
     * sets transferBill
     *
     * @param transferBill the value to set
     */
    public void setTransferBill(TransferBill transferBill) {
        this.transferBill = transferBill;
    }
    /**
     * gets the publisherUUID from the Publisher-object
     * @return
     */
    public String getTransferNumber() {
        if (getTransferBill()== null) return null;
        return getTransferBill().getTransferNumber();
    }

    /**
     * creates a Publisher-object without the booklist
     * @param transferNumber the key
     */
    public void setTransferNumber(String transferNumber) {
        setTransferBill(new TransferBill());
        TransferBill transferBill = DataHandler.getInstance().readTransfersBytransferNumber(transferNumber);
        getTransferBill().setTransferNumber(transferNumber);
        getTransferBill().setTransferNumber(transferBill.getTransferNumber());
    }

}


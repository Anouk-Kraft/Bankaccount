package ch.bzz.bankaccount.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

/*
This class is my main page where you see your account
 */
public class Konto {

    private String name;
    private String nachname;
    private double amount;
    private String iBanNr;
    private int kontoNumber;

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
    public int getKontoNumber() {
        return kontoNumber;
    }

    /**
     * sets kontoNumber
     *
     * @param kontoNumber the value to set
     */
    public void setKontoNumber(int kontoNumber) {
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
}

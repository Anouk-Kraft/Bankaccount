package ch.bzz.bankaccount.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
This class is if you want to do any transactions with your money
 */

public class TransferBill {

    private String name;
    private String nachname;
    private String iBan;
    private double transferBetrag;
    private int transferNumber;
    @JsonIgnore
    Konto konto;

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
     * gets iBan
     *
     * @return value of iBan
     */
    public String getiBan() {
        return iBan;
    }

    /**
     * sets iBan
     *
     * @param iBan the value to set
     */
    public void setiBan(String iBan) {
        this.iBan = iBan;
    }

    /**
     * gets transferBetrag
     *
     * @return value of transferBetrag
     */
    public double getTransferBetrag() {
        return transferBetrag;
    }

    /**
     * sets transferBetrag
     *
     * @param transferBetrag the value to set
     */
    public void setTransferBetrag(double transferBetrag) {
        this.transferBetrag = transferBetrag;
    }

    /**
     * gets transferNumber
     *
     * @return value of transferNumber
     */
    public int getTransferNumber() {
        return transferNumber;
    }

    /**
     * sets transferNumber
     *
     * @param transferNumber the value to set
     */
    public void setTransferNumber(int transferNumber) {
        this.transferNumber = transferNumber;
    }

    /**
     * gets konto
     *
     * @return value of konto
     */
    public Konto getKonto() {
        return konto;
    }

    /**
     * sets konto
     *
     * @param konto the value to set
     */
    public void setKonto(Konto konto) {
        this.konto = konto;
    }
}

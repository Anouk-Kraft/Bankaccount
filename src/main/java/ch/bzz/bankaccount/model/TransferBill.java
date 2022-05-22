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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getiBan() {
        return iBan;
    }

    public void setiBan(String iBan) {
        this.iBan = iBan;
    }

    public double getTransferBetrag() {
        return transferBetrag;
    }

    public void setTransferBetrag(int transferBetrag) {
        this.transferBetrag = transferBetrag;
    }


    public int getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(int transferNumber) {
        this.transferNumber = transferNumber;
    }

    public double getAmount() {
        return transferBetrag;
    }

    public void setAmount(int amount) {
        this.transferBetrag = amount;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }
}

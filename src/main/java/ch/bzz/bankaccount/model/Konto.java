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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getiBanNr() {
        return iBanNr;
    }

    public void setiBanNr(String iBanNr) {
        this.iBanNr = iBanNr;
    }

    public int getKontoNumber() {
        return kontoNumber;
    }

    public void setKontoNumber(int kontoNumber) {
        this.kontoNumber = kontoNumber;
    }

    public TransferBill getTransferBill() {
        return transferBill;
    }

    public void setTransferBill(TransferBill transferBill) {
        this.transferBill = transferBill;
    }



}

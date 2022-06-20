package ch.bzz.bankaccount.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.*;
import javax.ws.rs.FormParam;
import java.math.BigDecimal;

/*
This class is if you want to do any transactions with your money
 */

public class TransferBill {



    @FormParam("name")
    @Size(min=3, max=30)
    @NotNull
    private String name;

    @FormParam("nachname")
    @Size(min=3, max=30)
    @NotNull
    private String nachname;

    @FormParam("iBan")
    @Pattern(regexp = "[a-zA-Z]{2}[0-9]{18,22}")
    @NotNull
    private String iBan;

    @FormParam("transferBetrag")
    @DecimalMin(value ="0.05")
    @DecimalMax(value = "1000000.00")
    @NotNull
    private BigDecimal transferBetrag;

    @FormParam("transferNumber")
    @Size(min=1, max=10000)
    @NotNull
    private String transferNumber;



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
    public BigDecimal getTransferBetrag() {
        return transferBetrag;
    }

    /**
     * sets transferBetrag
     *
     * @param transferBetrag the value to set
     */
    public void setTransferBetrag(BigDecimal transferBetrag) {
        this.transferBetrag = transferBetrag;
    }

    /**
     * gets transferNumber
     *
     * @return value of transferNumber
     */
    public String getTransferNumber() {
        return transferNumber;
    }

    /**
     * sets transferNumber
     *
     * @param transferNumber the value to set
     */
    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
    }







}

package ch.bzz.bankaccount.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
This class is for the Settings from my Bankaccount
 */
public class Settings {

    @JsonIgnore
    Konto konto;
    private String name;
    private String nachname;
    private String eMail;
    private int settingsId;
    private boolean showAmount;

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
     * gets eMail
     *
     * @return value of eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * sets eMail
     *
     * @param eMail the value to set
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * gets settingsId
     *
     * @return value of settingsId
     */
    public int getSettingsId() {
        return settingsId;
    }

    /**
     * sets settingsId
     *
     * @param settingsId the value to set
     */
    public void setSettingsId(int settingsId) {
        this.settingsId = settingsId;
    }

    /**
     * gets showAmount
     *
     * @return value of showAmount
     */
    public boolean isShowAmount() {
        return showAmount;
    }

    /**
     * sets showAmount
     *
     * @param showAmount the value to set
     */
    public void setShowAmount(boolean showAmount) {
        this.showAmount = showAmount;
    }
}

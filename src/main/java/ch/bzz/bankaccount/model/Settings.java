package ch.bzz.bankaccount.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

/*
This class is for the Settings from my Bankaccount
 */
public class Settings {

    @JsonIgnore
    Konto konto;

    @FormParam("name")
    @Size(min=3, max=30)
    @NotNull
    private String name;

    @FormParam("nachname")
    @Size(min=3, max=30)
    @NotNull
    private String nachname;

    @FormParam("eMail")
    @Pattern(regexp = "[A-Za-z1-9.]{1,40}@[A-Za-z.]{1,20}")
    @NotNull
    private String eMail;

    @FormParam("settingsId")
    @Size(min=1, max=4)
    @NotNull
    private String settingsId;

    @FormParam("showAmount")
    @NotNull
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
    public String getSettingsId() {
        return settingsId;
    }

    /**
     * sets settingsId
     *
     * @param settingsId the value to set
     */
    public void setSettingsId(String settingsId) {
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

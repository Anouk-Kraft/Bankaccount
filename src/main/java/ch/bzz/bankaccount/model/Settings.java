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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getSettingsId() {
        return settingsId;
    }

    public void setSettingsId(int settingsId) {
        this.settingsId = settingsId;
    }

    public boolean isShowAmount() {
        return showAmount;
    }

    public void setShowAmount(boolean showAmount) {
        this.showAmount = showAmount;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }
}

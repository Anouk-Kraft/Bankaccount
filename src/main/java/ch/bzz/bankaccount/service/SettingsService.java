package ch.bzz.bankaccount.service;

import ch.bzz.bankaccount.data.DataHandler;
import ch.bzz.bankaccount.model.Settings;
import ch.bzz.bankaccount.model.TransferBill;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Settingsservice for Settings
 *
 * @return a Response
 */

@Path("settings")
public class SettingsService {

    /**
     * reads a list of all settings
     * @return  settings as JSON
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response settingsList() {
        List<Settings> settingsList = DataHandler.getInstance().readAllSettings();
        return Response
                .status(200)
                .entity(settingsList)
                .build();
    }

    /**
     * reads a setting identified by the Id
     * @param settingsId the key
     * @return settings
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSettings(
            @NotEmpty
            @Pattern(regexp = "[0-9]{1,5}")
            @QueryParam("id") int settingsId) {
        int httpStatus = 200;
        Settings settings = DataHandler.readSettingsBySettingId(settingsId);
        if (settings == null) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity(settings)
                .build();
    }

    /**
     * inserts a new setting
     * @param settingsId the id of the setting
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertBook(
            @Valid @BeanParam Settings settings,
            @NotEmpty
            @Pattern(regexp = "[0-9]{1,4}")
            @FormParam("settingsId") int settingsId
    ) {

        settings.setSettingsId((int) Math.floor(Math.random()*101));

        DataHandler.insertSettings(settings);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates a new setting
     * @param settingsId the id of the setting
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateBook(
            @Valid @BeanParam Settings settings,
            @NotEmpty
            @Pattern(regexp = "[0-9]{1,4}")
            @FormParam("settingsId") int settingsId

    ) {
        int httpStatus = 200;
        Settings oldSetting = DataHandler.readSettingsBySettingId(settingsId);
        if (oldSetting != null) {
            oldSetting.setName(settings.getName());
            oldSetting.setNachname(settings.getNachname());
            oldSetting.seteMail(settings.geteMail());
            oldSetting.setSettingsId(settings.getSettingsId());
            oldSetting.setShowAmount(settings.isShowAmount());

            DataHandler.upadteSettings();
        } else {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * deletes a book identified by its uuid
     * @param settingsId  the key
     * @return  Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteBook(
            @QueryParam("settingsId") int settingsId
    ) {
        int httpStatus = 200;
        if (!DataHandler.deleteSetting(settingsId)) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * sets the attributes for the settings-object
     * @param settings  the settings-object
     * @param name  the name of the User
     * @param nachname  the nachname of the User
     * @param eMail  the eMail of the User
     * @param showAmount  if the amount gets shown on your account
     */
    private void setAttributes(
            Settings settings,
            String name,
            String nachname,
            String eMail,
            boolean showAmount
    ) {
        settings.setName(name);
        settings.setNachname(nachname);
        settings.seteMail(eMail);
        settings.setShowAmount(showAmount);
    }

}

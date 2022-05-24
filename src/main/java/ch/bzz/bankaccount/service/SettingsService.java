package ch.bzz.bankaccount.service;

import ch.bzz.bankaccount.data.DataHandler;
import ch.bzz.bankaccount.model.Konto;
import ch.bzz.bankaccount.model.Settings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response settingsList() {
        List<Settings> settingsList = DataHandler.readAllSettings();
        return Response
                .status(200)
                .entity(settingsList)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSettings(@QueryParam("id") int settingsId) {
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

}

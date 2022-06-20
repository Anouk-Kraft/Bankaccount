package ch.bzz.bankaccount.service;

import ch.bzz.bankaccount.data.DataHandler;
import ch.bzz.bankaccount.model.Konto;
import ch.bzz.bankaccount.model.Settings;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Kontoservice for konto
 *
 * @return a Response
 */

@Path("konto")
public class KontoService {

    /**
     * reads a list of all kontos
     * @return  kontos as JSON
     */
        @GET
        @Path("list")
        @Produces(MediaType.APPLICATION_JSON)
        public Response kontoList() {
            List<Konto> kontoList = DataHandler.getInstance().readAllKontos();
            return Response
                    .status(200)
                    .entity(kontoList)
                    .build();
        }


    /**
     * reads a konto identified by the number
     * @param kontoNumber the key
     * @return konto
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readKonto(
            @Pattern(regexp = "[0-9]{1,4}")
            @QueryParam("kontoNumber") String kontoNumber) {
        int httpStatus = 200;
        Konto konto = DataHandler.readKontoByKontoNumber(kontoNumber);
        if (konto == null) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity(konto)
                .build();
    }

    /**
     * inserts a new konto
     * @param kontoNumber the number of the konto
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertKonto(
            @Valid @BeanParam Konto konto,
            @Pattern(regexp = "[0-9]{1,4}")
            @FormParam("kontoNumber") String kontoNumber
    ) {

        konto.setKontoNumber(kontoNumber);

        DataHandler.insertAccount(konto);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates a new konto
     * @param kontoNumber the number of the konto
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateKonto(
            @Valid @BeanParam Konto konto,
            @Pattern(regexp = "[0-9]{1,4}")
            @FormParam("kontoNumber") String kontoNumber


    ) {
        int httpStatus = 200;
        Konto oldKonto = DataHandler.readKontoByKontoNumber(kontoNumber);
        if (oldKonto != null) {
            oldKonto.setKontoNumber(konto.getKontoNumber());
            oldKonto.setName(konto.getName());
            oldKonto.setNachname(konto.getNachname());
            oldKonto.setAmount(konto.getAmount());
            oldKonto.setiBanNr(konto.getiBanNr());


            DataHandler.updateAccount();
        } else {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * deletes a konto by its number
     * @param kontoNumber  the key
     * @return  Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteAccount(
            @Pattern(regexp = "[0-9]{1,4}")
            @QueryParam("kontoNumber") String kontoNumber
    ) {
        int httpStatus = 200;
        if (!DataHandler.deleteAccount(kontoNumber)) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}

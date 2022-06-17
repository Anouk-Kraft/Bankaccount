package ch.bzz.bankaccount.service;

import ch.bzz.bankaccount.data.DataHandler;
import ch.bzz.bankaccount.model.Konto;

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

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readKonto(@QueryParam("id") int kontoNumber) {
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
     * inserts a new Konto
     * @param name  your name
     * @param nachname  your lastname
     * @param amount  the amount of money you have
     * @param iBanNr  your own Iban number
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertKonto(
            @FormParam("name") String name,
            @FormParam("nachname") String nachname,
            @FormParam("amount") double amount,
            @FormParam("iBanNr") String iBanNr
    ) {
        Konto konto = new Konto();
        konto.setKontoNumber((int) Math.floor(Math.random()*101));
        setAttributes(
                konto,
                name,
                nachname,
                amount,
                iBanNr
        );

        DataHandler.insertAccount(konto);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates a new Konto
     * @param kontoNumber the key
     * @param name  your name
     * @param nachname  your lastname
     * @param amount  the amount of money you have
     * @param iBanNr  your own Iban number
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateKonto(
            @FormParam("kontoNumber") int kontoNumber,
            @FormParam("name") String name,
            @FormParam("nachname") String nachname,
            @FormParam("amount") double amount,
            @FormParam("iBanNr") String iBanNr


    ) {
        int httpStatus = 200;
        Konto konto = DataHandler.readKontoByKontoNumber(kontoNumber);
        if (konto != null) {
            setAttributes(
                    konto,
                    name,
                    nachname,
                    amount,
                    iBanNr

            );

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
            @QueryParam("kontoNumber") int kontoNumber
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

    /**
     * sets the attributes for the konto-object
     * @param konto  the konto-object
     * @param name  your name
     * @param nachname  your lastname
     * @param amount  the amount of money you have
     * @param iBanNr  your own Iban number

     */
    private void setAttributes(
            Konto konto,
            String name,
            String nachname,
            double amount,
            String iBanNr

    ) {
        konto.setName(name);
        konto.setNachname(nachname);
        konto.setAmount(amount);
        konto.setiBanNr(iBanNr);

    }

}

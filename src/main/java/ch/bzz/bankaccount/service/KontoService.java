package ch.bzz.bankaccount.service;

import ch.bzz.bankaccount.data.DataHandler;
import ch.bzz.bankaccount.model.Konto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    public Response readBooks(@QueryParam("id") int kontoNumber) {
        int httpStatus = 200;
        Konto konto = DataHandler.getInstance().readKontoByKontoNumber(kontoNumber);
        if (konto == null) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity(konto)
                .build();
    }

}

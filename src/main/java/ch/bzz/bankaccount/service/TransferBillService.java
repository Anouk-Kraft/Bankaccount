package ch.bzz.bankaccount.service;

import ch.bzz.bankaccount.data.DataHandler;
import ch.bzz.bankaccount.model.Konto;
import ch.bzz.bankaccount.model.TransferBill;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * TransferBillService for Transfering bills
 *
 * @return a Response
 */

@Path("transfers")
public class TransferBillService {


    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response listTransferBills() {
        List<TransferBill> transferBillList = DataHandler.readAllTransfers();
        return Response
                .status(200)
                .entity(transferBillList)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readTransfers(@QueryParam("id") int transfers) {
        int httpStatus = 200;
        TransferBill transferBill = DataHandler.readTransfersBytransferNumber(transfers);
        if (transferBill == null) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity(transferBill)
                .build();
    }
}

package ch.bzz.bankaccount.service;

import ch.bzz.bankaccount.data.DataHandler;
import ch.bzz.bankaccount.model.TransferBill;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
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
        List<TransferBill> transferBillList = DataHandler.getInstance().readAllTransfers();
        return Response
                .status(200)
                .entity(transferBillList)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readTransfers(
            @NotEmpty
            @Pattern(regexp = "[0-9]{1,5}")
            @QueryParam("transferNumber") String transferNumber) {
        int httpStatus = 200;
        TransferBill transferBill = DataHandler.readTransfersBytransferNumber(transferNumber);
        if (transferBill == null) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity(transferBill)
                .build();
    }
    /**
     * inserts a new Transfer
     * @param transferNumber the number of the transfer
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertTransfer(
            @Valid @BeanParam TransferBill transferBill,
            @Pattern(regexp = "[0-9]{1,4}")
            @FormParam("transferNumber") String transferNumber
    ) {
        transferBill.setTransferNumber(transferNumber);

        DataHandler.insertTransfer(transferBill);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates a new Transfer
     * @param transferNumber the number of the transfer
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateTransfer(
            @Valid @BeanParam TransferBill transferBill,
           @Pattern(regexp = "[0-9]{1,4}")
            @FormParam("transferNumber") String transferNumber
    ) {
        int httpStatus = 200;
        TransferBill oldTransfer = DataHandler.readTransfersBytransferNumber(transferNumber);
        if (oldTransfer != null) {
                    oldTransfer.setName(transferBill.getName());
                    oldTransfer.setNachname(transferBill.getNachname());
                    oldTransfer.setiBan(transferBill.getiBan());
                    oldTransfer.setTransferBetrag(transferBill.getTransferBetrag());
                    oldTransfer.setTransferNumber(transferBill.getTransferNumber());

            DataHandler.updateTransfer();
        } else {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * deletes a transfer identified by its number
     * @param transferNumber  the key
     * @return  Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delteTransfer(
            @Pattern(regexp = "[0-9]{1,4}")
            @QueryParam("transferNumber") String transferNumber
    ) {
        int httpStatus = 200;
        if (!DataHandler.deleteTransfer(transferNumber)) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}

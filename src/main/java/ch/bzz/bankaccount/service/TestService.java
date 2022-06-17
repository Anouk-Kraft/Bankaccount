package ch.bzz.bankaccount.service;


import ch.bzz.bankaccount.data.DataHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Testservice for testing
 *
 * @return a Response
 */

@Path("test")
public class TestService {
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public Response test(){
        return Response
                .status(200)
                .entity("Test erfolgreich")
                .build();
    }


//    /**
//     * restores the json-files
//     * @return Response
//     */
//    @GET
//    @Path("restore")
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response restore() {
//        try {
//            java.nio.file.Path path = Paths.get(Config.getProperty("bankAccountJSON"));
//            String filename = path.getFileName().toString();
//            String folder = path.getParent().toString();
//
//            byte[] bankAccountJSON = Files.readAllBytes(Paths.get(folder, "backup", filename));
//            FileOutputStream fileOutputStream = new FileOutputStream(Config.getProperty("bankAccountJSON"));
//            fileOutputStream.write(bankAccountJSON);
//
//            path = Paths.get(Config.getProperty("transfersJSON"));
//            filename = path.getFileName().toString();
//            folder = path.getParent().toString();
//
//            byte[] transferJSON = Files.readAllBytes(Paths.get(folder, "backup", filename));
//            fileOutputStream = new FileOutputStream(Config.getProperty("transfersJSON"));
//            fileOutputStream.write(transferJSON);
//
//            path = Paths.get(Config.getProperty("settingsJSON"));
//            filename = path.getFileName().toString();
//            folder = path.getParent().toString();
//
//            byte[] settingsJSON = Files.readAllBytes(Paths.get(folder, "backup", filename));
//            fileOutputStream = new FileOutputStream(Config.getProperty("settingsJSON"));
//            fileOutputStream.write(settingsJSON);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        DataHandler.initLists();
//        return Response
//                .status(200)
//                .entity("Erfolgreich")
//                .build();
//    }

}

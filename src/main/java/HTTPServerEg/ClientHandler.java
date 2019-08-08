package HTTPServerEg;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class ClientHandler {
    Logger LOGGER = Logger.getLogger("HTTPServerEg");

    public ClientHandler(Socket socket) throws IOException {
        LOGGER.info("Client accepted");

        // takes input from the client socket
        String resourcePath = PathFinder.getResourcePath(ClientResponse.getRequestedFile(socket));

        new ClientWriter(socket, resourcePath);
        socket.close();
    }
}

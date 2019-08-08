package HTTPServerEg;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class ClientWriter {
    Logger LOGGER = Logger.getLogger("HTTPServerEg");
    public ClientWriter(Socket socket, String resourcePath) throws IOException {
        BufferedOutputStream serverToClientWriter = new BufferedOutputStream(socket.getOutputStream());
        String metaData = "";
        String contents = null;
        String responceOk = "HTTP/1.1 200 OK";
        String serverType = "Server: My Java HTTP Server : 1.0";
        String contentType = "Content-type: text/html";
        try {
            contents = FileReader.readFromFile(resourcePath);
            metaData = responceOk + "\n" + serverType + "\n" + contentType + "\n" + "Content-length: " + contents.length() + "\n\n";
            LOGGER.info("File Read Successful. Reading: "+ resourcePath);//shamstabish -> github   google out architecture of a web server and understand them
        }
        catch (FileNotFoundException e) {
            contents = FileReader.readFromFile(PathFinder.getErrorPath());
            String responce404 = "HTTP/1.1 404 Not Found";
            metaData = responce404 + "\n" + serverType + "\n" + contentType +"\n" + "Content-length: " + contents.length() + "\n\n";
            LOGGER.severe("File Read Un-successful");
        }
        serverToClientWriter.write(metaData.getBytes());
        serverToClientWriter.write(contents.getBytes());
        serverToClientWriter.flush();
    }
}

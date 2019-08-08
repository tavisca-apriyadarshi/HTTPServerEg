package HTTPServerEg;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ClientResponse {
    public static String getRequestMethod(Socket socket) throws IOException {
        byte []buff=new byte[2048];
        new BufferedInputStream(socket.getInputStream()).read(buff);
        String line = new String(buff);
        List<String> gettingPath = Arrays.asList(line.split("\\s+"));

        return  gettingPath.get(0);
    }

    public static String getRequestedFile(Socket socket) throws IOException {
        byte []buff=new byte[2048];
        new BufferedInputStream(socket.getInputStream()).read(buff);
        String line = new String(buff);
        List<String> gettingPath = Arrays.asList(line.split("\\s+"));
        String file = gettingPath.get(1).replace("/", "\\");

        return  file;
    }
}

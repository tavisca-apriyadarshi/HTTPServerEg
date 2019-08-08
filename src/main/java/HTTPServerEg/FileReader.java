package HTTPServerEg;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class FileReader {

    static Logger LOGGER = Logger.getLogger("HTTPServerEg");

    public static  String readFromFile(String fileName) throws FileNotFoundException {
        FileInputStream reader = new FileInputStream(fileName);
        StringBuilder contents = new StringBuilder();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(reader);

        try (bufferedInputStream){
            byte[] buffer = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(buffer);
            contents.append(new String(buffer));
        } catch (IOException e) {
            LOGGER.severe("Couldn't not read the requested file. Searching at:\n" + fileName);
        }
        return contents.toString();
    }
}

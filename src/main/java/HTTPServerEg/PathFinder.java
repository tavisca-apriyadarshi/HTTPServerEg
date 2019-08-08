package HTTPServerEg;

import java.util.Arrays;
import java.util.List;

public class PathFinder {

    public static String getResourcePath(String line) {
        String path = "C:\\Users\\apriyadarshi\\Documents\\GitHub\\1_Projects\\HTTPServerEg\\src\\main\\resources" + line;
        return path;
    }

    public static String getErrorPath() {
        String path = "C:\\Users\\apriyadarshi\\Documents\\GitHub\\1_Projects\\HTTPServerEg\\src\\main\\resources\\Error.html";
        return path;
    }
}

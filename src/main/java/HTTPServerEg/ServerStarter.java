package HTTPServerEg;// A Java program for a Server

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class ServerStarter {
    FileHandler handler;
    {
        try {
            handler = new FileHandler("default.log", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Logger LOGGER = Logger.getLogger("HTTPServerEg");
    //initialize socket and input stream
    private ServerSocket server = null;
    // constructor with port
    public ServerStarter(int port) {
        LOGGER.addHandler(handler);
        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);
            LOGGER.info("Server started");
            LOGGER.info("Waiting for a client ...");
            while(true){
                Socket socket = server.accept();
                new Thread(()-> {
                    try {
                        new ClientHandler(socket);
                    } catch (IOException e) {
                        LOGGER.severe(String.valueOf(e));
                    }
                }).start();
            }
        } catch (IOException i) {
            LOGGER.severe(String.valueOf(i));
        }
    }

    public static void main(String args[]) {
        ServerStarter serverStarter = new ServerStarter(4001);
    }
}

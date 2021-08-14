package server;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends BindException {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(30);
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(5556);
            System.out.println("Server gestartet!");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    //    Thread thread = new Thread(new server.Handler(client));
                    //    thread.start();
                    executor.execute(new Handler(socket));
                    } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
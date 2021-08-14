package client;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable {

    public static void main(String[] args) {
        new Thread(new Client()).start();
        //new Thread(new client.Client()).start();
        //new Thread(new client.Client()).start();
        //new Thread(new client.Client()).start();
    }

    @Override
    public void run() {
        OutputStream outputStream = null;
        try {
            Socket clientSocket = new Socket("localhost", 5556);
            System.out.println("Client gestartet!");

            outputStream = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);

            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            //writer.write(Sender.input);
            //writer.flush();

            String s = null;
            while ((s = reader.readLine()) != null) {
                writer.write(s + "\n");
                writer.flush();
                System.out.println("Empfange vom Server:  " + s );
            }

            reader.close();
            writer.close();

            clientSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
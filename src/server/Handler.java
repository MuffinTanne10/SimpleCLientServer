package server;

import java.io.*;
import java.net.Socket;

public class Handler implements Runnable {

    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream out = null;
        try {
            out = socket.getOutputStream();

            PrintWriter writer = new PrintWriter(out);

            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String s = null;

            while ((s = reader.readLine()) != null) {
                writer.write(s + "\n");
                writer.flush();
                System.out.println("Empfangen vom client.Client: " + s);

            }

            writer.close();
            reader.close();

            socket.close();
        }catch (IOException e) {

        }
    }
}

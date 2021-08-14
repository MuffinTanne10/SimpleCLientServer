package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Sender implements ActionListener {

    static String changename;
    static boolean clicked;
    public static String input;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            input = ClientGui.urmessage.getText();
            //System.out.println(input);

            Socket socket = new Socket("localhost", 5556);

            OutputStream out = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(out);

            //InputStream in = socket.getInputStream();
            //BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            printWriter.write(input + "\n");
            printWriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

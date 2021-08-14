package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Namechanger implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String namechange = JOptionPane.showInputDialog("Ändere hier deinen Namen");
        System.out.println(namechange);
    }
}

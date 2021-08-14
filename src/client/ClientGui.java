package client;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ClientGui {
    private JFrame frame;
    static JTextArea urmessage;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ClientGui window = new ClientGui();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ClientGui() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 12));
        frame.setFont(new Font("Calibri", Font.PLAIN, 12));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 800, 601);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane_IconMessages = new JScrollPane();
        scrollPane_IconMessages.setBorder(new LineBorder(new Color(128, 0, 0)));
        scrollPane_IconMessages.setBounds(6, 6, 627, 497);
        frame.getContentPane().add(scrollPane_IconMessages);

        JTextArea comingNews = new JTextArea();
        comingNews.setFont(new Font("Calibri", Font.PLAIN, 14));
        comingNews.setText("Eingehende Nachrichten");
        comingNews.setBorder(null);
        comingNews.setLineWrap(true);
        scrollPane_IconMessages.setViewportView(comingNews);

        JList listuser = new JList();
        listuser.setFont(new Font("Calibri", Font.PLAIN, 14));
        listuser.setToolTipText("Userliste");
        listuser.setBorder(new LineBorder(new Color(139, 0, 0)));
        listuser.setBounds(647, 6, 131, 497);
        frame.getContentPane().add(listuser);

        JButton send = new JButton("Abschicken");
        send.setBorder(new LineBorder(new Color(128, 0, 0)));
        send.setToolTipText("Nachricht absenden");
        send.addActionListener(new Sender());
        send.setBounds(647, 515, 131, 42);
        frame.getContentPane().add(send);

        JButton name = new JButton("Name");
        name.setBorder(new LineBorder(new Color(128, 0, 0)));
        name.setVisible(true);
        name.setToolTipText("Ändere deinen Namen");
        name.addActionListener(new Namechanger());
        name.setBounds(510, 515, 131, 42);
        frame.getContentPane().add(name);

        JScrollPane scrollMessages = new JScrollPane();
        scrollMessages.setBorder(new LineBorder(new Color(128, 0, 0)));
        scrollMessages.setBounds(6, 517, 500, 40);
        frame.getContentPane().add(scrollMessages);

        urmessage = new JTextArea();
        urmessage.setFont(new Font("Calibri", Font.PLAIN, 19));
        urmessage.setText("Deine Nachricht");
        urmessage.setBorder(null);
        urmessage.setBackground(Color.BLACK);
        urmessage.setToolTipText("Gib hier deine Nachricht ein");
        urmessage.setLineWrap(true);

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    urmessage.getText();
                }
            }
        };

        urmessage.addKeyListener(keyListener);
        scrollMessages.setViewportView(urmessage);
    }
}

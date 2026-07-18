package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Hospital_ChatClient implements ActionListener {

    private JFrame frame;
    private JTextField messageField;
    private JTextArea displayArea;
    private DataOutputStream dout;

    public Hospital_ChatClient() {

        frame = new JFrame("Bishnu Tara Memorial Hospital");
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel heading = new JLabel("Patient ChatBot", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(heading, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        messageField = new JTextField();
        bottomPanel.add(messageField, BorderLayout.CENTER);

        JButton sendButton = new JButton("Send Request");
        sendButton.addActionListener(this);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        connectToServer();
    }

    private void connectToServer() {
        try {
            Socket socket = new Socket("127.0.0.1", 6001);
            displayArea.append("Connected to Hospital Server...\n");

            DataInputStream din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());


            new Thread(() -> {
                try {
                    while (true) {
                        String msg = din.readUTF();
                        displayArea.append(getCurrentTime() + "Patient Care Support: " + msg + "\n");
                    }
                } catch (Exception e) {
                    displayArea.append("Connection Closed.\n");
                }
            }).start();

        } catch (Exception e) {
            displayArea.append("Unable to connect to Bishnu Tara Memorial Hospital Patient Support.\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String msg = messageField.getText().trim();
            if (msg.isEmpty()) return;

            dout.writeUTF(msg);
            displayArea.append(getCurrentTime() + " You: " + msg + "\n");
            messageField.setText("");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return "[" + sdf.format(Calendar.getInstance().getTime()) + "]";
    }

    public static void main(String[] args) {
        new Hospital_ChatClient();
    }
}

package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.HashMap;

public class Update_Patient_Details extends JFrame {

    Update_Patient_Details() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 500);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel heading = new JLabel("Update Patient Details");
        heading.setBounds(120, 20, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        heading.setForeground(Color.white);
        panel.add(heading);

        JLabel label1 = new JLabel("Select Patient:");
        label1.setBounds(30, 80, 155, 20);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label1.setForeground(Color.white);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(200, 80, 255, 25);
        panel.add(choice);

        HashMap<String, String> nameToID = new HashMap<>();

        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT First_Name, Last_Name, ID_NUMBER FROM Patient_Info");
            while (rs.next()) {
                String fullName = rs.getString("First_Name") + " " + rs.getString("Last_Name");
                choice.add(fullName);
                nameToID.put(fullName, rs.getString("ID_NUMBER"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room Number:");
        label2.setBounds(30, 130, 155, 20);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label2.setForeground(Color.white);
        panel.add(label2);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(200, 130, 255, 25);
        panel.add(textFieldR);

        JLabel label3 = new JLabel("In-Time:");
        label3.setBounds(30, 180, 155, 20);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textFieldINTIme = new JTextField();
        textFieldINTIme.setBounds(200, 180, 255, 25);
        panel.add(textFieldINTIme);

        JLabel label4 = new JLabel("Amount Paid (Rs):");
        label4.setBounds(30, 230, 155, 20);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(200, 230, 255, 25);
        panel.add(textFieldAmount);

        JLabel label5 = new JLabel("Pending Amount (Rs):");
        label5.setBounds(30, 280, 180, 20);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(200, 280, 255, 25);
        textFieldPending.setEditable(false);
        panel.add(textFieldPending);

        JLabel label6 = new JLabel("Return Amount (Rs):");
        label6.setBounds(30, 330, 180, 20);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldReturn = new JTextField();
        textFieldReturn.setBounds(200, 330, 255, 25);
        textFieldReturn.setEditable(false);
        panel.add(textFieldReturn);

        JButton check = new JButton("Check");
        check.setBounds(320, 380, 100, 30);
        check.setBackground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String id = nameToID.get(choice.getSelectedItem());

                    ResultSet rs = c.statement.executeQuery("SELECT Room, Date_and_Time, Deposit FROM Patient_Info WHERE ID_NUMBER = '" + id + "'");

                    if (rs.next()) {
                        String rNo = rs.getString("Room");
                        String depositValue = rs.getString("Deposit");

                        textFieldR.setText(rNo);
                        textFieldINTIme.setText(rs.getString("Date_and_Time"));
                        textFieldAmount.setText(depositValue);

                        ResultSet rs2 = c.statement.executeQuery("SELECT room_price FROM Room WHERE Room_No = '" + rNo + "'");
                        if (rs2.next()) {
                            int price = Integer.parseInt(rs2.getString("room_price"));
                            int paid = Integer.parseInt(depositValue);

                            int diff = price - paid;

                            if (diff > 0) {
                                textFieldPending.setText(String.valueOf(diff));
                                textFieldReturn.setText("0");
                            } else if (diff < 0) {
                                textFieldPending.setText("0");
                                textFieldReturn.setText(String.valueOf(Math.abs(diff)));
                            } else {
                                textFieldPending.setText("0");
                                textFieldReturn.setText("0");
                            }
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
                }
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(80, 380, 100, 30);
        update.setBackground(Color.WHITE);
        panel.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String id = nameToID.get(choice.getSelectedItem());
                    String q = "UPDATE Patient_Info SET Room = '" + textFieldR.getText() + "', Date_and_Time = '" + textFieldINTIme.getText() + "', Deposit = '" + textFieldAmount.getText() + "' WHERE ID_NUMBER = '" + id + "'";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(200, 380, 100, 30);
        back.setBackground(Color.WHITE);
        panel.add(back);
        back.addActionListener(ae -> setVisible(false));

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        JLabel imgLabel = new JLabel(new ImageIcon(image));
        imgLabel.setBounds(500, 80, 300, 300);
        panel.add(imgLabel);

        setUndecorated(true);
        setSize(950, 500);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Update_Patient_Details();
    }
}
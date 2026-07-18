package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class All_Patient_Info extends JFrame {
    All_Patient_Info(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,1800,600);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,1500,400);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "SELECT * FROM Patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("First Name");
        label1.setBounds(40,11,200,16);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Last Name");
        label2.setBounds(185,11,200,16);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Gender");
        label3.setBounds(360,11,200,16);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Department");
        label4.setBounds(480,11,200,16);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("ID");
        label5.setBounds(670,11,200,16);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 = new JLabel("ID No.");
        label6.setBounds(800,11,200,16);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JLabel label7 = new JLabel("Payment Method");
        label7.setBounds(920,11,200,16);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);

        JLabel label8 = new JLabel("Room");
        label8.setBounds(1110,11,200,16);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label8);

        JLabel label9 = new JLabel("Date and Time");
        label9.setBounds(1230,11,200,16);
        label9.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label9);

        JLabel label10 = new JLabel("Deposit");
        label10.setBounds(1400,11,200,16);
        label10.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label10);


        JButton button = new JButton("Back");
        button.setBounds(700,500,120,30);
        button.setBackground(Color.YELLOW);
        button.setForeground(Color.BLACK);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1500,600);
        setLayout(null);
        setLocation(5,250);
        setVisible(true);

    }
    public static void main(String[] args) {
        new All_Patient_Info();
    }
}

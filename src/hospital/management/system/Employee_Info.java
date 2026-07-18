package hospital.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_Info extends JFrame {
    Employee_Info() {
        Color themeColor = new Color(109, 164, 170);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1100, 700);
        panel.setBackground(themeColor);
        panel.setLayout(null);
        add(panel);

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(40, 20, 100, 25);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelName);

        JLabel labelAge = new JLabel("Age");
        labelAge.setBounds(175, 20, 50, 25);
        labelAge.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelAge);

        JLabel labelDept = new JLabel("Department");
        labelDept.setBounds(265, 20, 150, 25);
        labelDept.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelDept);

        JLabel labelHID = new JLabel("Hospital ID");
        labelHID.setBounds(400, 20, 100, 25);
        labelHID.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelHID);

        JLabel labelMobile = new JLabel("Mobile No.");
        labelMobile.setBounds(530, 20, 100, 25);
        labelMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelMobile);

        JLabel labelNID = new JLabel("NID Number");
        labelNID.setBounds(655, 20, 100, 25);
        labelNID.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelNID);

        JLabel labelPAN = new JLabel("PAN Number");
        labelPAN.setBounds(785, 20, 100, 25);
        labelPAN.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelPAN);

        JLabel labelEmail = new JLabel("Gmail");
        labelEmail.setBounds(950, 20, 600, 25);
        labelEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelEmail);

        JTable table = new JTable();
        table.setBackground(themeColor);
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        table.setRowHeight(30);
        table.setGridColor(Color.WHITE);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 1080, 550);
        scrollPane.getViewport().setBackground(themeColor);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String q = "SELECT * FROM EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            table.setTableHeader(null);

            table.getColumnModel().getColumn(0).setPreferredWidth(135);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(135);
            table.getColumnModel().getColumn(3).setPreferredWidth(130);
            table.getColumnModel().getColumn(4).setPreferredWidth(130);
            table.getColumnModel().getColumn(5).setPreferredWidth(130);
            table.getColumnModel().getColumn(6).setPreferredWidth(130);
            table.getColumnModel().getColumn(7).setPreferredWidth(230);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton button = new JButton("Back");
        button.setBounds(490, 620, 120, 30);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setFocusable(false);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1100, 685);
        setLocation(200, 225);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_Info();
    }
}
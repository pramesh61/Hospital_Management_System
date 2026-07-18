package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_Room extends JFrame {

    Choice choice;
    JTable table;

    Search_Room() {

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 700, 720);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel title = new JLabel("Search For Room");
        title.setBounds(250, 10, 200, 30);
        title.setForeground(Color.white);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(title);

        JLabel status = new JLabel("Status :");
        status.setBounds(70, 60, 100, 20);
        status.setForeground(Color.white);
        status.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170, 60, 150, 20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        JLabel roomNo = new JLabel("Room Number");
        roomNo.setBounds(40, 100, 150, 20);
        roomNo.setForeground(Color.white);
        roomNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(roomNo);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(220, 100, 150, 20);
        availability.setForeground(Color.white);
        availability.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(availability);

        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(390, 100, 150, 20);
        bedType.setForeground(Color.white);
        bedType.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(bedType);

        JLabel price = new JLabel("Price");
        price.setBounds(580, 100, 150, 20);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(price);

        table = new JTable();
        table.setBackground(new Color(90, 156, 163));
        table.setForeground(Color.white);
        table.setRowHeight(25);
        table.setShowGrid(true);
        table.setGridColor(Color.white);
        table.getTableHeader().setVisible(false);

        table.setBounds(0, 130, 700, 500);
        panel.add(table);

        JButton search = new JButton("Search");
        search.setBounds(200, 640, 120, 30);
        search.setBackground(Color.WHITE);
        search.setForeground(Color.BLACK);
        panel.add(search);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedStatus = choice.getSelectedItem();
                loadTable(selectedStatus);
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(380, 640, 120, 30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        loadTable("Available");

        setUndecorated(true);
        setSize(700, 670);
        setLocation(400,230);
        setLayout(null);
        setVisible(true);
    }

    public void loadTable(String status) {
        try {
            conn c = new conn();
            String query = "SELECT * FROM room WHERE Availability = '" + status + "'";
            ResultSet rs = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.getTableHeader().setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Search_Room();
    }
}

package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_Discharge extends JFrame {
    Patient_Discharge(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Discharge Details");
        label.setBounds(100,20,200,30);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label2 = new JLabel("Patient ID");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Patient_Info");
            while (resultSet.next()){
                choice.add(resultSet.getString("ID_NUMBER"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel Room = new JLabel();
        Room.setBounds(200,130,150,20);
        Room.setFont(new Font("Tahoma",Font.BOLD,14));
        Room.setForeground(Color.BLACK);
        panel.add(Room);

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,300,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setForeground(Color.white);
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        Date date = new Date();
        JLabel OUTTime = new JLabel(""+date);
        OUTTime.setBounds(200,230,300,20);
        OUTTime.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTTime.setForeground(Color.white);
        panel.add(OUTTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.WHITE);
        discharge.setForeground(Color.BLACK);
        panel.add(discharge);

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Room.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please click Check first!");
                    return;
                }

                try {
                    conn c = new conn();
                    String id = choice.getSelectedItem();
                    String room = Room.getText();

                    c.statement.executeUpdate(
                            "DELETE FROM Patient_Info WHERE ID_NUMBER = '"+id+"'"
                    );

                    c.statement.executeUpdate(
                            "UPDATE room SET Availability = 'Available' WHERE Room_no = '"+room+"'"
                    );

                    JOptionPane.showMessageDialog(null,"Patient Discharged Successfully");
                    setVisible(false);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        JButton Check = new JButton("Check");
        Check.setBounds(170,300,120,30);
        Check.setBackground(Color.WHITE);
        Check.setForeground(Color.BLACK);
        panel.add(Check);

        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(
                            "SELECT * FROM Patient_Info WHERE ID_Number = '"+choice.getSelectedItem()+"'"
                    );
                    while (resultSet.next()){
                        Room.setText(resultSet.getString("Room"));
                        INTime.setText(resultSet.getString("Date_and_Time"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(300,300,120,30);
        Back.setBackground(Color.WHITE);
        Back.setForeground(Color.BLACK);
        panel.add(Back);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient_Discharge();
    }
}

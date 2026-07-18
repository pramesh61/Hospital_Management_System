package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,1000);
        panel.setBackground(Color.LIGHT_GRAY);
        add (panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(Color.DARK_GRAY);
        add (panel1);


        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(246,215,118));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new New_Patient();
            }
        });

        JButton btn2 = new JButton("Patient Room");
        btn2.setBounds(30,60,200,30);
        btn2.setBackground(new Color(246,215,118));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3 = new JButton("Departments");
        btn3.setBounds(30,105,200,30);
        btn3.setBackground(new Color(246,215,118));
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton btn4 = new JButton("All Employee Info");
        btn4.setBounds(270,15,200,30);
        btn4.setBackground(new Color(246,215,118));
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_Info();
            }
        });

        JButton btn5 = new JButton("Details of Patient");
        btn5.setBounds(270,60,200,30);
        btn5.setBackground(new Color(246,215,118));
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new All_Patient_Info();
            }
        });

        JButton btn6= new JButton("Discharge");
        btn6.setBounds(270,105,200,30);
        btn6.setBackground(new Color(246,215,118));
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_Discharge();
            }
        });

        JButton btn7= new JButton("Update Patient Details");
        btn7.setBounds(510,15,200,30);
        btn7.setBackground(new Color(246,215,118));
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_Patient_Details();
            }
        });

        JButton btn8= new JButton("AMBULANCE");
        btn8.setBounds(510,60,200,30);
        btn8.setBackground(new Color(246,215,118));
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        JButton btn9= new JButton("Search Room");
        btn9.setBounds(510,105,200,30);
        btn9.setBackground(new Color(246,215,118));
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Search_Room();
            }
        });

        JButton btn10= new JButton("Logout");
        btn10.setBounds(750,60,200,30);
        btn10.setBackground(new Color(246,215,118));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int response = JOptionPane.showConfirmDialog(
                        null,
                        "Do you want to logout?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION
                );

                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                    new Login();
                }
            }
        });


        setSize(1950,1090);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);
        setVisible(true);

    }

    public static void main (String[] args){
        new Reception();
    }
}

package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class New_Patient extends JFrame implements ActionListener {

    JComboBox comboDepartment, comboID, comboPayment;
    JTextField textFirstName, textLastName, textFieldNumber, textFieldDeposit;
    JRadioButton r1, r2;
    JComboBox<String> c1;
    JLabel date;
    JButton b1 ,b2;

    New_Patient(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,2500,2000);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(500,500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(450,100,500,500);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(400,10,250,25);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JLabel labelName1 = new JLabel("First Name :");
        labelName1.setBounds(35,60,200,30);
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        textFirstName = new JTextField();
        textFirstName.setBounds(200,60,200,30);
        panel.add(textFirstName);

        JLabel labelName2 = new JLabel("Last Name :");
        labelName2.setBounds(35,120,200,30);
        labelName2.setForeground(Color.white);
        panel.add(labelName2);

        textLastName = new JTextField();
        textLastName.setBounds(200,120,200,30);
        panel.add(textLastName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,180,200,30);
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setBounds(200,185,80,20);
        r1.setBackground(new Color(90,156,163));
        r1.setForeground(Color.white);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(330,185,80,20);
        r2.setBackground(new Color(90,156,163));
        r2.setForeground(Color.white);
        panel.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel labelDepartment = new JLabel("Department :");
        labelDepartment.setBounds(35,240,200,30);
        labelDepartment.setForeground(Color.white);
        panel.add(labelDepartment);

        comboDepartment = new JComboBox(new String[] {
                "General Medicine","General Surgery","Emergency Department",
                "Outpatient Department (OPD)","Intensive Care Unit (ICU)",
                "Cardiology","Neurology","Orthopedics","Pediatrics",
                "Gynecology and Obstetrics","Dermatology","ENT",
                "Ophthalmology","Psychiatry","Pulmonology",
                "Nephrology","Urology","Oncology","Dentistry"
        });
        comboDepartment.setBounds(200,240,200,30);
        panel.add(comboDepartment);

        JLabel labelID1 = new JLabel("ID :");
        labelID1.setBounds(35,300,200,30);
        labelID1.setForeground(Color.white);
        panel.add(labelID1);

        comboID = new JComboBox(new String[] {"National ID","Citizenship","Driving License","PAN","Passport","Voter ID"});
        comboID.setBounds(200,300,200,30);
        panel.add(comboID);

        JLabel labelNumber = new JLabel("ID Number :");
        labelNumber.setBounds(35,360,200,30);
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(200,360,200,30);
        panel.add(textFieldNumber);

        JLabel labelPayment = new JLabel("Payment Method :");
        labelPayment.setBounds(35,420,200,30);
        labelPayment.setForeground(Color.WHITE);
        panel.add(labelPayment);

        comboPayment = new JComboBox(new String[] {
                "eSewa","Khalti","Fonepay","connectIPS","Bank Transfer",
                "Card Payment (POS)","Cash Deposit"
        });
        comboPayment.setBounds(200,420,200,30);
        panel.add(comboPayment);

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35,480,200,30);
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        c1 = new JComboBox<>();

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Room");
            while (resultSet.next()){
                c1.addItem(resultSet.getString("Room_No"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        c1.setBounds(200,480,200,30);
        c1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        c1.setBackground(Color.WHITE);
        c1.setForeground(Color.BLACK);
        panel.add(c1);

        JLabel labelDate = new JLabel("Date and Time :");
        labelDate.setBounds(35,540,200,30);
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(200,540,250,30);
        date.setForeground(Color.white);
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setBounds(35,600,200,30);
        labelDeposit.setForeground(Color.white);
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(200,600,200,30);
        panel.add(textFieldDeposit);

        b1 = new JButton("Add");
        b1.setBounds(100,660,120,30);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260,660,120,30);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(1000,695);
        setLayout(null);
        setLocation(250,210);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            String gender = null;
            if (r1.isSelected()) gender = "Male";
            else if (r2.isSelected()) gender = "Female";

            if (textFirstName.getText().trim().isEmpty()
                    || textLastName.getText().trim().isEmpty()
                    || gender == null
                    || textFieldNumber.getText().trim().isEmpty()
                    || textFieldDeposit.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill all required fields!", "Missing Details", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                Double.parseDouble(textFieldDeposit.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Deposit must be a number!", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                conn c = new conn();

                String q = "INSERT INTO patient_info VALUES ('"
                        + textFirstName.getText().trim() + "','"
                        + textLastName.getText().trim() + "','"
                        + gender + "','"
                        + comboDepartment.getSelectedItem() + "','"
                        + comboID.getSelectedItem() + "','"
                        + textFieldNumber.getText().trim() + "','"
                        + comboPayment.getSelectedItem() + "','"
                        + c1.getSelectedItem() + "','"
                        + date.getText() + "','"
                        + textFieldDeposit.getText().trim() + "')";

                String q1 = "UPDATE Room SET Availability='Occupied' WHERE Room_No='"
                        + c1.getSelectedItem() + "'";

                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);

                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);

            } catch (Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error Occurred");
            }

        } else if (e.getSource() == b2) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new New_Patient();
    }
}

package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    public Login() {
        setTitle("Bishnu Tara Memorial Hospital - Login");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel("Username");
        nameLabel.setBounds(500, 500, 100, 30);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameLabel.setForeground(Color.BLACK);
        add(nameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(500, 600, 100, 30);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passwordLabel.setForeground(Color.BLACK);
        add(passwordLabel);

        textField = new JTextField();
        textField.setBounds(440, 530, 200, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 255, 255));
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(440, 630, 200, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(255, 255, 255));
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(500, 408, Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(250, -25, 500, 500);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(400, 700, 120, 30);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(570, 700, 120, 30);
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String user = textField.getText();
            String pass = new String(jPasswordField.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter both username and password!");
                return;
            }

            try {
                conn c = new conn();
                String query = "SELECT * FROM login WHERE ID = ? AND PW = ?";
                PreparedStatement ps = c.connection.prepareStatement(query);
                ps.setString(1, user);
                ps.setString(2, pass);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == b2) {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
                    "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

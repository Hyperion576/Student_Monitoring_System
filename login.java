package sms;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JButton signin, cancel;
    JTextField username;
    JPasswordField password;
    login(){
        setSize(600,400);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(60,80,150,50);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1.setForeground(Color.white);
        add(l1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(60,160, 150,50);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        l2.setForeground(Color.white);
        add(l2);

        username = new JTextField();
        username.setBounds(250, 80, 150,40);
        username.setFont(new Font("Segeo", Font.PLAIN, 24));
        add(username);

        password = new JPasswordField();
        password.setBounds(250,160, 150,40);
        add(password);

        signin = new JButton("Sign In");
        signin.setBounds(480,280,80,50);
        signin.addActionListener(this);

        add(signin);


        cancel = new JButton("Cancel");
        cancel.setBounds( 40,280,100,50);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);

        add(cancel);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/b15.jpg"));
        JLabel l3 = new JLabel(i1);
        l3.setBounds(0,0,600,400);
        add(l3);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            System.exit(0);
        }
        if (ae.getSource()==signin){
            conn c = new conn();
            String username = this.username.getText();
            String password = String.valueOf(this.password.getPassword());
            try {
                String str = "select * from login where username ='" + username + "' and password ='" + password + "';";
                ResultSet rs = c.s.executeQuery(str);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "log in successful!!");
                    new dashboard();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password:(");
                }



            } catch (Exception e) {

                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new login();
    }

}

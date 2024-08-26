package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class option extends JFrame implements ActionListener {
    JButton marks, details, att;
    option(){
        setSize(1000, 400);
        marks = new JButton("Marks");
        marks.setBounds(150, 100, 200, 80);
        marks.setFont(new Font("Thoma", Font.BOLD, 26));
        marks.addActionListener(this);
        add(marks);

        att = new JButton("Attendence");
        att.setBounds(400, 100, 200, 80);
        att.setFont(new Font("Thoma", Font.BOLD, 26));
        att.addActionListener(this);
        add(att);

        details = new JButton("Details");
        details.setBounds(650, 100, 200, 80);
        details.setFont(new Font("Thoma", Font.BOLD, 26));
        details.addActionListener(this);
        add(details);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/b11.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1000, 400);
        add(l1);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == marks) {
            new viewmarks();
            this.setVisible(false);
        }
        if (ae.getSource() == details) {
            new viewDetails();
            this.setVisible(false);
        }
        if (ae.getSource() == att) {
            new ViewAttendence();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new option();
    }
}

package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class standard extends JFrame implements ActionListener {
    JButton first,second,third,fourth;
    Font font = new Font("Thoma", Font.BOLD, 18);


    standard() {
        setSize(612, 411);
        first = new JButton("1st Standard");
        first.setBounds(60, 60, 150, 50);
        first.setFont(font);
        first.addActionListener(this);
        add(first);
        second = new JButton("2nd Standard");
        second.setBounds(280, 60, 160, 50);
        second.setFont(font);
        second.addActionListener(this);
        add(second);
        third = new JButton("3rd Standard");
        third.setBounds(60, 150, 150, 50);
        third.setFont(font);
        third.addActionListener(this);
        add(third);
        fourth = new JButton("4th Standard");
        fourth.setBounds(280, 150, 160, 50);
        fourth.setFont(font);
        fourth.addActionListener(this);
        add(fourth);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/shiv.jpg"));
        JLabel l2 = new JLabel(i1);
        l2.setBounds(0, 0, 612, 411);
        add(l2);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == first) {
            new option();
            this.setVisible(false);
        }
        if (ae.getSource() == second) {
            new option();
            this.setVisible(false);
        }
        if (ae.getSource() == third) {
            new option();
            this.setVisible(false);
        }
        if (ae.getSource() == fourth) {
            new option();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new standard();
    }
}

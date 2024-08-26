package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewDetails extends JFrame  implements ActionListener {

    JScrollPane sp1;
    JTable t1;
    JButton add,update,delete,back;

    viewDetails() {
        setSize(1000, 700);
        sp1 = new JScrollPane();
       sp1.setBounds(100, 80, 800, 450);
        add(sp1);
        t1 = new JTable();
        sp1.setViewportView(t1);
        add = new JButton("ADD");
        add.setBounds(150, 550, 150, 50);
        add.setFont(new Font("Thoma", Font.BOLD, 22));
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(350, 550, 150, 50);
        update.setFont(new Font("Thoma", Font.BOLD, 22));
        update.addActionListener(this);
        add(update);

        delete = new JButton("Delete");
        delete.setBounds(550, 550, 150, 50);
        delete.setFont(new Font("Thoma", Font.BOLD, 22));
        add(delete);

        conn c = new conn();
        String q1 = "select gr,name,address,adhaar,phoneno,gender,bldgrp,dob from stud_details;";
        try {
            ResultSet rs = c.s.executeQuery(q1);
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/Back Button.jpg"));
        Image img1 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(img1);
        back = new JButton(i1);
        back.setBounds(0, 0, 50, 50);
        back.addActionListener(this);
        add(back);
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/b2.jpg"));
        JLabel l1 = new JLabel(i2);
        l1.setBounds(0,0,1000,700);
        add(l1);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            new Add_Details();
            this.setVisible(false);
        }
        if (ae.getSource() == update) {
            new addDetails();
            this.setVisible(false);
        }
        if (ae.getSource() == back) {
            new option();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new viewDetails();
    }
}

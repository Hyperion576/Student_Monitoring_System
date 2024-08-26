package sms;

import com.toedter.calendar.JDateChooser;

import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


public class Add_Details extends JFrame implements ActionListener {

    Font font = new Font("Thoma",Font.BOLD,18);
    JTextField Name,Address,PhoneNo,Aadhar;
    JDateChooser dob;
    
    JRadioButton male,female;

    ButtonGroup grp = new ButtonGroup();
    JComboBox gen;
    JButton Add,back;
    
    int X = 240;
    int Width = 180;
    int Height = 50;

    Add_Details(){
        setSize(600,800);
        JLabel l1 = new JLabel("Name");
        l1.setBounds(60,60,180,50);
        l1.setFont(font);
        l1.setForeground(Color.white);
        add(l1);
        
        JLabel l2 = new JLabel("Address");
        l2.setBounds(60,140,180,50);
        l2.setFont(font);
        l2.setForeground(Color.white);
        add(l2);
        
        JLabel l3 = new JLabel("D.O.B");
        l3.setBounds(60,220,180,50);
        l3.setFont(font);
        l3.setForeground(Color.white);
        add(l3);
        
        JLabel l4 = new JLabel("Phone No");
        l4.setBounds(60,300,180,50);
        l4.setFont(font);
        l4.setForeground(Color.white);
        add(l4);
        
        JLabel l5 = new JLabel("Aadhar");
        l5.setBounds(60,380,180,50);
        l5.setFont(font);
        l5.setForeground(Color.white);
        add(l5);
        
        JLabel l6 = new JLabel("Gender");
        l6.setBounds(60,460,180,50);
        l6.setFont(font);
        l6.setForeground(Color.white);
        add(l6);
        
        JLabel l7 = new JLabel("Blood Grp");
        l7.setBounds(60,540,180,50);
        l7.setFont(font);
        l7.setForeground(Color.white);
        add(l7);

       Name = new JTextField();
       Name.setBounds(X,60,Width,Height);
       Name.setFont(font);
       add(Name);

       Address = new JTextField();
       Address.setBounds(X,140,Width,Height);
       Address.setFont(font);
        add(Address);

        PhoneNo = new JTextField();
        PhoneNo.setBounds(X,300,Width,Height);
        PhoneNo.setFont(font);
        add(PhoneNo);

        Aadhar = new JTextField();
        Aadhar.setBounds(X,380,Width,Height);
        Aadhar.setFont(font);
        add(Aadhar);

         Add  = new JButton("Add Details");
          Add.setBounds(240,660,150,50);
        Add.setFont(font);
        Add.setBackground(Color.green);
        Add.setForeground(Color.white);
        Add.addActionListener(this);
        add(Add);
        dob = new JDateChooser();
        dob.setBounds(X,220,Width,Height);
        dob.setFont(font);
        add(dob);
        male = new JRadioButton("male");
        male.setBounds(X,460,Width/2,Height);
        male.setFont(font);
        male.setBackground(Color.BLUE);
        male.setForeground(Color.white);
        grp.add(male);
        add(male);
        
        female = new JRadioButton("female");
        female.setBounds(X+100,460,Width/2,Height);
        female.setFont(font);
        female.setBackground(Color.pink);
        female.setForeground(Color.red);
        grp.add(female);
        add(female);
        String [] arr ={"A+","B-","B+","AB+","AB-","O-","O+"};
        gen = new JComboBox(arr);
        gen.setBounds(X,540,Width,Height);
        gen.setFont(font);
        gen.setSelectedIndex(-1);
        add(gen);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/Back Button.jpg"));
        Image img1 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(img1);
        back = new JButton(i1);
        back.setBounds(0, 0, 50, 50);
        back.addActionListener(this);
        add(back);
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/b9.jpg"));
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,600,800);
        add(i3);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() ==Add) {

            String name =this.Name.getText();
            String Address =this.Address.getText();
            String PhoneNo =this.PhoneNo.getText();
            String Aadhar =this.Aadhar.getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "male";
            }
            else if (female.isSelected()) {
                gender ="female";
            }
            String bldgrp = (String) this.gen.getSelectedItem();
            SimpleDateFormat df = new SimpleDateFormat("dd - MMM - yyyy");
            String DOB = df.format(this.dob.getDate());
             conn c = new conn();
           String query ="insert into stud_details (name ,Address ,PhoneNo,adhaar,gender,bldgrp,dob) values ('"+name+"','"+Address+"','"+PhoneNo+"','"+Aadhar+"','"+gender+"','"+bldgrp+"','"+DOB+"');";
            try {
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"data added successfully");
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"some error occured:(");
            }

        }
        if (ae.getSource() == back) {
            new viewDetails();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Add_Details();
    }

}

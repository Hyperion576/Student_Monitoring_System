package sms;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class starter extends JFrame implements ActionListener {
    JButton login;
starter(){
    setSize(600,450);
    JLabel l1= new JLabel( "Greens English School");
    l1.setBounds(150,60,400,100);
    l1.setFont(new Font("Thoma",Font.ITALIC,32));
    add(l1);

    login = new JButton("LOGIN");
    login.setBounds(450,320,100,50);
    login.setFont(new Font("Thoma",Font.ITALIC,18));
    login.addActionListener(this);
    add(login);
    ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/first.jpg"));
    JLabel l2 = new JLabel(i5);
    l2.setBounds(0,0,600,450);
    add(l2);
    setLayout(null);
setLocationRelativeTo(null);
    setVisible(true);
}

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==login){
        new login();
        this.setVisible(false);
    }
}

    public static void main(String[] args) {

    new starter();
    }
}
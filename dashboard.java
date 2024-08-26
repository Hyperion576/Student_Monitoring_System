package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame implements ActionListener {
    JMenuBar br;
    JButton prim,sec,high,log;

    dashboard() {
        setSize(1000, 800);
         br = new JMenuBar();
        br.setBounds(0, 0, 250, 800);
        br.setLayout(new GridLayout(5, 1, 0, 40));

        br.setBackground(Color.getColor("gray",20));
        add(br);
        prim = new JButton("Primary");
        prim.addActionListener(this);
        br.add(prim);
        sec = new JButton("Secondary");
        br.add(sec);
        high = new JButton("Higher Secondary");
        br.add(high);
        log = new JButton("Log Out");
        br.add(log);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/b18.jpg"));
        Image img = i1.getImage().getScaledInstance(1000,800,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(img);
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1000, 800);
        add(l1);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == prim) {
            new standard();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new dashboard();
    }
}

package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewAttendence extends JFrame implements ActionListener {
    JTabbedPane tab;
    JScrollPane sp, df1, df2;
    JTable t1, t2, t3;
    JButton update, df, refresh,back;
    JLabel l1,l2,l3;

    ViewAttendence() {
        setSize(1000, 800);
        l1 = new JLabel("Attendence Section");
        l1.setBounds(430, 20, 350, 50);
        l1.setFont(new Font("Thoma", Font.BOLD, 26));
        add(l1);
        sp = new JScrollPane();
        sp.setFont(new Font("Thoma", Font.PLAIN | Font.BOLD, 22));
        JTableHeader th1 = new JTableHeader();
        th1.setFont(new Font("Thoma", Font.PLAIN | Font.BOLD, 22));

        t1 = new JTable();
        t1.setRowHeight(40);
        t1.setFont(new Font("Thoma", Font.BOLD, 20));
        sp.setViewportView(t1);
        tab = new JTabbedPane();
        tab.setBounds(380, 80, 550, 400);
        tab.addTab(" Attendence ", sp);
        add(tab);
        update = new JButton("Update");
        update.setBounds(100, 120, 180, 50);
        update.setFont(new Font("Thoma", Font.BOLD, 22));
        update.addActionListener(this);
        add(update);
        df = new JButton("Defaulter List");
        df.setBounds(100, 280, 180, 50);
        df.setFont(new Font("Thoma", Font.BOLD, 22));
        df.addActionListener(this);
        add(df);

        df1 = new JScrollPane();
        df1.setBounds(380, 70, 550, 250);
        add(df1);
        df1.setVisible(false);
        t2 = new JTable();
        t2.setRowHeight(40);
        df1.setViewportView(t2);
        df2 = new JScrollPane();
        df2.setBounds(380, 410, 550, 250);
        add(df2);
        df2.setVisible(false);
        l2 = new JLabel("Non Defaulters");
        l2.setBounds(380, 10, 220, 50);
        l2.setFont(new Font("Thoma",Font.BOLD,22));
        add(l2);
        l2.setVisible(false);
        l3 = new JLabel("Defaulters");
        l3.setBounds(380, 350, 220, 50);
        l3.setFont(new Font("Thoma",Font.BOLD,22));
        add(l3);
        l3.setVisible(false);
        t3 = new JTable();
        t3.setRowHeight(40);
        df2.setViewportView(t3);
        refresh = new JButton("Refresh");
        refresh.setBounds(80, 350, 180, 50);
        refresh.setFont(new Font("Thoma", Font.BOLD, 22));
        refresh.addActionListener(this);
        add(refresh);
        refresh.setVisible(false);
        conn c = new conn();
        try {
            String s1 = "select gr,name,attendence from stud_details;";
            ResultSet rs = c.s.executeQuery(s1);
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
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/b5.jpg"));
        JLabel l4 = new JLabel(i2);
        l4.setBounds(0, 0, 1000, 800);
        add(l4);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            new AddAttendence();
            this.setVisible(false);
        }
        if (ae.getSource() == df) {
            String cutoff = JOptionPane.showInputDialog("Enter min. percentage");
            conn c = new conn();
            String q1 = "select gr,name,attendence from stud_details where attendence>='" + cutoff + "';";
            String q2 = "select gr,name,attendence from stud_details where attendence<'" + cutoff + "';";
            try {
                ResultSet rs = c.s.executeQuery(q1);
                t2.setModel(DbUtils.resultSetToTableModel(rs));
                ResultSet sr = c.s.executeQuery(q2);
                t3.setModel(DbUtils.resultSetToTableModel(sr));
                tab.setVisible(false);
                df1.setVisible(true);
                df2.setVisible(true);
                refresh.setVisible(true);
                update.setVisible(false);
                l1.setVisible(false);
                df.setVisible(false);
                l2.setVisible(true);
                l3.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if (ae.getSource() == refresh) {
            tab.setVisible(true);
            df1.setVisible(false);
            df2.setVisible(false);
            update.setVisible(true);
            l1.setVisible(true);
            df.setVisible(true);
            l2.setVisible(false);
            l3.setVisible(false);
            refresh.setVisible(false);


        }
        if (ae.getSource() == back) {
            new option();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewAttendence();
    }
}


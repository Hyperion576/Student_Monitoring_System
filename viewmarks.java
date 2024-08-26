package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewmarks extends JFrame implements ActionListener {

    JScrollPane sp1, sp2,p1,p2,f1,f2;
    JTabbedPane tabs,pass,fail;
    JTable sem1, sem2,pass1,pass2,fail1,fail2;
    JButton Add, p,refresh,back;
    JLabel l1,l2;
    viewmarks() {
        setSize(1000, 800);
        sp1 = new JScrollPane();
        sp2 = new JScrollPane();
        sem1 = new JTable();
        sp1.setViewportView(sem1);
        sem2 = new JTable();
        sp2.setViewportView(sem2);

        tabs = new JTabbedPane();
        tabs.setBounds(350, 40, 600, 350);
        tabs.add("SEM1", sp1);
        tabs.add("SEM2", sp2);
        add(tabs);
        p1 = new JScrollPane();
        pass1 = new JTable();
        p1.setViewportView(pass1);
        p2 = new JScrollPane();
        pass2 = new JTable();
        p2.setViewportView(pass2);

        pass = new JTabbedPane();
        pass.setBounds(350, 40, 600, 350);
        add(pass);
        pass.setVisible(false);
        pass.addTab("Sem 1", p1);
        pass.addTab("Sem 2",p2);
        f1 = new JScrollPane();
        fail1 = new JTable();
        f1.setViewportView(fail1);
        f2 = new JScrollPane();
        fail2 = new JTable();
        f2.setViewportView(fail2);

        fail = new JTabbedPane();
        fail.setBounds(350, 420, 600, 320);
        add(fail);
        fail.setVisible(false);
        fail.addTab("Sem 1", f1);
        fail.addTab("Sem 2", f2);
        l1 = new JLabel("passed students");
        l1.setBounds(480, 20, 200, 50);
        l1.setFont(new Font("Thoma", Font.BOLD, 22));
        add(l1);
        l1.setVisible(false);
        l2 = new JLabel("failed students");
        l2.setBounds(480, 400, 200, 50);
        l2.setFont(new Font("Thoma", Font.BOLD, 22));
        add(l2);
        l2.setVisible(false);
       get_Details();
        Add = new JButton("Add/Update");
        Add.setBounds(80, 100, 180, 50);
        Add.setFont(new Font("Thoma", Font.BOLD, 22));
        Add.addActionListener(this);
        add(Add);
        p = new JButton("pass/fail");
        p.setBounds(80, 300, 180, 50);
        p.setFont(new Font("Thoma", Font.BOLD, 22));
        p.addActionListener(this);
        add(p);

        refresh = new JButton("Refresh");
        refresh.setBounds(80,500,180,50);
        refresh.setFont(new Font("Thoma", Font.BOLD, 22));
        refresh.addActionListener(this);
        add(refresh);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/Back Button.jpg"));
        Image img1 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(img1);
        back = new JButton(i1);
        back.setBounds(0, 0, 50, 50);
        back.addActionListener(this);
        add(back);
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/b12.jpg"));
        JLabel l3 = new JLabel(i2);
        l3.setBounds(0, 0, 1000, 800);
        add(l3);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void get_Details() {
        conn c = new conn();
        try {
            String str1 = "select name ,gr ,english ,marathi ,history ,tot1 from stud_details";
            ResultSet rs = c.s.executeQuery(str1);
            sem1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String str2 = "select name ,gr ,maths ,science ,biology ,tot2 from stud_details";
            ResultSet sr = c.s.executeQuery(str2);
            sem2.setModel(DbUtils.resultSetToTableModel(sr));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == p) {
           String cutoff= JOptionPane.showInputDialog("Enter the cutoff");
            conn c = new conn();
//            for sem1 and sem2 passed
            String query1 ="select gr,name,english,marathi,history,tot1 from stud_details where tot1>='"+cutoff+"';";
            String query2 ="select gr,name,maths,science,biology,tot2 from stud_details where tot2>='"+cutoff+"';";
//            for sem1 and sem2 failed
            String query3 ="select gr,name,english,marathi,history,tot1 from stud_details where tot1<='"+cutoff+"';";
            String query4 ="select gr,name,maths,science,biology,tot2 from stud_details where tot2<='"+cutoff+"';";
            try {
                ResultSet s1 = c.s.executeQuery(query1);
                pass1.setModel(DbUtils.resultSetToTableModel(s1));
                ResultSet s2 = c.s.executeQuery(query2);
                pass2.setModel(DbUtils.resultSetToTableModel(s2));
                ResultSet s3 = c.s.executeQuery(query3);
                fail1.setModel(DbUtils.resultSetToTableModel(s3));
                ResultSet s4 = c.s.executeQuery(query4);
                fail2.setModel(DbUtils.resultSetToTableModel(s4));
                tabs.setVisible(false);
                pass.setVisible(true);
                fail.setVisible(true);
                l1.setVisible(true);
                l2.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (ae.getSource() == refresh) {
            get_Details();
            pass.setVisible(false);
            fail.setVisible(false);
            l1.setVisible(false);
            l2.setVisible(false);
            tabs.setVisible(true);
        }
        if (ae.getSource() == Add) {
            this.setVisible(false);
            new addmarks();
        }
        if (ae.getSource() == back) {
            new option();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new viewmarks();
    }
}

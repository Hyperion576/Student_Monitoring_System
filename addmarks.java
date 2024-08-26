package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addmarks extends JFrame implements ActionListener {
    int labelW = 150;
    int labelH = 50;
    int txtW = 80;
    int txtH = 40;
    Font f1 = new Font("Thoma", Font.BOLD, 22);
    JTextField gr, eng, mar, maths, sci, bio, his;
    JButton display1, update, update1,back;
    JScrollPane sp1, sp2;
    JPanel p1, p2;
    JTabbedPane tabs;
    JTable sem1, sem2;


    addmarks() {
        setSize(600, 800);
        p1 = new JPanel();
        p1.setLayout(null);
        p2 = new JPanel();
        p2.setLayout(null);
        sp1 = new JScrollPane();
        sp1.setBounds(40, 40, 440, 80);
        sp1.setFont(f1);
        sp1.setBackground(Color.cyan);
        p1.add(sp1);
        sem1 = new JTable();
        sem1.setFont(new Font("Thoma", Font.BOLD, 14));
        sem1.setRowHeight(28);
        JTableHeader tb1 = sem1.getTableHeader();
        tb1.setFont(f1);

        sp1.setViewportView(sem1);
        sp2 = new JScrollPane();
        sp2.setBounds(40, 40, 440, 80);
        sp2.setFont(f1);
        p2.add(sp2);
        sem2 = new JTable();
        sem2.setFont(new Font("Thoma", Font.BOLD, 14));
        sem2.setRowHeight(28);
        JTableHeader tb2 = sem2.getTableHeader();
        tb2.setFont(f1);
        sp2.setViewportView(sem2);
        tabs = new JTabbedPane();
        tabs.setBounds(50, 250, 500, 450);
        tabs.setFont(f1);
        add(tabs);
        tabs.addTab("Sem 1", p1);
        tabs.addTab("Sem 2", p2);
        JLabel l = new JLabel("Enter Gr");
        l.setBounds(40, 40, labelW, labelH);
        l.setFont(new Font("Thoma",Font.BOLD|Font.ITALIC,22));
        l.setForeground(Color.BLACK);
        add(l);
        gr = new JTextField();
        gr.setBounds(200, 40, txtW, txtH);
        gr.setFont(f1);
        add(gr);
        display1 = new JButton("Display");
        display1.setBounds(350, 40, labelW, labelH);
        display1.setFont(f1);
        display1.setBackground(Color.green);
        display1.addActionListener(this);
        add(display1);
        JLabel l1 = new JLabel("English");
        l1.setBounds(50, 150, labelW, labelH);
        l1.setFont(f1);
        p1.add(l1);

        JLabel l2 = new JLabel("Marathi");
        l2.setBounds(50, 200, labelW, labelH);
        l2.setFont(f1);
        p1.add(l2);

        JLabel l3 = new JLabel("History");
        l3.setBounds(50, 250, labelW, labelH);
        l3.setFont(f1);
        p1.add(l3);

        JLabel l4 = new JLabel("Maths");
        l4.setBounds(50, 150, labelW, labelH);
        l4.setFont(f1);
        p2.add(l4);

        JLabel l5 = new JLabel("Science");
        l5.setBounds(50, 200, labelW, labelH);
        l5.setFont(f1);
        p2.add(l5);

        JLabel l6 = new JLabel("Biology");
        l6.setBounds(50, 250, labelW, labelH);
        l6.setFont(f1);
        p2.add(l6);
        eng = new JTextField();
        eng.setBounds(150, 150, txtW, txtH);
        eng.setFont(f1);
        p1.add(eng);
        mar = new JTextField();
        mar.setBounds(150, 200, txtW, txtH);
        mar.setFont(f1);
        p1.add(mar);
        his = new JTextField();
        his.setBounds(150, 250, txtW, txtH);
        his.setFont(f1);
        p1.add(his);
        maths = new JTextField();
        maths.setBounds(150, 150, txtW, txtH);
        maths.setFont(f1);
        p2.add(maths);
        sci = new JTextField();
        sci.setBounds(150, 200, txtW, txtH);
        sci.setFont(f1);
        p2.add(sci);
        bio = new JTextField();
        bio.setBounds(150, 250, txtW, txtH);
        bio.setFont(f1);
        p2.add(bio);
        update = new JButton("Update");
        update.setBounds(130, 350, labelW, labelH);
        update.setFont(f1);
        update.addActionListener(this);
        p1.add(update);
        update1 = new JButton("Update");
        update1.setBounds(130, 350, labelW, labelH);
        update1.setFont(f1);
        update1.addActionListener(this);
        p2.add(update1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/Back Button.jpg"));
        Image img1 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(img1);
        back = new JButton(i1);
        back.setBounds(0, 0, 50, 50);
        back.addActionListener(this);
        add(back);
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/b7.jpg"));
        JLabel l7 = new JLabel(i2);
        l7.setBounds(0, 0, 600, 800);
        add(l7);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        conn c = new conn();
        if (ae.getSource() == display1) {

            String gr = this.gr.getText();
            try {
                String s1 = "select name,english,marathi,history from stud_details where gr='" + gr + "';";
                ResultSet rs = c.s.executeQuery(s1);
                sem1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                String s2 = "select name,maths,science,biology from stud_details where gr='" + gr + "';";
                ResultSet sr = c.s.executeQuery(s2);
                sem2.setModel(DbUtils.resultSetToTableModel(sr));
            } catch (Exception e) {
                System.out.println(e);
            }
        }

            if (ae.getSource() == update) {
                String gr = this.gr.getText();
                String english = this.eng.getText();
                String marathi = this.mar.getText();
                String history = this.his.getText();
                try{
                String u1 ="update stud_details set english ='"+english+"' ,marathi ='"+marathi+"' ,history ='"+history+"' where gr = '"+gr+"';";
                    c.s.executeUpdate(u1);
                    JOptionPane.showMessageDialog(null, "success");
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null,"fail:(");
                }
            }
        if (ae.getSource() == update1) {
            String gr = this.gr.getText();
            String maths = this.maths.getText();
            String science = this.sci.getText();
            String biology = this.bio.getText();
            try {
                String u2 = "update stud_details set maths ='" + maths + "', science ='" + science + "', biology ='" + biology + "' where gr ='" + gr + "';";
                c.s.executeUpdate(u2);
                JOptionPane.showMessageDialog(null,"success");
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"fail");
            }
        }
        if (ae.getSource() == back) {
            new viewmarks();
            this.setVisible(false);
        }


        }

        public static void main (String[]args){
            new addmarks();
        }

}

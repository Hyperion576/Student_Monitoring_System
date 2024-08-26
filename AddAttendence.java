package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.jar.JarFile;

public class AddAttendence extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField gr,attendence;
    JScrollPane sp1;
    JButton display,update,back;
    JTable details;
    Font font = new Font("Thoma", Font.PLAIN|Font.BOLD, 22);

    AddAttendence() {
        setSize(600,700);
        l1 = new JLabel("Enter Gr");
        l1.setBounds(70, 40, 180, 50);
        l1.setFont(font);
        l1.setForeground(Color.black);
        add(l1);
        gr = new JTextField();
        gr.setBounds(210,40,150,50);
        gr.setFont(font);
        add(gr);
        display = new JButton("Display");
        display.setBounds(410, 40, 150, 50);
        display.setFont(font);
        display.addActionListener(this);
        add(display);
        sp1 = new JScrollPane();
        sp1.setBounds(100, 200, 450, 80);
        sp1.setFont(font);
        add(sp1);
        details = new JTable();
        details.setFont(font);
        details.setRowHeight(40);
        sp1.setViewportView(details);
        JTableHeader th1 = details.getTableHeader();
        th1.setFont(font);
        th1.setBackground(Color.cyan);


        l2 = new JLabel("Update Attendence");
        l2.setBounds(80, 440, 220, 50);
        l2.setFont(font);
        l2.setForeground(Color.black);
        add(l2);
        update = new JButton("Update");
        update.setBounds(210, 550, 180, 50);
        update.setFont(font);
        update.addActionListener(this);
        add(update);
        attendence = new JTextField();
        attendence.setBounds(350, 450, 180, 50);
        attendence.setFont(font);
        add(attendence);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/Back Button.jpg"));
        Image img1 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(img1);
        back = new JButton(i1);
        back.setBounds(0, 0, 50, 50);
        back.addActionListener(this);
        add(back);
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/shivraj.jpg"));
        JLabel l3 = new JLabel(i2);
        l3.setBounds(0, 0, 600, 700);
        add(l3);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String gr = this.gr.getText();
        conn c = new conn();
        if (ae.getSource() == display) {

            try {
                String s1 = "select gr,name,attendence from stud_details where gr='"+gr+"';";
                ResultSet rs1 = c.s.executeQuery(s1);
                details.setModel(DbUtils.resultSetToTableModel(rs1));

            } catch (Exception e) {
                System.out.println(e);

            }
        }
        if (ae.getSource() == update) {
            String attendence = this.attendence.getText();
            try {
                String s2 = "update stud_details set attendence ='"+attendence+"' where gr='"+gr+"';";
                c.s.executeUpdate(s2);
                JOptionPane.showMessageDialog(null,"update successfully!!");
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"error occured:(");
            }
        }
        if (ae.getSource() == back) {
            new ViewAttendence();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddAttendence();
    }
}

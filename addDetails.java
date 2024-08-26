package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addDetails extends JFrame implements ActionListener {
    JLabel l1;
    JTextField gr,choice;
    JScrollPane sp1;
    JTable t1;
    JComboBox box;
    Font font = new Font("Thoma", Font.PLAIN|Font.BOLD, 18);
    JButton display,update,back;
    addDetails() {
        setSize(900, 700);
        l1 = new JLabel("Enter Gr");
        l1.setBounds(70, 40, 180, 50);
        l1.setFont(font);
        l1.setForeground(Color.white);
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
        sp1.setBounds(40, 200, 750,100);
        sp1.setFont(font);
        add(sp1);
        t1 = new JTable();
        t1.setFont(font);
        t1.setRowHeight(40);
        sp1.setViewportView(t1);
        JTableHeader th1 = t1.getTableHeader();
        th1.setFont(font);
        th1.setBackground(Color.cyan);
        choice = new JTextField();
        choice.setBounds(350, 450, 180, 50);
        choice.setFont(font);
        add(choice);
        update = new JButton("Update");
        update.setBounds(210, 550, 180, 50);
        update.setFont(font);
        update.addActionListener(this);
        add(update);
        String[] arr = {"name", "address", "dob", "phoneno", "gender"};
        box = new JComboBox(arr);
        box.setBounds(70, 450, 220, 50);
        box.setFont(font);
        box.setSelectedIndex(-1);
        add(box);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/Back Button.jpg"));
        Image img1 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(img1);
        back = new JButton(i1);
        back.setBounds(0, 0, 50, 50);
        back.addActionListener(this);
        add(back);
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("JProject_images/a1.jpg"));
        JLabel l2 = new JLabel(i2);
        l2.setBounds(0, 0, 900, 700);
        add(l2);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {

        conn c = new conn();
        if (ae.getSource() == display) {
            String gr = this.gr.getText();

                String q1 = "select name,address,phoneno,gender,dob from stud_details where gr='" + gr + "';";
                try{
                ResultSet rs1 = c.s.executeQuery(q1);
                t1.setModel(DbUtils.resultSetToTableModel(rs1));

            } catch (Exception e) {
                System.out.println(e);

            }
        }
        if (ae.getSource() == back) {
            new viewDetails();
            this.setVisible(false);
        }
        if (ae.getSource() == update) {
            String gr = this.gr.getText();
            String choice = this.choice.getText();
            String box = this.box.getSelectedItem().toString();
            try {

                String str = "update stud_details set "+box+" = '"+choice+"' where gr = '"+gr+"';";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Data added Successfullu!!");
            } catch (Exception e) {
                System.out.println(e);

            }
        }

    }
    public static void main(String[] args) {
        new addDetails();
    }
}

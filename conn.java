package sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;

    conn() {
        String username = "root";
        String password = "hyperion@3523";
        String url = "jdbc:mysql://localhost:3306/sms";
        try {
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void main(String[] args) {
        new conn();
    }
}

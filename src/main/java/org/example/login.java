package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login {
    private JTextField logintxt;
    private JPasswordField passwordtxt;
    private JButton OKButton;
    public JPanel login;

    public login() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024A";
                String username = "root";
                String password = "";


                try{
                    String parametro1=logintxt.getText();
                    String parametro2=passwordtxt.getText();
                    Connection con = DriverManager.getConnection(url,username,password);
                    System.out.println("Se ha conectado con la base de datos");
                    Statement stmt = con.createStatement();
                    String query = "SELECT * FROM estudiantes where cedula="+parametro2;

                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()){
                        System.out.println(rs.getString("cedula"));
                        System.out.println(rs.getString("nombre"));
                        System.out.println(rs.getString("b1"));
                        System.out.println(rs.getString("b2"));
                    }
                    con.close();
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                }

            }
        });
    }
}

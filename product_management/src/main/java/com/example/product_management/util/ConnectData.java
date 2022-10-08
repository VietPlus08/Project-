package com.example.product_management.util;

import java.sql.*;

public class ConnectData {

    public static Connection getConnect(){
        String port = "jdbc:mysql://127.0.0.1/product_management";
        String user = "root";
        String pass = "anhquang0812@";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(port,user,pass);
        }catch (Exception e){
            e.printStackTrace();
        };
        return null;
    }
}

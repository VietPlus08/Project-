package com.example.demo.util;

import java.sql.*;

public class ConnectData {
    static String port = "jdbc:mysql://127.0.0.1/product_management";
    static String user = "root";
    static String pass = "anhquang0812@";
    public static Connection getConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(port,user,pass);
        }catch (Exception e){
            e.printStackTrace();
        };
        return null;
    }
}

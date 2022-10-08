package com.example.flat_management.utils;

import java.sql.*;
public class ConnectData {
    public static Connection getConnect(){
        String port = "jdbc:mysql://127.0.0.1/flat_management";
        String user = "root";
        String pass = "anhquang0812@";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(port,user,pass);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

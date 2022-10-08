package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectData {
    public static Connection getConnect() {
        String port = "jdbc:mysql://127.0.0.1/test_module_4";
        Connection connection = null;
        String username = "root";
        String password = "cumeo144";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(port, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

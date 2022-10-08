package Utils;
import java.sql.*;
public class ConnectData {
    public static Connection getConnection(){
        String port = "jdbc:mysql://127.0.0.1/house_hold_management";
        String user = "root";
        String pass = "anhquang0812@";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(port,user,pass);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

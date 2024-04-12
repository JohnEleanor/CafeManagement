
package cafemanagement;

import java.sql.*;
import javax.swing.*;
public class Database {
    Connection conn = null;
    Statement stm = null;
    // public ResultSet rs;
    
    private String databaseName = "cafe_management_system";
    private String url = "jdbc:mysql://127.0.0.1:3306/"+databaseName;
    private String username = "root";
    private String password = "";

     public void getConnect() {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            stm = conn.createStatement();
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "การเชื่อมต่อ Databse ขัดข้อง\n"+e.getMessage(), "ALERT", 0);
        }
    
    
   }

    public Statement getStatement() {
        return this.stm;
    }   

    public Connection getConnection() {
        return this.conn;
    }


    public void disconect() {
        try {
            stm.close();
            conn.close();
            System.out.println("Disconnected from database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

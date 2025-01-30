/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author User
 */
public class DBConnect {
    public static Connection getJDBCConnection(){
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password ="1111";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            try {
                return (Connection) DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public static void main(String[] args) {
        Connection conn = getJDBCConnection();
        if(conn!=null)
        {
            System.out.println("Thanh cong");
        } else {
            System.out.println("That bai");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import IDAO.icustomerdao;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;

/**
 *
 * @author User
 */
public class customerdao implements icustomerdao{
    @Override
    public ArrayList<Customer> GetListCustomer(HttpServletRequest request, Connection connection) {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<Customer> ListCustomer = new ArrayList<>();
        
        try {
            String sql = "SELECT customer_id, username, pass, name, email, gender, dob, register_date,  phone, address, status FROM customers;";
            try {
                psm = connection.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                Customer cus = new Customer();
                cus.setCustomer_id(rs.getInt("customer_id"));
                cus.setUsername(rs.getString("username"));
                cus.setPass(rs.getString("pass"));
                cus.setName(rs.getString("name"));
                cus.setEmail(rs.getString("email"));
                cus.setPhone(rs.getString("phone"));
                cus.setAddress(rs.getString("address"));
                cus.setGender(rs.getString("gender"));
                cus.setDob(rs.getDate("dob"));
                cus.setRegister_date(rs.getTimestamp("register_date")); 
                cus.setStatus(rs.getBoolean("status"));
                ListCustomer.add(cus);
            }
        } finally {
            if (rs != null) rs.close();
            if (psm != null) psm.close();
        }
        return ListCustomer;
        } catch (SQLException ex) {
                Logger.getLogger(customerdao.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
}

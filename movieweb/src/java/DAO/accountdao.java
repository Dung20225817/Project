/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import IDAO.iaccountdao;
import com.mysql.cj.xdevapi.PreparableStatement;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Account;


/**
 *
 * @author User
 */
public class accountdao implements iaccountdao {


	

        @Override
	public ArrayList<Account> GetListAccount(HttpServletRequest request, Connection connection) {
		PreparedStatement psm = null;
		try {
			ArrayList<Account> accList = new ArrayList<>();
			String sql = "SELECT aid, username, pass, role, name, age, mail, address, phone, image"
					+ " FROM account";
			psm = connection.prepareStatement(sql);
			ResultSet rs = psm.executeQuery();

			while (rs.next()) {
				Account acc = new Account();
				acc.setAid(rs.getInt("aid"));
                                acc.setUsername(rs.getString("username"));
                                acc.setPass(rs.getString("pass"));
                                acc.setRole(rs.getString("role"));
                                acc.setAddress(rs.getString("address"));
                                acc.setAge(rs.getInt("age"));
                                acc.setMail(rs.getString("mail"));
                                acc.setName(rs.getString("name"));
                                acc.setPhone(rs.getString("phone"));
                                acc.setImage(rs.getString("image"));
				accList.add(acc);				
			}
			psm.close();
			return accList;
		} catch (Exception e) {
			System.out.println("Error getting accounts: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
        
        @Override
        public Account GetAccount(HttpServletRequest request, Connection connection, int aid) 
        {
            PreparedStatement psm = null;
           String sql = "SELECT username, name, role, age, phone, address, mail, image FROM account WHERE aid=?;";
            try {
                psm = connection.prepareStatement(sql);
                psm.setInt(1, aid);
    ResultSet rs = psm.executeQuery();

    Account acc = null;  // Đặt null để kiểm tra xem có dữ liệu không
    if (rs.next()) {
        acc = new Account();
        acc.setAid(aid);
        acc.setUsername(rs.getString("username"));
        acc.setRole(rs.getString("role"));
        acc.setAddress(rs.getString("address"));
        acc.setAge(rs.getInt("age"));
        acc.setMail(rs.getString("mail"));
        acc.setName(rs.getString("name"));
        acc.setPhone(rs.getString("phone"));
        acc.setImage(rs.getString("image"));
    }

    rs.close();
    psm.close();
    return acc; //
            } catch (SQLException ex) {
                Logger.getLogger(accountdao.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
        }
        
        @Override
        public void AddAccount(HttpServletRequest request, Connection connection, String username, String pass, String role, String name, int age, String mail, String address, String phone, String image) 
        {
            try {
                PreparedStatement psm = null;
                String sql ="INSERT INTO account(username, pass, role, name, age, mail, address, phone, image)"
                        + "VALUES(?,?,?,?,?,?,?,?,?);";
                psm = connection.prepareStatement(sql);
                psm.setString(1, username);
                psm.setString(2, pass);
                psm.setString(3, role);
                psm.setString(4, name);
                psm.setInt(5, age);
                psm.setString(6, mail);
                psm.setString(7, address);
                psm.setString(8, phone);
                psm.setString(9, image);
                psm.executeUpdate();
                psm.close();
            } catch (SQLException ex) {
                Logger.getLogger(accountdao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        @Override
       public void DeleteAccount(HttpServletRequest request, Connection connection, int aid)
       {
            try {
                PreparedStatement psm =null;
                String sql =" DELETE FROM account WHERE aid=?;";
                psm= connection.prepareStatement(sql);
                psm.setInt(1, aid);
                psm.executeUpdate();
                psm.close();
                
// không nên thay đổi thứ tự id           // Bước 2: Cập nhật lại ID để đảm bảo đúng thứ tự
//        String sqlResetId = "SET @count = 0;";
//        psm = connection.prepareStatement(sqlResetId);
//        psm.executeUpdate();
//        psm.close();
//
//        // Bước 3: Cập nhật lại toàn bộ `oid`
//        String sqlUpdateId = "UPDATE account SET aid = @count := @count + 1;";
//        psm = connection.prepareStatement(sqlUpdateId);
//        psm.executeUpdate();
//        psm.close();
//
//        // Bước 4: Reset lại AUTO_INCREMENT
//        String sqlResetAutoIncrement = "ALTER TABLE account AUTO_INCREMENT = 1;";
//        psm = connection.prepareStatement(sqlResetAutoIncrement);
//        psm.executeUpdate();
//        psm.close();
            } catch (SQLException ex) {
                Logger.getLogger(accountdao.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       
        @Override
       public void UpdateAccount (HttpServletRequest request, Connection connection,int aid, String username, String name, int age, String phone, String mail, String address, String image ) {
            try {
                PreparedStatement psm =null;
                String sql ="UPDATE account SET username =?, name=?, age=?, phone=?, mail=?, address=?, image=? WHERE aid=?;";
                psm = connection.prepareStatement(sql);
                psm.setString(1, username);
                psm.setString(2, name);
                psm.setInt(3, age);
                psm.setString(4, phone);
                psm.setString(5, mail);
                psm.setString(6, address);
                psm.setString(7, image);
                psm.setInt(8, aid);
                psm.executeUpdate();
                psm.close();
            } catch (SQLException ex) {
                Logger.getLogger(accountdao.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       
        @Override
       public void ResetPassword (HttpServletRequest request, Connection connection, String username, String oldpass, String newpass) 
       {
            try {
                PreparedStatement psm =null;
                String sql = "UPDATE account a\n" +
                        "JOIN (SELECT aid FROM account WHERE username = ? AND pass = ?) b\n" +
                        "ON a.aid = b.aid\n" +
                        "SET a.pass = ?;";
                psm = connection.prepareStatement(sql);
                psm.setString(3, newpass);
                psm.setString(1, username);
                psm.setString(2, oldpass);
                psm.executeUpdate();
                psm.close();
            } catch (SQLException ex) {
                Logger.getLogger(accountdao.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
}

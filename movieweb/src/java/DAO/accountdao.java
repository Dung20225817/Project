/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Account;


/**
 *
 * @author User
 */
public class accountdao {
//    public void Addaccount(HttpServletRequest request, Connection connection, String user_name, String password) {
//		PreparedStatement psm = null;
//		String sql = "INSERT INTO public.\"Account\"(\r\n" + "username, \"password\", role_id, active)\r\n"
//				+ "	VALUES (?, ?, ?, ?);";
//		try {
//			psm = connection.prepareStatement(sql);
//			psm.setString(1, user_name);
//			psm.setString(2, password);
//			psm.setInt(3, 2);// role
//			psm.setBoolean(4, true);
//
//			int status = psm.executeUpdate();// thêm account
//			if (status > 0) {
//				System.out.println("them account thanh cong");
//			}
//			psm.close();
//		} catch (Exception e) {
//			String msg = e.toString();
//			System.out.println("loi register" + msg);
//		}
//	}

	public void AddaccountAdmin(HttpServletRequest request, Connection connection, String user_name, String password) {
		PreparedStatement psm = null;
		String sql = "INSERT INTO public.\"Account\"(\r\n" + "name, \"pass\")\r\n"
				+ "	VALUES (?, ?);";
		try {
			psm = connection.prepareStatement(sql);
			psm.setString(1, user_name);
			psm.setString(2, password);


			int status = psm.executeUpdate();// thêm account
			if (status > 0) {
				System.out.println("them account thanh cong");
			}
			psm.close();
		} catch (Exception e) {
			String msg = e.toString();
			System.out.println("loi register" + msg);
		}
	}

	public ArrayList<Account> getAccount(HttpServletRequest request, Connection connection) {
		PreparedStatement psm = null;
		try {
			ArrayList<Account> accList = new ArrayList<>();
			String sql = "SELECT aid, name, pass\r\n"
					+ "FROM account\r\n";
			psm = connection.prepareStatement(sql);
			ResultSet rs = psm.executeQuery();

			while (rs.next()) {
				Account acc = new Account();
				acc.setAid(rs.getInt("aid"));
                                acc.setName(rs.getString("name"));
                                acc.setPass(rs.getString("pass"));

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

}

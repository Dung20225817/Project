/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import IDAO.iorderdao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Movie;
import models.order;

/**
 *
 * @author User
 */
public class orderdao implements iorderdao{
    @Override
    public ArrayList<order> GetListOrder(HttpServletRequest request, Connection connection) {
        try {
            PreparedStatement psm = null;
            ArrayList<order> ListOrder=new ArrayList<>();
            String sql ="SELECT oid,oname, otime, status, phone, movie_id"+" FROM orders;";
            psm = connection.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            
            while(rs.next())
            {
                order od =new order();
                od.setOname(rs.getString("oname"));
                od.setPhone(rs.getString("phone"));
                od.setStatus(rs.getBoolean("status"));
                od.setOtime(rs.getTimestamp("otime"));
                od.setOid(rs.getInt("oid"));
                // Tạo đối tượng Movie dựa trên movie_id
                moviedao mvdao =new moviedao();
                Movie movie = mvdao.GetMovie(request, connection, rs.getInt("movie_id"));
                od.setMovie(movie); // Đặt Movie vào order
                ListOrder.add(od);
            }
            rs.close();
            psm.close();
            
            return ListOrder;
        } catch (SQLException ex) {
            Logger.getLogger(orderdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void AddOrder (HttpServletRequest request, Connection connection, order Order){
        PreparedStatement psm =null;
        String sql = "INSERT INTO orders(oname, mvname, otime, status, phone, movie_id)"
                + " VALUES(?,?,?,?,?,?);";
        try{
            psm = connection.prepareStatement(sql);
            psm.setString(1, Order.getOname());
            psm.setString(2, Order.getMovie().getMvname());
            psm.setTimestamp(3, Order.getOtime());
            psm.setBoolean(4, true);
            psm.setString(5, Order.getPhone());
            psm.setInt(6, Order.getMovie().getMvid());
            psm.executeUpdate();
            psm.close();
        }catch(Exception e){
            System.out.println("Loi" + e);
        }
        return;
    }
    
    @Override
    public void DeleteOrder(HttpServletRequest request, Connection connection, int oid)
    {
        PreparedStatement psm= null;
        try {
        // Bước 1: Xóa order với oid cụ thể
        String sqlDelete = "DELETE FROM orders WHERE oid=?;";
        psm = connection.prepareStatement(sqlDelete);
        psm.setInt(1, oid);
        psm.executeUpdate();
        psm.close();
      } catch (SQLException e) {
        System.out.println("Lỗi khi xóa order: " + e.getMessage());
      } 
    }
    
    @Override
    public void UpdateOrder (HttpServletRequest request, Connection connection, int oid, String oname, Timestamp otime, String ophone, String mvname, int mvid) 
     {
        try {
            PreparedStatement psm=null;
            String sql = "UPDATE orders"
                    + " SET oname=?, otime=?, phone=?, mvname=?, movie_id=?"
                    + " WHERE oid=?;";
            psm=connection.prepareStatement(sql);
            psm.setString(1, oname);
            psm.setTimestamp(2, otime);
            psm.setString(3, ophone);
            psm.setString(4, mvname);
            psm.setInt(5, mvid);
            psm.setInt(6, oid);
            psm.executeUpdate();
            psm.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public int GetTotalIncomeByMonth(Connection conn, int year, int month)  {
        try {
            PreparedStatement psm = null;
            ResultSet rs = null;
            int totalIncome = 0;
            
            String sql = "SELECT SUM(mvprice) AS total_income " +
                    "FROM orders " +
                    "JOIN movie ON orders.movie_id = movie.mvid " +
                    "WHERE orders.status = TRUE " +
                    "AND YEAR(orders.otime) = ? " +
                    "AND MONTH(orders.otime) = ?";
            
            psm = conn.prepareStatement(sql);
            psm.setInt(1, year);
            psm.setInt(2, month);
            
            rs = psm.executeQuery();
            if (rs.next()) {
                totalIncome = rs.getInt("total_income");
            }
            
            
            return totalIncome;
        } catch (SQLException ex) {
            Logger.getLogger(orderdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
}
}

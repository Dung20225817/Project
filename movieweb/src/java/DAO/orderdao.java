/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.Connection;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Movie;
import models.order;

/**
 *
 * @author User
 */
public class orderdao {
    public ArrayList<order> GetOrder(HttpServletRequest request, Connection connection) throws SQLException{
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
    }
    
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
    
    public void DeleteOrder(HttpServletRequest request, Connection connection, int oid) throws SQLException
    {
        PreparedStatement psm= null;
        String sql =" DELETE FROM orders WHERE oid=?;";
        psm=connection.prepareStatement(sql);
        psm.setInt(1, oid);
        psm.executeUpdate();
        psm.close();
        
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Movie;
import java.sql.Timestamp;

public class moviedao {
    public void AddMovie(HttpServletRequest request,Connection connection, String mvname, Timestamp mvtime , String mvscript,double mvprice) throws SQLException{
        PreparedStatement psm=null;
        String sql= "INSERT INTO movie (\r\n" + "mvname, mvtime, mvscript, mvprice, mvstatus)\r\n" + " VALUES (?, ?, ?, ?, ?);";
        try{
        psm = connection.prepareStatement(sql);
	    psm.setString(1, mvname);
	    psm.setTimestamp(2, mvtime);
	    psm.setString(3, mvscript);// role
            psm.setDouble(4, mvprice);
            psm.setBoolean(5, true);
            
        int status =psm.executeUpdate();
        if(status > 0)
        {
            System.out.println("them movie thanh cong");
        }
        psm.close();
        }catch (Exception e)
        {
            String msg =e.toString();
            System.out.println("loi register" +msg);
        }
    }
    
    public void DeleteMovie(HttpServletRequest request,Connection connection,String mvname) {
       PreparedStatement psm =null;
       String sql ="UPDATE movie " + " SET mvstatus = ? " + " WHERE mvname = ? ;";
       try{
           psm = connection.prepareStatement(sql);
           psm.setBoolean(1, false);
           psm.setString(2, mvname);
         int status =psm.executeUpdate();
         if(status > 0)
         {
            System.out.println("xóa movie thanh cong");
         }
         psm.close();
       }catch(Exception e)
        {
            String msg =e.toString();
            System.out.println("loi register" +msg);
        }
    }
    public void UpdateMovie(HttpServletRequest request, Connection connection, Movie curmovie)
    {
        PreparedStatement psm =null;
        String sql="UPDATE movie"
                + " SET mvtime = ?, mvprice = ?, mvscript = ?, mvstatus = ? "
                + " WHERE mvid = ?;";
        try{
            psm = connection.prepareStatement(sql);
            psm.setTimestamp(1, curmovie.getMvtime());
            psm.setDouble(2, curmovie.getMvprice());
            psm.setString(3, curmovie.getMvscript());
            psm.setBoolean(4, true);
            psm.setInt(5, curmovie.getMvid());
            psm.executeUpdate();
            psm.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public ArrayList<Movie> GetMovie(HttpServletRequest request, Connection connection) throws SQLException{
        PreparedStatement psm = null;
       try { String sql =" SELECT mvname, mvprice, mvstatus, mvtime, mvscript, mvid "+" FROM movie;";
        psm = connection.prepareStatement(sql);
        ArrayList<Movie> ListMovie = new ArrayList<>();
        
        ResultSet rs =psm.executeQuery();
        while(rs.next()){
            Movie mv = new Movie();
            mv.setMvid(rs.getInt("mvid"));
            mv.setMvname(rs.getString("mvname"));
            mv.setMvprice(rs.getDouble("mvprice"));
            mv.setMvstatus(rs.getBoolean("mvstatus"));
            mv.setMvtime(rs.getTimestamp("mvtime"));
            mv.setMvscript(rs.getString("mvscript"));
            ListMovie.add(mv);
        }
        psm.close();
	return ListMovie;
       }catch (Exception e) {
			System.out.println("Error getting accounts: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
    }
}

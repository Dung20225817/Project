/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import IDAO.imoviedao;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Movie;
import java.sql.Timestamp;

public class moviedao implements imoviedao{

    @Override
    public void AddMovie(HttpServletRequest request, Connection connection, String mvname, Timestamp mvtime, String mvscript, double mvprice, String mvposter)  {
        PreparedStatement psm = null;
        String sql = "INSERT INTO movie (\r\n" + "mvname, mvtime, mvscript, mvprice, mvstatus, mvposter)\r\n" + " VALUES (?, ?, ?, ?, ?, ?);";
        try {
            psm = connection.prepareStatement(sql);
            psm.setString(1, mvname);
            psm.setTimestamp(2, mvtime);
            psm.setString(3, mvscript);// role
            psm.setDouble(4, mvprice);
            psm.setBoolean(5, true);
            psm.setString(6, mvposter);

            int status = psm.executeUpdate();
            if (status > 0) {
                System.out.println("them movie thanh cong");
            }
            psm.close();
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("loi register" + msg);
        }
    }

    @Override
    public void DeleteMovie(HttpServletRequest request, Connection connection, int mvid) {
        PreparedStatement psm = null;
        String sql = "UPDATE movie " + " SET mvstatus = ? " + " WHERE mvid = ? ;";
        try {
            psm = connection.prepareStatement(sql);
            psm.setBoolean(1, false);
            psm.setInt(2, mvid);
            int status = psm.executeUpdate();
            if (status > 0) {
                System.out.println("xóa movie thanh cong");
            }
            psm.close();
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("loi register" + msg);
        }
    }

    @Override
    public void UpdateMovie(HttpServletRequest request, Connection connection, Movie curmovie) {
        PreparedStatement psm = null;
        String sql = "UPDATE movie"
                + " SET mvtime = ?, mvprice = ?, mvscript = ?, mvstatus = ?, mvname = ? "
                + " WHERE mvid = ?;";
        try {
            psm = connection.prepareStatement(sql);
            psm.setTimestamp(1, curmovie.getMvtime());
            psm.setDouble(2, curmovie.getMvprice());
            psm.setString(3, curmovie.getMvscript());
            psm.setBoolean(4, true);
            psm.setString(5, curmovie.getMvname());
            psm.setInt(6, curmovie.getMvid());
            psm.executeUpdate();
            psm.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public ArrayList<Movie> GetListMovie(HttpServletRequest request, Connection connection) {
        PreparedStatement psm = null;
        try {
            String sql = " SELECT mvname, mvprice, mvstatus, mvtime, mvscript, mvid, mvposter " + " FROM movie;";
            psm = connection.prepareStatement(sql);
            ArrayList<Movie> ListMovie = new ArrayList<>();

            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                Movie mv = new Movie();
                mv.setMvid(rs.getInt("mvid"));
                mv.setMvname(rs.getString("mvname"));
                mv.setMvprice(rs.getDouble("mvprice"));
                mv.setMvstatus(rs.getBoolean("mvstatus"));
                mv.setMvtime(rs.getTimestamp("mvtime"));
                mv.setMvscript(rs.getString("mvscript"));
                mv.setMvposter(rs.getString("mvposter"));
                ListMovie.add(mv);
            }
            psm.close();
            return ListMovie;
        } catch (Exception e) {
            System.out.println("Error getting accounts: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Movie GetMovie(HttpServletRequest request, Connection connection, int mvid) {
        PreparedStatement psm = null;
        try {
            String sql = "SELECT mvname , mvprice, mvstatus, mvtime, mvscript, mvid, mvposter " + " FROM movie" + " WHERE mvid = ?";
            psm = connection.prepareStatement(sql);
            psm.setInt(1, mvid);
            ResultSet rs = psm.executeQuery();
            if (rs.next()) { // Kiểm tra nếu có dữ liệu
                Movie curmovie = new Movie();
                curmovie.setMvid(rs.getInt("mvid"));
                curmovie.setMvname(rs.getString("mvname"));
                curmovie.setMvscript(rs.getString("mvscript"));
                curmovie.setMvstatus(rs.getBoolean("mvstatus"));
                curmovie.setMvtime(rs.getTimestamp("mvtime"));
                curmovie.setMvprice(rs.getDouble("mvprice"));
                curmovie.setMvposter(rs.getString("mvposter"));
                rs.close();
                psm.close();
                return curmovie;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi nếu có
        }
        

        return null;
    }

    @Override
    public ArrayList<Movie> GetListMovieWeek(HttpServletRequest request, Connection connection){
        PreparedStatement psm = null;
        try {
            String sql = " SELECT m.mvname, m.mvprice, m.mvstatus, m.mvtime, m.mvscript, m.mvid, m.mvposter " + " FROM movie m \n" 
                    + "where m.mvtime > '2025-2-19 00:00:00' AND m.mvtime < '2025-2-27 00:00:00' AND m.mvstatus = 1 ;";
            psm = connection.prepareStatement(sql);
            ArrayList<Movie> ListMovie = new ArrayList<>();

            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                Movie mv = new Movie();
                mv.setMvid(rs.getInt("mvid"));
                mv.setMvname(rs.getString("mvname"));
                mv.setMvprice(rs.getDouble("mvprice"));
                mv.setMvstatus(rs.getBoolean("mvstatus"));
                mv.setMvtime(rs.getTimestamp("mvtime"));
                mv.setMvscript(rs.getString("mvscript"));
                mv.setMvposter(rs.getString("mvposter"));
                ListMovie.add(mv);
            }
            psm.close();
            return ListMovie;
        } catch (Exception e) {
            System.out.println("Error getting accounts: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}

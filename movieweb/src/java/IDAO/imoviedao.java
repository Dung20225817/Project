/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import models.Movie;

/**
 *
 * @author User
 */
public interface imoviedao {
    public void AddMovie(HttpServletRequest request, Connection connection, String mvname, Timestamp mvtime, String mvscript, double mvprice, String mvposter);
    public void DeleteMovie(HttpServletRequest request, Connection connection, int mvid);
    public void UpdateMovie(HttpServletRequest request, Connection connection, Movie curmovie);
    public ArrayList<Movie> GetListMovie(HttpServletRequest request, Connection connection);
    public Movie GetMovie(HttpServletRequest request, Connection connection, int mvid);
    public ArrayList<Movie> GetListMovieWeek(HttpServletRequest request, Connection connection);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAO.moviedao;
import dbconnect.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Movie;
/**
 *
 * @author User
 */
public class updatemovieservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updatemovieservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updatemovieservlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection conn = DBConnect.getJDBCConnection();
        moviedao mvdao = new moviedao();
        HttpSession ss=request.getSession();
        
        ArrayList<Movie> MovieList = new ArrayList<>();
        MovieList= mvdao.GetListMovie(request, conn);
        ss.setAttribute("MovieList", MovieList);
        request.getRequestDispatcher("UpdateMovie.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection conn =DBConnect.getJDBCConnection();
        moviedao mvdao = new moviedao();
        Movie curmovie = null;
        curmovie = mvdao.GetMovie(request, conn,Integer.parseInt(request.getParameter("id")));
        curmovie.setMvname(request.getParameter("mvname"));
        curmovie.setMvprice(Double.parseDouble(request.getParameter("price")));
        curmovie.setMvscript(request.getParameter("script"));
         String mvtimeStr = request.getParameter("time");  // "2025-01-29T14:30"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(mvtimeStr, formatter); // 2. Chuyển từ String -> LocalDateTime -> Timestamp (để lưu vào MySQL)
        curmovie.setMvtime(Timestamp.valueOf(localDateTime));
        
        mvdao.UpdateMovie(request, conn, curmovie);
        request.getRequestDispatcher("showhomepageservlet").forward(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

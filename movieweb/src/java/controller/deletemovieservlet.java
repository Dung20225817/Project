/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAO.moviedao;
import java.sql.Connection;
import dbconnect.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Movie;

/**
 *
 * @author User
 */
public class deletemovieservlet extends HttpServlet {

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
            out.println("<title>Servlet deletemovieservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet deletemovieservlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection conn =  DBConnect.getJDBCConnection();
        HttpSession ss= request.getSession();
        moviedao mvdao =new moviedao();
        ArrayList<Movie> ListMovie;
        try {
            ListMovie = mvdao.GetMovie(request, conn);
             ss.setAttribute("ListMovie", ListMovie);
             
        } catch (SQLException ex) {
            Logger.getLogger(deletemovieservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/DeleteMovie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection conn =  DBConnect.getJDBCConnection();
        HttpSession ss= request.getSession();
        moviedao mvdao =new moviedao();
        
        try {
            ArrayList<Movie> ListMovie = mvdao.GetMovie(request, conn);
            String curname = request.getParameter("curmvname");
            if( curname==null)
            {
                  String msg0="Loi không có dữ liệu";
                  ss.setAttribute("msg0", msg0);
                  request.getRequestDispatcher("/DeleteMovie.jsp").forward(request, response);
              }
            else{
             for(Movie mv: ListMovie){
              if(curname.equals(mv.getMvname())){
                  mvdao.DeleteMovie(request, conn, curname); 
                //  mv.setMvstatus(false);
                  request.getRequestDispatcher("/homepage.jsp").forward(request, response);
              }
             }
            }
        } catch (SQLException ex) {
            Logger.getLogger(deletemovieservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

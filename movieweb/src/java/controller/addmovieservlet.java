/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAO.moviedao;
import dbconnect.DBConnect;
import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class addmovieservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet admovieservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet admovieservlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection conn = DBConnect.getJDBCConnection();
        moviedao mvdao= new moviedao();
        
        String mvname = request.getParameter("movie");
        String mvtimeStr = request.getParameter("time");  // "2025-01-29T14:30"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(mvtimeStr, formatter); // 2. Chuyển từ String -> LocalDateTime -> Timestamp (để lưu vào MySQL)
        Timestamp mvtime = Timestamp.valueOf(localDateTime);
        String mvscript = request.getParameter("script");
        String mvposter =request.getParameter("mvposter");
        try{
        String priceParam = request.getParameter("price");
        Double mvprice = Double.parseDouble(priceParam);
        mvdao.AddMovie(request, conn, mvname, mvtime, mvscript, mvprice, mvposter);
        request.getRequestDispatcher("/homepage.jsp").forward(request, response);
        }catch (NumberFormatException e){
            System.out.println("Lỗi chuyển đổi số " + e.getMessage());
            request.setAttribute("error", "giá tiền không hợp lệ");
            request.getRequestDispatcher("/addmovie.jsp").forward(request, response);
        }      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

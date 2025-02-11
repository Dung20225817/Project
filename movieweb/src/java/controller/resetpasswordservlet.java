/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAO.accountdao;
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
import models.Account;

/**
 *
 * @author User
 */
public class resetpasswordservlet extends HttpServlet {

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
            out.println("<title>Servlet resetpasswordservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet resetpasswordservlet at " + request.getContextPath () + "</h1>");
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
        accountdao accdao = new accountdao();
        HttpSession ss =request.getSession();
        ss.setAttribute("ListAccount", accdao.GetListAccount(request, conn));
        request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection conn= DBConnect.getJDBCConnection();
        
        String username = request.getParameter("username");
        String oldpass = request.getParameter("oldpass");
        String newpass =request.getParameter("newpass");
        
        accountdao accdao = new accountdao();
        ArrayList<Account> ListAccount= accdao.GetListAccount(request, conn);
        for (Account acc : ListAccount) {
            if (acc.getUsername().equals(username) && acc.getPass().equals(oldpass) ) {
                accdao.ResetPassword(request, conn, username, oldpass, newpass);
                request.getRequestDispatcher("/homepage.jsp").forward(request, response);
                return;              
            }      
        }
        HttpSession ss =request.getSession();
        String msg= "WRONG PASS OR USERNAME";
        ss.setAttribute("msg5", msg);
        request.getRequestDispatcher("/resetpassword.jsp").forward(request, response);
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

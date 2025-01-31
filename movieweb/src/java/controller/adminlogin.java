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
import java.util.ArrayList;
import models.Account;

/**
 *
 * @author Account
 */
public class adminlogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = DBConnect.getJDBCConnection();
        accountdao accdao = new accountdao();
        ArrayList<Account> accList = accdao.getAccount(request, conn);
        HttpSession ss = request.getSession();
        
        String full_name = request.getParameter("Username");
        String password = request.getParameter("Password");
        String role = request.getParameter("role");
        
   
        for (Account acc : accList) {
            if (acc.getName().equals(full_name) && acc.getPass().equals(password) && acc.getRole().equals(role)) {
               if(role.equals("admin")){
                ss.setAttribute("account", acc);
                request.getRequestDispatcher("/homepage.jsp").forward(request, response);
                } 
            } else {
                String msg = "Wrong password or user name ";
                ss.setAttribute("msg0", msg);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
        }
        return;

    }
}

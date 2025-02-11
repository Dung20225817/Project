/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.feature;

import DAO.orderdao;
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
import models.order;

/**
 *
 * @author User
 */
public class incomeservlet extends HttpServlet {

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
            out.println("<title>Servlet incomeservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet incomeservlet at " + request.getContextPath () + "</h1>");
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
        orderdao odao =new orderdao();
        ArrayList<order> ListOrder = odao.GetListOrder(request, conn);
        int sumincome = 0;
        for(order curorder : ListOrder){
            if(curorder.isStatus()==true){
                sumincome+=curorder.getMovie().getMvprice(); 
            }
        }
        HttpSession ss = request.getSession();
        ss.setAttribute("sumincome", sumincome);
        request.getRequestDispatcher("income.jsp").forward(request, response);

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
        Connection conn = DBConnect.getJDBCConnection();
        orderdao odao =new orderdao();      
         try {
        int year = Integer.parseInt(request.getParameter("year"));
        

        int Income1 = odao.GetTotalIncomeByMonth(conn, year, 1);       
        request.setAttribute("Income1", Income1);
        int Income2 = odao.GetTotalIncomeByMonth(conn, year, 2);       
        request.setAttribute("Income2", Income2);
        int Income3 = odao.GetTotalIncomeByMonth(conn, year, 3);       
        request.setAttribute("Income3", Income3);
        int Income4 = odao.GetTotalIncomeByMonth(conn, year, 4);       
        request.setAttribute("Income4", Income4);
        int Income5 = odao.GetTotalIncomeByMonth(conn, year, 5);       
        request.setAttribute("Income5", Income5);
        int Income6 = odao.GetTotalIncomeByMonth(conn, year, 6);       
        request.setAttribute("Income6", Income6);
        int Income7 = odao.GetTotalIncomeByMonth(conn, year, 7);       
        request.setAttribute("Income7", Income7);
        int Income8 = odao.GetTotalIncomeByMonth(conn, year, 8);       
        request.setAttribute("Income8", Income8);
        int Income9 = odao.GetTotalIncomeByMonth(conn, year, 9);       
        request.setAttribute("Income9", Income9);
        int Income10 = odao.GetTotalIncomeByMonth(conn, year, 10);       
        request.setAttribute("Income10", Income10);
        int Income11 = odao.GetTotalIncomeByMonth(conn, year, 11);       
        request.setAttribute("Income11", Income11);
        int Income12 = odao.GetTotalIncomeByMonth(conn, year, 12);       
        request.setAttribute("Income12", Income12);
        request.getRequestDispatcher("income.jsp").forward(request, response);
    } catch (NumberFormatException ex) {
        ex.printStackTrace();
        request.setAttribute("error", "Lỗi khi tính tổng doanh thu!");
        request.getRequestDispatcher("income.jsp").forward(request, response);
    } finally {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
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

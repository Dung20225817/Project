/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import models.order;

/**
 *
 * @author User
 */
public interface iorderdao {
    public ArrayList<order> GetListOrder(HttpServletRequest request, Connection connection);
    public void AddOrder (HttpServletRequest request, Connection connection, order Order);
    public void DeleteOrder(HttpServletRequest request, Connection connection, int oid);
    public void UpdateOrder (HttpServletRequest request, Connection connection, int oid, String oname, Timestamp otime, String ophone, String mvname, int mvid);
     public int GetTotalIncomeByMonth(Connection conn, int year, int month);
     
}

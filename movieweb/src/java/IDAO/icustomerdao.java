/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.ArrayList;
import models.Customer;

/**
 *
 * @author User
 */
public interface icustomerdao {
    public ArrayList<Customer> GetListCustomer(HttpServletRequest request, Connection connection);
    
}

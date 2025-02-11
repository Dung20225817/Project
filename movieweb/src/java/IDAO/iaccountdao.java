/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.ArrayList;
import models.Account;

/**
 *
 * @author User
 */
public interface iaccountdao {
    public ArrayList<Account> GetListAccount(HttpServletRequest request, Connection connection);
    public Account GetAccount(HttpServletRequest request, Connection connection, int aid);
    public void AddAccount(HttpServletRequest request, Connection connection, String username, String pass, String role, String name, int age, String mail, String address, String phone, String image);
    public void DeleteAccount(HttpServletRequest request, Connection connection, int aid);
    public void UpdateAccount (HttpServletRequest request, Connection connection,int aid, String username, String name, int age, String phone, String mail, String address, String image );
    public void ResetPassword (HttpServletRequest request, Connection connection, String username, String oldpass, String newpass);
    
}

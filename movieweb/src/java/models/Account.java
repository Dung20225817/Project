/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Account
 */
public class Account {
    private String name;
    private String pass;
    private String role;
    private int aid;
    private static int count=0;
   

    public Account() {
    }

    public Account(String name, String pass, String role) {
        aid=count++;
        this.name = name;
        this.pass = pass;
        this.role = role;
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public int getAid() {
        return aid;
    }

    public String getRole() {
        return role;
    }
    

   
    public void setAid(int aid) {
        this.aid = aid;
    }

 
    
}

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
    private int aid;
    private static int count=0;
   

    public Account() {
    }

    public Account(String name, String pass) {
        aid=count++;
        this.name = name;
        this.pass = pass;
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

   
    public void setAid(int aid) {
        this.aid = aid;
    }

 
    
}

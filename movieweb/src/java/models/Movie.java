/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Timestamp;

/**
 *
 * @author User
 */
public class Movie {
    private String mvname;
    private Timestamp mvtime;
    private String mvscript;
    private int mvid;
    private static int count=0;
    private double mvprice;
    private boolean mvstatus=true;
    public Movie() {
    }

   

    public Movie(String name, Timestamp time, String script, double price)//dành cho bên quản lí
    {
        mvid=count++;
        this.mvname = name;
        this.mvtime = time;
        this.mvscript = script;
        this.mvprice = price;
        
       
    }

 

    public String getMvname() {
        return mvname;
    }

    public Timestamp getMvtime() {
        return mvtime;
    }

    public String getMvscript() {
        return mvscript;
    }

    public int getMvid() {
        return mvid;
    }

    public double getMvprice() {
        return mvprice;
    }

    public boolean isMvstatus() {
        return mvstatus;
    }
    
    

    public void setMvname(String mvname) {
        this.mvname = mvname;
    }

    public void setMvtime(Timestamp mvtime) {
        this.mvtime = mvtime;
    }

    public void setMvscript(String mvscript) {
        this.mvscript = mvscript;
    }



    public void setMvprice(double mvprice) {
        this.mvprice = mvprice;
    }


    public void setMvstatus(boolean mvstatus) {
        this.mvstatus = mvstatus;
    }

    public void setMvid(int mvid) {
        this.mvid = mvid;
    }

    
}

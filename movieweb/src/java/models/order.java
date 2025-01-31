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
public class order {
    private int oid;
    private static int count =0;
    private String oname;
    private Timestamp otime;
    private boolean status;
    private String phone; 
   
   private Movie movie;
   
   

    public order() {
    }

    public order( String oname, Timestamp otime, boolean status,String phone, Movie movie) {
        oid++;
        this.oname = oname;
        this.otime = otime;
        this.status = status;
        this.movie = movie;
        this.phone = phone;
        
        
    }

    public int getOid() {
        return oid;
    }

    public String getOname() {
        return oname;
    }



    public Timestamp getOtime() {
        return otime;
    }



    public boolean isStatus() {
        return status;
    }

    public String getPhone() {
        return phone;
    }

    
    public Movie getMovie() {
        return movie;
    }






    public void setOname(String oname) {
        this.oname = oname;
    }


    public void setOid(int oid) {
        this.oid = oid;
    }

    public void setOtime(Timestamp otime) {
        this.otime = otime;
    }



    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }



}
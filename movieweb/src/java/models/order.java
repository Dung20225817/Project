/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class order {
    private int oid;
    private static int count =0;
    private String oname;
    private  String mvname;
    private String mvtime;
    private boolean status;
    private String phone; 
   
   private Movie movie;
   
   

    public order() {
    }

    public order( String oname, String mvname, String mvtime, boolean status,String phone, Movie movie) {
        oid++;
        this.oname = oname;
        this.mvname = mvname;
        this.mvtime = mvtime;
        this.status = status;
        this.movie = movie;
        this.phone = phone;
        
        
    }

    public int getOid() {
        return oid;
    }

    public String getName() {
        return oname;
    }

    public String getMvname() {
        return mvname;
    }

    public String getMvtime() {
        return mvtime;
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






    public void setName(String oname) {
        this.oname = oname;
    }

    public void setMvname(String mvname) {
        this.mvname = mvname;
    }

    public void setMvtime(String mvtime) {
        this.mvtime = mvtime;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
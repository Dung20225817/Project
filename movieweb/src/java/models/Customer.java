/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author User
 */
public class Customer {
    private int customer_id;
    private String username;
    private String pass;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private Date dob; // Ngày sinh
    private Timestamp register_date;
    private Boolean status;
    private static int count;
    
    public Customer(){
        
    }

    public Customer(String username, String pass, String name, String email, String phone, String address, String gender, Date dob, Timestamp register_date, Boolean status) {
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
        this.register_date = register_date;
        this.status=status;
        customer_id=count++;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public Timestamp getRegister_date() {
        return register_date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setRegister_date(Timestamp register_date) {
        this.register_date = register_date;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
}

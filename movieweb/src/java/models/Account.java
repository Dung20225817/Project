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
    private String username;
    private String pass;
    private String role;
    private String name;
    private int age;
    private String mail;
    private String address;
    private String phone;
    private String image;
    private int aid;
    private static int count=0;
   

    public Account() {
    }

    public Account(String username, String pass, String role, String name, int age, String mail, String address, String phone,String image) {
        this.username = username;
        this.pass = pass;
        this.role = role;
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.address = address;
        this.phone = phone;
        this.image = image;
        aid=count++;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    public String getUsername() {
        return username;
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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public String getAddress() {
        return address;
    }
    

   
    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getPhone() {
        return phone;
    }

    public String getImage() {
        return image;
    }

 
    
}

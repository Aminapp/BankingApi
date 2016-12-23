package com.groupproject.apigroupproject.Models;

public class User {
    private  Integer id,pin;
    private  String fname,lname,address;
   
    public User(Integer id,Integer pin, String fname, String lname, String address){
         this.id = id;
         this.fname = fname;
         this.lname = lname;
         this.address = address;
         this.pin = pin;
                 
    }
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }   
}

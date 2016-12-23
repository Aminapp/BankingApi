package com.groupproject.apigroupproject.Models;

import javax.ws.rs.core.Cookie;

public class Login {
    
    private String fname,lname;
    private int pin;
    private Cookie cookie;
    
    public Login(String fname,String lname, int pin){
        this.fname = fname;
        this.lname = lname;
        this.pin = pin;
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

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }
}
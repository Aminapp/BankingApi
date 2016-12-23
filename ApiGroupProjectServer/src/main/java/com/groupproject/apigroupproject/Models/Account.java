package com.groupproject.apigroupproject.Models;

import java.util.Date;


public class Account {
    private String fname,lname,accountNumber,sortCode;
    private double balance;
    public Date creationDate;
    
    public Account(String fname,String lname,String accountNumber, String sortCode,float balance, Date creationDate){
        this.fname = fname;
        this.lname = lname;
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.balance = balance;
        this.creationDate = creationDate;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public float getBalance() {
        return (float)balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

package com.groupproject.apigroupproject.LocalDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Database {
    Connection dbConnect = null;
    Statement statement = null;
    ResultSet result = null;
   
    int dbRequest;

    String url = "jdbc:mysql://localhost:3306/";
    String user = "admin";
    String password = "password";
    
    public Connection Connect() throws SQLException{
        return DriverManager.getConnection(url, user, password);    
    }
    
    public boolean insertUser(int id, int pin, String fname,String lname, String address)throws SQLException{
        dbConnect = this.Connect();
        statement = dbConnect.createStatement();
        dbRequest = statement.executeUpdate("INSERT INTO users VALUES("+id+","+pin+",'"+fname+"','"+lname+"','"+address+"');");
         
        return true;
    }
    
    public boolean insertTransaction(String accountNumber,String accountType,String description, float balance,Date transactionDate)throws SQLException{
        dbConnect = this.Connect();
        statement = dbConnect.createStatement();
        dbRequest = statement.executeUpdate("INSERT INTO transactions VALUES("+"'"+accountNumber+"','"+accountType+"','"+description+"',"+balance+","+transactionDate+");");
         
        return true;
    }
    
    public boolean insertAccount(String fname,String lname,String accountNumber, String sortCode,float balance,Date creationDate)throws SQLException{
        dbConnect = this.Connect();
        statement = dbConnect.createStatement();
        dbRequest = statement.executeUpdate("INSERT INTO accounts VALUES("+"'"+fname+"','"+lname+"','"+accountNumber+"','"+sortCode+"',"+balance+","+creationDate+");");
         
        return true;
    }
}

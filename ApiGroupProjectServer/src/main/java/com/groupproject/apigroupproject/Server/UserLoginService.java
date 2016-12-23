package com.groupproject.apigroupproject.Server;

import com.groupproject.apigroupproject.LocalDatabase.Database;
import com.groupproject.apigroupproject.Models.Login;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.CookieParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

/**
 *WARNING WILL NOT WORK IF DATABASE IS NOT CONFIGURED!!
 */
public class UserLoginService {
    
    Map<Integer,Login> logList = new HashMap<>();
    Database db = new Database();
    Connection connection = null;
    Statement request = null;
    ResultSet result = null;
    
    public Response Login(String fname,String lname, int pin) throws SQLException, NoSuchAlgorithmException{
        connection = db.Connect();
        request = connection.createStatement();
              
        result = request.executeQuery("SELECT * FROM users WHERE fname ='"+fname+"' AND pin ='"+pin+"'");
        int count = 0;

        while (result.next()) {
        count++;
        }

        if (count == 1) {
            NewCookie cookie = new NewCookie("fname", fname);
            return Response.ok("OK").cookie(cookie).build();
        }else{
            return Response.status(400).entity("{Error: User not found}").build();
        }    
    }   
     public Boolean checkUserLogin(@CookieParam("fname") Cookie cookie) throws NullPointerException{
        return cookie != null;
    }
}
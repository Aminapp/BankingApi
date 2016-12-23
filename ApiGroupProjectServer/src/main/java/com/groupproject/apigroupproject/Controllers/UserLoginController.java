package com.groupproject.apigroupproject.Controllers;

import com.groupproject.apigroupproject.Server.UserLoginService;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/Login")
public class UserLoginController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(@Context UriInfo info,@CookieParam("email") Cookie cookie) throws ParseException, SQLException, NoSuchAlgorithmException{
        UserLoginService loginService = new UserLoginService();
        if(!loginService.checkUserLogin(cookie)){
            String fname = info.getQueryParameters().getFirst("fname");
            String lname = info.getQueryParameters().getFirst("lname");
            int pin = Integer.parseInt(info.getQueryParameters().getFirst("pin"));     
            
            try{
                return loginService.Login(fname,lname, pin);
            }catch(NoSuchAlgorithmException | SQLException e){
                return Response.status(400).entity("{Error: user not recognised}"+e).build();
            }
        }else{
            return Response.status(400).entity("{Error: user not recognised}").build();
        }
    }
}
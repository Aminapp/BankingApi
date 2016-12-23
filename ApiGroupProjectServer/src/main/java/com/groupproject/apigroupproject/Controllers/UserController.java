package com.groupproject.apigroupproject.Controllers;

import com.groupproject.apigroupproject.Models.User;
import com.groupproject.apigroupproject.LocalDatabase.Database;
import com.google.gson.Gson;
import com.groupproject.apigroupproject.Server.UserService;
import java.sql.SQLException;
import java.text.ParseException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/Users")
public class UserController {
    
    Database db = new Database();
    
    //Get all users 
    @GET
    @Produces("application/json")
    public Response getUsers() throws SQLException{
       Gson gson = new Gson();
       UserService service =  new UserService();
       return Response.status(200).entity(gson.toJson(service)).build();
    }
    //Get user by ID 
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getPayment(@PathParam("id") String id) throws SQLException{
       Gson gson = new Gson();
       UserService service =  new UserService();
       return Response.status(200).entity(gson.toJson(service.getId(Integer.parseInt(id)))).build();
    }
    //Create user 
    @POST
    @Path("/Create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(@Context UriInfo info) throws ParseException{
        Gson gson = new Gson();
        UserService service = new UserService();
        
        Integer pin = Integer.valueOf(info.getQueryParameters().getFirst("pin"));
        String fname = info.getQueryParameters().getFirst("fname");
	String lname = info.getQueryParameters().getFirst("lname");
        String address  = info.getQueryParameters().getFirst("address");
      
        try{
            User user = new User(service.increment(),pin,fname,lname,address);
            service.createUser(user);
            return Response.status(200).entity(gson.toJson("{User with first name "+fname+" has been created successfully}")).build();
        }catch(Exception e){
            return Response.status(200).entity(gson.toJson("{ No user created: Invalid credentials}")).build();
        }
    }
    
    //Update user by ID  
    @PUT
    @Path("/Update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserById(@Context UriInfo info,@PathParam("id") String id)throws SQLException{
        Gson gson = new Gson();
        UserService service = new UserService();
        
        Integer pin = Integer.valueOf(info.getQueryParameters().getFirst("pin"));
        String fname = info.getQueryParameters().getFirst("fname");
	String lname = info.getQueryParameters().getFirst("lname");
        String address  = info.getQueryParameters().getFirst("address");
        
        try{
            User user = new User(service.increment(),pin,fname,lname,address);
            service.updateUser(user);
            return Response.status(200).entity(gson.toJson("{User "+user+" updated successfully}")).build();
        }catch(Exception e){
            return Response.status(200).entity(gson.toJson("{ Error updating user }")).build();
        }
    }
    //Delete user by ID
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") String id){
        Gson gson = new Gson();
        UserService service = new UserService();
        try{
            service.deleteUserById(Integer.parseInt(id));
            return Response.status(200).entity(gson.toJson("{User with id "+id+" deleted successfully}")).build();
        }catch(NumberFormatException e){
            return Response.status(200).entity(gson.toJson("{ Error deleting user with ID of "+id+" }")).build();
        }
    }  
}

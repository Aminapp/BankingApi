package com.groupproject.apigroupproject.Controllers;

import com.groupproject.apigroupproject.Server.AccountService;
import com.google.gson.Gson;
import com.groupproject.apigroupproject.Models.Account;
import java.text.ParseException;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/Accounts")
public class AccountController {
    //Get all accounts
    @GET
    @Produces("application/json")
    public Response getAccounts(){
        Gson gson = new Gson();
        AccountService service =  new AccountService();
        return Response.status(200).entity(gson.toJson(service)).build();
    }
    //Get accounts by id 
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getAccountById(@PathParam("id") String id){
       Gson gson = new Gson();
       AccountService service =  new AccountService();
       
       return Response.status(200).entity(gson.toJson(service.getId(Integer.parseInt(id)))).build();
    }
    //Create account
    @POST
    @Path("/Create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAccount(@Context UriInfo info) throws ParseException{
        Gson gson = new Gson();
        AccountService service = new AccountService();
        
        String fname = info.getQueryParameters().getFirst("fname");
        String lname = info.getQueryParameters().getFirst("lname");
        String sortCode = info.getQueryParameters().getFirst("sortCode");
	float balance = 0;
        Date date = new Date();
                
        try{
            Account account = new Account(fname,lname,String.valueOf(service.increment()),sortCode, balance,date);
            service.createAccount(account);
            return Response.status(200).entity(gson.toJson("{Account created successfully}")).build();

        }catch(Exception e){
            return Response.status(200).entity(gson.toJson("{Account creation failed}")).build();
        }
    }
    //Delete account 
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAccountById(@PathParam("id") String id){
        Gson gson = new Gson();
        AccountService service = new AccountService();
        try{
            service.deleteAccountById(Integer.parseInt(id));
            return Response.status(200).entity(gson.toJson("{Account deleted successfully}")).build();
        }catch(NumberFormatException e){
            return Response.status(200).entity(gson.toJson("{Account deletion failed}")).build();
        }
    }
}

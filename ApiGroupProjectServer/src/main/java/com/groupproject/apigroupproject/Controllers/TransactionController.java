package com.groupproject.apigroupproject.Controllers;

import com.groupproject.apigroupproject.Models.Transaction;
import com.groupproject.apigroupproject.Server.TransactionService;
import com.google.gson.Gson;
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

@Path("/Transaction")
public class TransactionController {
    //Get all transactions that have been made
    @GET
    @Produces("application/json")
    public Response getTransaction(){
        Gson gson = new Gson();
       TransactionService service =  new TransactionService();
       return Response.status(200).entity(gson.toJson(service)).build();
    }
    //Get a transaction by id 
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getTransaction(@PathParam("id") String id){
       Gson gson = new Gson();
       TransactionService service =  new TransactionService();
       
       return Response.status(200).entity(gson.toJson(service.getId(Integer.parseInt(id)))).build();
    }
    //Create a transaction
    @POST
    @Path("/Add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTransaction(@Context UriInfo info) throws ParseException{
        Gson gson = new Gson();
        TransactionService service = new TransactionService();
        
        String accountNumber = info.getQueryParameters().getFirst("accountNumber");
        String accountType = info.getQueryParameters().getFirst("accountType");
	String description = info.getQueryParameters().getFirst("description");
        float balance = Float.parseFloat(info.getQueryParameters().getFirst("pin"));
        Date date = new Date();
        
        try{
            Transaction transaction = new Transaction(accountNumber, accountType, description, balance, date);
            service.MakeTransaction(transaction);
            return Response.status(200).entity(gson.toJson("{Transaction successful}")).build();
        }catch(Exception e){
            return Response.status(200).entity(gson.toJson("{Transaction failed}")).build();
        }
    }
    //Delete transaction by id 
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTransaction(@PathParam("id") String id){
        Gson gson = new Gson();
        TransactionService service = new TransactionService();
        
        try{
            service.deleteTransactionById(Integer.parseInt(id));
            return Response.status(200).entity(gson.toJson("{Transaction deleted}")).build();
        }catch(NumberFormatException e){
            return Response.status(200).entity(gson.toJson("{Error deleting Transaction}")).build();
        }
    } 
}

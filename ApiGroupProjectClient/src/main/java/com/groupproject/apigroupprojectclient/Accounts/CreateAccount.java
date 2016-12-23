package com.groupproject.apigroupprojectclient.Accounts;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CreateAccount {
    public static void main(String[] args) {

        Client client = Client.create();
        int port = 8080;
        String fname = "test";
        String lname = "test";
        String sortCode = "test";
        String params = "?fname="+fname+"&lname="+lname+"&sortCode="+sortCode;
        String Url = "http://localhost:" + port + "/bank/Accounts/Create/"+ params;

        WebResource target = client.resource(Url);
            
        ClientResponse response = target.post(ClientResponse.class);
        
        System.out.println(response.getEntity(String.class));
    }
}

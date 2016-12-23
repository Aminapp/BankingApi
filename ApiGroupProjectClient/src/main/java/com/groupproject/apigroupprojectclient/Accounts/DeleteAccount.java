package com.groupproject.apigroupprojectclient.Accounts;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DeleteAccount {

    public static void main(String[] args) {
        String Url = "http://localhost:8080/bank/Accounts/2";
        
        Client client = Client.create();
        WebResource target = client.resource(Url);       

        ClientResponse response = target.delete(ClientResponse.class);
        
        System.out.println(response.getEntity(String.class));
    }
}
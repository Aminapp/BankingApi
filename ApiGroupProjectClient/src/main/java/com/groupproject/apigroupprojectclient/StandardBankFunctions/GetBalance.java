package com.groupproject.apigroupprojectclient.StandardBankFunctions;

import com.groupproject.apigroupprojectclient.Accounts.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetBalance {
    
    public static void main(String[] args) {
        String Url = "http://localhost:8080/bank/Accounts/Balance/2";
        
        Client client = Client.create();
        WebResource target = client.resource(Url);

        ClientResponse response = target.get(ClientResponse.class);
        
        System.out.println(response.getEntity(String.class));
    }
}

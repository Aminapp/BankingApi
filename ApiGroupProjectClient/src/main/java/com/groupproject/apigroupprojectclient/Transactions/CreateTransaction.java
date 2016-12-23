package com.groupproject.apigroupprojectclient.Transactions;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CreateTransaction {
    public static void main(String[] args) {

        Client client = Client.create();
        int port = 8080;
        int pin = 2345;
        String accountNumber = "1234";
        String accountType = "Credit";
        String description = "testPayment";
        String params = "?accountNumber="+accountNumber+"&accountType="+accountType+"&description="+description+"&pin="+pin;
        String Url = "http://localhost:" + port + "/bank/Transaction/Add/"+ params;

        WebResource target = client.resource(Url);
            
        ClientResponse response = target.post(ClientResponse.class);
        
        System.out.println(response.getEntity(String.class));
    }
}

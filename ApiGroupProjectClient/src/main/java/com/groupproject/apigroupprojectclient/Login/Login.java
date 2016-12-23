package com.groupproject.apigroupprojectclient.Login;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Login {
    
public static void main(String[] args) {

        Client client = Client.create();
        int port = 8080;
        int pin = 2345;
        String fname = "test";
        String lname = "test";
        String params = "?pin="+pin+"&fname="+fname+"&lname="+lname;
        String Url = "http://localhost:" + port + "/bank/Login/"+ params;

        WebResource target = client.resource(Url);
            
        ClientResponse response = target.post(ClientResponse.class);
        
        System.out.println(response.getEntity(String.class));
    }
}

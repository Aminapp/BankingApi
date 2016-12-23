package com.groupproject.apigroupprojectclient.StandardBankFunctions;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WithdrawMoney {
    public static void main(String[] args) {

        Client client = Client.create();
        int port = 8080;
        String amount = "123.45";
        String params = "?amount="+amount;
        String Url = "http://localhost:" + port + "/bank/Accounts/Withdrawal/1"+ params;

        WebResource target = client.resource(Url);
            
        ClientResponse response = target.post(ClientResponse.class);
        
        System.out.println(response.getEntity(String.class));
    }
}

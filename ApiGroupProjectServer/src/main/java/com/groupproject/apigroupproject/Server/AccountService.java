package com.groupproject.apigroupproject.Server;

import com.groupproject.apigroupproject.LocalDatabase.Database;
import com.groupproject.apigroupproject.Models.Account;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

//DATABASE FUNCTIONALITY HAS BEEN COMMENTED OUT FOR TESTING PURPOSES 
//ONCE A DATABASE IS CREATED IT WILL FUNCTION AS EXPECTED

public class AccountService {
    //Setup hashmap for accounts being added to the api
    HashMap<Integer,Account> accountList = new HashMap<>(); 
    int accountNumberInit = accountList.size();
    Database db = new Database();
    
    public AccountService(){
        
        Account account1 = new Account("Steven","Hoskins","1","932523",(float)7000.00,new Date());
        Account account2 = new Account("Steven","Hoskins","2","987654",(float)4250.87,new Date());
        Account account3 = new Account("Steven","Hoskins","3","700985",(float)-32.60,new Date());
        Account account4 = new Account("Daniel","Craig","4","932523",(float)23.60,new Date());
        Account account5 = new Account("Liam","O'Reilly","5","0098655",(float)325.60,new Date());
        
        accountList.put(1,account1);
        accountList.put(2,account2);
        accountList.put(3,account3);
        accountList.put(4,account4);
        accountList.put(5,account5);
    }
    
    public Account getId(int id){
        Account account = accountList.get(id);
        return account;
    }
    
    public Account createAccount(Account account) throws SQLException{
        accountList.put(accountNumberInit+1,account);
        //db.insertAccount(account.getFname(),account.getLname(),account.getAccountNumber(),account.getSortCode(),account.getBalance(),account.getCreationDate());
        return account;
    }
    
    public Account updateAccount(Account account){
        if(Integer.valueOf(account.getAccountNumber())<=0){
            return null;
        }
        accountList.put(Integer.valueOf(account.getAccountNumber()),account);
        return account;
    }
    
    public Account updateBalance(Account account, double balance){
        if(Integer.valueOf(account.getAccountNumber())<=0){
            return null;
        }
        account = new Account(account.getFname(),account.getLname(),account.getAccountNumber(),account.getSortCode(),(float) balance,account.getCreationDate());
        accountList.put(Integer.valueOf(account.getAccountNumber()),account);
        return account;
    }
    
    public void deleteAccountById(int id){
        accountList.remove(id);
    }
    
   public int increment(){
        return accountList.size()+1;
    }
}

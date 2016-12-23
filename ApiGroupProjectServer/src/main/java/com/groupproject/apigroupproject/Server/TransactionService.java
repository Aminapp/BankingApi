package com.groupproject.apigroupproject.Server;

import com.groupproject.apigroupproject.LocalDatabase.Database;
import com.groupproject.apigroupproject.Models.Transaction;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//DATABASE FUNCTIONALITY HAS BEEN COMMENTED OUT FOR TESTING PURPOSES 
//ONCE A DATABASE IS CREATED IT WILL FUNCTION AS EXPECTED

public class TransactionService {
    
    Map<Integer,Transaction> transactionList = new HashMap<>();
    int accountNumberInit = transactionList.size();
    Database db = new Database();
    
    public TransactionService(){
        AccountService service = new AccountService();
        
        Transaction trans1 = new Transaction("1","Debit","Payment to P.Farrell",(float)-200.00,new Date());
        Transaction trans2 = new Transaction("2","Debit","Payment to Dunnes Stores",(float)-52.28,new Date());
        Transaction trans3 = new Transaction("3","Credit","Payment to Aviva Health insurance",(float)-2000.00,new Date());
        Transaction trans4 = new Transaction("4","Debit","Payment to Lagoona",(float)-72.89,new Date());
        Transaction trans5 = new Transaction("5","Credit","Payment to Joe duffy motors",(float)-35000.00,new Date());
        
        transactionList.put(1,trans1);
        service.updateBalance(service.getId(1), (float)-200.00);
        transactionList.put(2,trans2);
        service.updateBalance(service.getId(2), (float)-52.28);
        transactionList.put(3,trans3);
        service.updateBalance(service.getId(3), (float)-2000.00);
        transactionList.put(4,trans4);
        service.updateBalance(service.getId(4), (float)-72.89);
        transactionList.put(5,trans5);
        service.updateBalance(service.getId(5), (float)-35000.00);     
    }
    
    public Transaction getId(Integer id){
        Transaction transaction = transactionList.get(id);
        return transaction;
    }
    
    public Transaction MakeTransaction(Transaction transaction) throws SQLException{
        transaction.setAccountNumber(String.valueOf(accountNumberInit+1));
        transactionList.put(Integer.valueOf(transaction.getAccountNumber()),transaction);
        //db.insertTransaction(transaction.getAccountNumber(),transaction.getAccountType(),transaction.getDescription(),transaction.getBalance(),transaction.getTransactionDate());
        return transaction;
    }
    
    public Transaction updateTransaction(Transaction transaction){
        if(Integer.valueOf(transaction.getAccountNumber())<=0){
            return null;
        }
        transactionList.put(Integer.valueOf(transaction.getAccountNumber()),transaction);
        return transaction;
    }
    
    public void deleteTransactionById(int id){
        transactionList.remove(id);
    }
    
    public int increment(){
        return transactionList.size()+1;
    }  
}

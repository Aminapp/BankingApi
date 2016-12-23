package com.groupproject.apigroupproject.Server;

import com.groupproject.apigroupproject.Models.User;
import com.groupproject.apigroupproject.LocalDatabase.Database;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//DATABASE FUNCTIONALITY HAS BEEN COMMENTED OUT FOR TESTING PURPOSES 
//ONCE A DATABASE IS CREATED IT WILL FUNCTION AS EXPECTED


public class UserService {
    
    Map<Integer,User> userList = new HashMap<>();
    Database db = new Database();
    
    public UserService(){
        User userAccount1 = new User(1,2345,"Steven","Hoskins","4 Glenvale row, Yorkshire,UK");
        User userAccount2 = new User(2,6789,"Conor","McGrath","4 Howth road, Howth, Co.Dublin,IE");
        User userAccount3 = new User(3,6598,"Craig","Eisenhower","64 Springfield Avenue,CA,US");
        User userAccount4 = new User(4,3495,"Daniel","Craig","64 Bondville Avenue,CA,US");
        User userAccount5 = new User(5,2238,"Liam","O'Reilly","64 River Valley heights,Co.Dublin,IE");
        
        userList.put(1,userAccount1);
        userList.put(2,userAccount2);
        userList.put(3,userAccount3);
        userList.put(4,userAccount4);
        userList.put(5,userAccount5);
    }
    
    public User getId(int id){
        User user = userList.get(id);
        return user;
    }
    
    public User createUser(User user) throws SQLException{
        user.setId(userList.size()+1);
        userList.put(user.getId(),user);
//db.insertUser(user.getId(),user.getPin(),user.getFname(),user.getLname(),user.getAddress());
        return user;
    }
    
    public User updateUser(User user){
        if(user.getId()<=0){
            return null;
        }
        userList.put(user.getId(),user);
        return user;
    }
    
    public void deleteUserById(int id){
        userList.remove(id);
    }
    
    public int increment(){
        return userList.size()+1;
    }
    
}

package com.Starkindustries.SpringDataJpaMark1.Service;

import com.Starkindustries.SpringDataJpaMark1.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceWithoutDatabase {

    public List<User> userList = new ArrayList<>(List.of(
            new User(1,"Aditya","kelaskaraditya1@gmail.com","kelaskaraditya1","Aditya@12234"),
            new User(2,"Mayur","mayurkhatal1@gmail.com","mayur1","Mayur@1234"),
            new User(3,"Sandesh","sandy1@gmail.com","sandy1","Sandy@1234"),
            new User(4,"Aaryaman","aaryaman1@gmail.com","aaryaman1","Aaryaman@124"),
            new User(5,"Parth","parth1@gmail.com","parth1","Parth@1234")));

    public User insertuser(User user){
        userList.add(user);
        return user;
    }

    public List<User> getAllusers(){
        return userList;
    }

    public  User getUser(int userId){
        User user1 = null;
        try{

            user1 = userList
                    .stream()
                    .filter(user->user.getUserId()==userId)
                    .findFirst()
                    .get();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user1;
    }

   public  boolean deleteUSer(int userId){
        User userFound = userList.stream().filter(user->user.getUserId()==userId).findFirst().get();
        if(userList.contains(userFound)){
            userList.remove(userFound);
            return true;
        }
        return false;
   }

   public  boolean updateUser(int userId,User user){

        userList=userList.stream().map(u->{
            if(u.getUserId()==userId){
                u.setUsername(user.getUsername());
                u.setName(user.getName());
                u.setPassword(user.getPassword());
                u.setEmail(user.getEmail());
            }
            return u;
        }).toList();
        return true;

//        for(int i=0;i<userList.size();i++){
//            if(userList.get(i).getUserId()==userId){
//                userList.set(i,user);
//
//            }
//        }
   }
}

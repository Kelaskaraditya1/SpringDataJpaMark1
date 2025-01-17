package com.Starkindustries.SpringDataJpaMark1.Service;

import com.Starkindustries.SpringDataJpaMark1.Model.User;
import com.Starkindustries.SpringDataJpaMark1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public boolean insertUser(User user){
        userRepository.save(user);
        return true;
    }

    public boolean updateUser(User user,int userId){
        if(userRepository.findById(userId).isPresent()){
            Optional<User> optionalUser = userRepository.findById(userId);
            User user1 = optionalUser.get();
            user1.setEmail(user.getEmail());
            user1.setName(user.getName());
            user1.setPassword(user.getPassword());
            user1.setUsername(user.getUsername());
            userRepository.save(user1);
            return true;
        }
        return false;
    }

    public List<User> getUsers(){
        List<User> userList = (List<User>) userRepository.findAll();
        return userList;

    }

    public boolean deleteUSer(int userId){
        if(userRepository.findById(userId).isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
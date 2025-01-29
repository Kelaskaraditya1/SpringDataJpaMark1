package com.Starkindustries.SpringDataJpaMark1.Service;

import com.Starkindustries.SpringDataJpaMark1.Model.User;
import com.Starkindustries.SpringDataJpaMark1.Repository.PagingAndSortingRepository;
import com.Starkindustries.SpringDataJpaMark1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PagingAndSortingRepository pagingAndSortingRepository;

    public User insertUser(User user){
        userRepository.save(user);
        return user;
    }

    public User updateUser(User user,int userId){
        if(userRepository.findById(userId).isPresent()){
            Optional<User> optionalUser = userRepository.findById(userId);
            User user1 = optionalUser.get();
            user1.setEmail(user.getEmail());
            user1.setName(user.getName());
            user1.setPassword(user.getPassword());
            user1.setUsername(user.getUsername());
            userRepository.save(user1);
            return user1;
        }
        return null;
    }

    public List<User> getUsers(){
        List<User> userList = (List<User>) userRepository.findAll();
        Iterable<User> iterable = userRepository.findAll();
        Iterator<User> iterator = iterable.iterator();
        return userList;

    }

    public boolean deleteUSer(int userId){
        if(userRepository.findById(userId).isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }


    public User getUser(int userId){
        if(userRepository.existsById(userId))
            return userRepository.findById(userId).get();
        return null;
    }

    public User getUserByUsername(String name) {
        User user = userRepository.findByUsername(name);
        if (user == null) {
            throw new RuntimeException("User not found with name: " + name);
        }
        return user;
    }

    public User getUserByUsernameAndName(String username,String name){
        User user = userRepository.findByUsernameAndName(username,name);
        if(user!=null)
            return user;
        return null;
    }

    public List<User> getNamesContaining(String pattern){
        Sort sort = Sort.by(Sort.Direction.DESC,"userId");
       return  userRepository.findByNameContaining(pattern,sort);
    }


    public List<User> getUserUsingPaging(int pageNo,int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(Sort.Direction.DESC,"userId","name"));
        return pagingAndSortingRepository.findAll(pageable).getContent();
    }

}

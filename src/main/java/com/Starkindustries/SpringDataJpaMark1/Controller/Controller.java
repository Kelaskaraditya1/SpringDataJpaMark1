package com.Starkindustries.SpringDataJpaMark1.Controller;

import com.Starkindustries.SpringDataJpaMark1.Model.User;
import com.Starkindustries.SpringDataJpaMark1.Service.UserService;
import com.Starkindustries.SpringDataJpaMark1.Service.UserServiceWithoutDatabase;
import jakarta.persistence.PostRemove;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    public UserService userService;

    @Autowired
    public UserServiceWithoutDatabase userServiceWithoutDatabase;

    @GetMapping("/hello")
    public String greetings(){
        return "Greetings!!\nI am Optimus Prime";
    }

    @PostMapping("/insert")
    public ResponseEntity<User> addUsers(@Valid @RequestBody User user){
        User user1 = null;
        try{
            user1=userServiceWithoutDatabase.insertuser(user);
            return ResponseEntity.of(Optional.of(user1));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PutMapping("/update/{userId}")
    public String updateUser(@RequestBody User user,@PathVariable("userId") int userId){
        if(userServiceWithoutDatabase.updateUser(userId,user))
            return "User Updated Successfully!!";
        return "Failed to Update User!!";
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<User>> getStudents(){
        if(userServiceWithoutDatabase.getAllusers().isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(userServiceWithoutDatabase.getAllusers()));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId){

        try{
            userServiceWithoutDatabase.deleteUSer(userId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") int userId){
        if(userServiceWithoutDatabase.getUser(userId)==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(userServiceWithoutDatabase.getUser(userId)));
    }

//    @GetMapping("/user/{name}")
//    public User getUserByName(@PathVariable("name") String name){
//        return userService.getUserByName(name);
//    }
}

package com.Starkindustries.SpringDataJpaMark1.Controller;

import com.Starkindustries.SpringDataJpaMark1.Model.User;
import com.Starkindustries.SpringDataJpaMark1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    public UserService userService;

    @GetMapping("/hello")
    public String greetings(){
        return "Greetings!!\nI am Optimus Prime";
    }

    @PostMapping("/insert")
    public String addUsers(@RequestBody User user){
        if(userService.insertUser(user))
            return "User inserted Successfully!!";
        return "Failed to add user!!";
    }

    @PutMapping("/update/{userId}")
    public String updateUser(@RequestBody User user,@PathVariable("userId") int userId){
        if(userService.updateUser(user,userId))
            return "User Updated Successfully!!";
        return "Failed to Update User!!";
    }

    @GetMapping("/users")
    public List<User> getStudents(){
        return userService.getUsers();
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") int userId){
        if(userService.deleteUSer(userId))
            return "User deleted Successfully";
        return "User doesn't exist";
    }
}

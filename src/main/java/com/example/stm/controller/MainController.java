package com.example.stm.controller;
import com.example.stm.model.User;
import com.example.stm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    private UserService userService;
        @Autowired
        public MainController(UserService userService){
            this.userService = userService;
        }
        @PostMapping("/users/register")
        public User registerUser(
            @RequestParam("userId") int userId,
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password
        ){
            User user = new User(userId, name, lastName, email, password);  // definition and init of User class object
            return userService.addUser(user);

        }

        @GetMapping("/users")
        public List<User> getAllUsers(){
            return userService.getAllUsers();
        }

}

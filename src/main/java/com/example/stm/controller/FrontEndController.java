package com.example.stm.controller;

import com.example.stm.model.User;
import com.example.stm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller // class that mapping http request method for
            // java methods and returns name of html view
public class FrontEndController {
    private UserService userService;
    @Autowired
    public FrontEndController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "userView";
    }
}

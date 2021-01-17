package com.example.stm.controller;
import com.example.stm.model.User;
import com.example.stm.model.Task;
import com.example.stm.service.UserService;
import com.example.stm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    private UserService userService;
    private TaskService taskService;
        @Autowired
        public MainController(UserService userService, TaskService taskService){
            this.userService = userService;
            this.taskService = taskService;
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

        @GetMapping("users/findById")
        public Optional<User> getUserByUserId(@RequestParam("userId") int userId){
            return userService.getUserByUserId(userId);
        }

        @PutMapping("/users/changeStatus")
        public User updateStatus(@RequestParam("userId") int userId, @RequestParam("newStatus") Boolean newStatus){
            return userService.updateStatus(userId,newStatus);
        }

        @DeleteMapping("/users/delete/{userId}")
        public boolean deleteUserById(@PathVariable("userId") int userId){
            return userService.deleteUserById(userId);
        }



        @PostMapping("/Task/createTask")
        public Task createTaskByUser(
                @RequestParam("title") String title,
                @RequestParam("description") String description,
                @RequestParam("type") Task.Type type,
                @RequestParam("status") Task.Status status,
                @RequestParam("userId") int userId
        ){
            Task task = new Task(title, description, type, status);  // definition and init of Task class object
            return taskService.addTaskByUser(task, userId);

        }

        @GetMapping("/tasks")
        public List<Task> getAllTasks(){ return taskService.getAllTasks(); }

}

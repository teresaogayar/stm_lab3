package com.example.stm.service;
import com.example.stm.model.Task;
import com.example.stm.model.User;
import com.example.stm.repository.TaskRepository;
import com.example.stm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public Task addTaskByUser(Task newTask, int userId){
        Task task = null;
        User user;
        Optional<User> temp = userRepository.findById(userId);
        if(temp.isPresent()){
            user = temp.get();
            newTask.setUser(user);
            task = taskRepository.save(newTask);
        }
        return task;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
}

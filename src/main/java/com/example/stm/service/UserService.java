package com.example.stm.service;
import com.example.stm.model.User;
import com.example.stm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserByUserId(int userId) {
        if (userRepository.existsById(userId)) {
            return userRepository.findById(userId);
        } else {
            return null;
        }
    }

    public User updateStatus(int userId, boolean newStatus){
        User user =null;
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User userToUpdate= userOptional.get();
            userToUpdate.setStatus(newStatus);
            user = userRepository.save(userToUpdate);
        }
        return user;
    }
}


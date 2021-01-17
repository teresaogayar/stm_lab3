package com.example.stm.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime registrationDateTime=LocalDateTime.now();
    private boolean status=false;
    @OneToMany
    @JoinTable(                     // association (relation) table
            name = "user_to_tasks",
            joinColumns = @JoinColumn(name = "user_Id"),
            inverseJoinColumns = @JoinColumn(name = "task_Id")
    )
    private Set<Task> tasks = new HashSet<>();

    public User(int userId, String name, String lastName, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registrationDateTime = registrationDateTime;
        this.status = status;
    }



}
package com.example.stm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    private String title;
    private String description;
    private LocalDateTime dateAdded=LocalDateTime.now();
    private Type type;
    private Status status;
    private enum Type{TASK, BUG, FEATURE};
    private enum Status{NEW,IN_PROGRESS,DONE};

    @ManyToOne
    private User user;


    public Task(String title, String description, Type type, Status status) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = status;
    }

}
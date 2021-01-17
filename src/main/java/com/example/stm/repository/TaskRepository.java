package com.example.stm.repository;
import com.example.stm.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    Task findFirstByTitle(String title);
}
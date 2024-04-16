package com.example.client_1.repository;

import com.example.client_1.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITask extends JpaRepository<Task,Long> {
}

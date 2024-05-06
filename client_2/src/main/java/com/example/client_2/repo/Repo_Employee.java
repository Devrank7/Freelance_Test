package com.example.client_2.repo;

import com.example.client_2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Employee extends JpaRepository<Employee,Integer> {
}

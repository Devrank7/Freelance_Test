package com.example.client_2.repo;

import com.example.client_2.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Project extends JpaRepository<Project,Integer> {

}

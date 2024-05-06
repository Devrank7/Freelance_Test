package com.example.client_2.repo;

import com.example.client_2.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Home extends JpaRepository<House,Integer> {
}

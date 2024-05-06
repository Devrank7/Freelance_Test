package com.example.client_1.repository;

import com.example.client_1.model.User_ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_usr_id extends JpaRepository<User_ID,Integer> {


}

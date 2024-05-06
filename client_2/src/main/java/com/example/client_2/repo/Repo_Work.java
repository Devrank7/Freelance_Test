package com.example.client_2.repo;

import com.example.client_2.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Work extends JpaRepository<Work,Integer> {


}

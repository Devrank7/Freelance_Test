package com.example.client_2.repo;

import com.example.client_2.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface Repo_Library extends JpaRepository<Library,Integer> {

}

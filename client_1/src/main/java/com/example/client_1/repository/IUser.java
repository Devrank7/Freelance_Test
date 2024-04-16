package com.example.client_1.repository;

import com.example.client_1.model.BUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<BUser,Integer> {
    @Query(value = "select * from userf where name = :name",nativeQuery = true)
    public BUser findBUserByName(@Param("name") String name);

}

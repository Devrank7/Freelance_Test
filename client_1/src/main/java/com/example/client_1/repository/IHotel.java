package com.example.client_1.repository;

import com.example.client_1.model.BHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHotel extends JpaRepository<BHotel,Integer> {

}

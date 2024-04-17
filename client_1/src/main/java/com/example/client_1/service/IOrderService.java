package com.example.client_1.service;

import com.example.client_1.model.BHotel;

import java.util.List;

public interface IOrderService {

    List<BHotel> sorted(List<BHotel> hotels);
}

package com.example.client_1.service;

import com.example.client_1.model.BHotel;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class ServiceSortedByGrade implements IOrderService {

    @Override
    public List<BHotel> sorted(List<BHotel> hotels) {
        return hotels.stream().sorted(Comparator.comparing(BHotel::getGrate)).toList();
    }
}

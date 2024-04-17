package com.example.client_1.service;

import com.example.client_1.model.BHotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategySortedBy {

    public List<BHotel> sorted(IOrderService service,List<BHotel> bHotels) {
        return service.sorted(bHotels);
    }
}

package com.example.client_1;

import com.example.client_1.model.BHotel;
import com.example.client_1.service.ServiceOrderByGrade;
import com.example.client_1.service.ServiceSortedByPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class Client1ApplicationTests {
    @InjectMocks
    private ServiceSortedByPrice sorted;
    @InjectMocks
    private ServiceOrderByGrade serviceOrderByGrade;

    @Test
    void contextLoads() {
        List<BHotel> bHotelList = List.of(new BHotel("bob",(byte) 70,300,""),new BHotel("bob",(byte) 70,100,"")
        ,new BHotel("bob",(byte) 70,800,""));
        List<BHotel> bHotels = bHotelList.stream().sorted(Comparator.comparing(BHotel::getPrice)).toList();
        List<BHotel> bHotels1 = sorted.sorted(bHotelList);
        for (int i = 0;i < bHotelList.size();i++) {
            Assertions.assertEquals(bHotels.get(i).getPrice(),bHotels1.get(i).getPrice());
        }


    }
    @Test
    void test1() {

    }

}

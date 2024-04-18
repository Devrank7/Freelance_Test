package com.example.client_1.service;

import com.example.client_1.model.BHotel;
import com.example.client_1.model.BUser;
import com.example.client_1.model.DTO_Hotel_User;
import com.example.client_1.repository.IHotel;
import com.example.client_1.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class Server {
    @Autowired
    private IHotel bHotelr;
    @Autowired
    public TaskScheduler taskScheduler;

    private Queue<DTO_Hotel_User> queue = new LinkedList<>();


    @Scheduled(fixedDelay = 3000)
    public void time() {
        System.out.println("hello");
    }

    public void toBook(BHotel hotel, BUser user, long time) {
        DTO_Hotel_User dtoHotelUser = new DTO_Hotel_User(hotel,user);
        if (!dtoHotelUser.isValid()) {
            throw new RuntimeException("not valid");
        } else {
            queue.add(dtoHotelUser);
            taskScheduler.schedule(this::someMethode, Instant.now().plusMillis(time));
        }
    }

    public void someMethode() {
        System.out.println("something info");
        DTO_Hotel_User dtoHotelUser = queue.poll();
        BHotel bHotel = bHotelr.findById(dtoHotelUser.getHotel().getId()).orElseThrow();
        System.out.println("isEmpty = " + bHotel.getBookers().isEmpty());
        int i = 0;
        for (BUser bUser : bHotel.getBookers()) {
            System.out.println(bUser.getId());
            if (bHotel.getBookers().get(i).getId() == dtoHotelUser.getUser().getId()) break;
            i++;
        }
        bHotel.getBookers().set(i,null);
        bHotelr.save(bHotel);
    }


}

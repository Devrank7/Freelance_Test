package com.example.client_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class Server {

    public int delay;
    @Autowired
    public TaskScheduler taskScheduler;


    @Scheduled(fixedDelay = 3000)
    public void time() {
        System.out.println("hello");
    }

    public void toBook(long time) {
        taskScheduler.schedule(this::someMethode, Instant.now().plusSeconds(time));

    }
    public void someMethode() {
        System.out.println("something info");
    }


}

package com.example.demo.controller;

import com.example.demo.controller.kafka.Consume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class ACtrl {
    @Autowired
    public Consume consume;

    @GetMapping("/use")
    public String gfgfg() {
        return "hop";
    }

    @GetMapping("/buse")
    public String jgdjgfjg() {
        consume.sendMassage("yuy");
        return "ho";
    }
}

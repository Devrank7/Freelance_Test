package com.example.client_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/test")
    @ResponseBody
    public String getView() {
        return "test";
    }
}

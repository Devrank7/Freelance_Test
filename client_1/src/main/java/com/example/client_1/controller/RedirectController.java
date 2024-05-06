package com.example.client_1.controller;

import io.micrometer.observation.Observation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/re")
@Slf4j
public class RedirectController {
    @Autowired
    private HttpServletResponse response;

    @GetMapping("/direct")
    public ModelAndView httpReq() throws IOException {
        String redirectUrl = "https://example.com";
        log.error("here someone ");
        return new ModelAndView(new RedirectView(redirectUrl));
    }
}

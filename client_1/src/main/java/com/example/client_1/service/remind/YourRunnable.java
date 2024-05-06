package com.example.client_1.service.remind;

import com.example.client_1.controller.RedirectController;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Service
public class YourRunnable  {

    private String desc = "not information";
    @Autowired
    private HttpServletResponse response;
   // @Autowired
   // private RestTemplate restTemplate;
    @Autowired
    private RedirectController controller;
    @Async
    public void callUrlMethod(HttpServletResponse response) throws InterruptedException, IOException {
           Thread.sleep(4000);
        String url = "http://localhost:3030/re/direct"; // URL, который нужно вызвать
        response.sendRedirect(url);
        System.out.println("Перенаправление пользователя на " + url);
    }
}

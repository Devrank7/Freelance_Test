package com.example.client_1.service.remind;

import org.springframework.web.servlet.view.RedirectView;

import java.util.Spliterator;


public interface IRemind {

   default RedirectView foo(String url) {
       return new RedirectView(url);
   }

}

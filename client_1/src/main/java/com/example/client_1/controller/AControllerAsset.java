package com.example.client_1.controller;

import com.example.client_1.repository.IHotel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/asset")
@AllArgsConstructor
public class AControllerAsset {

    public IHotel hotelRepo;

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("hot",hotelRepo.findAll());
        return "hotel";
    }
    @GetMapping("/pro/{id}")
    public String getProo(@PathVariable("id") int id,Model model) {
        model.addAttribute("use",hotelRepo.findById(id).get());
        return "pro";
    }
}

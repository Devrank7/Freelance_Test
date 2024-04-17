package com.example.client_1.controller;

import com.example.client_1.model.BHotel;
import com.example.client_1.model.BUser;
import com.example.client_1.model.role.Roles;
import com.example.client_1.repository.IHotel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/asset")
@Slf4j
public class AControllerAsset {
    @Autowired
    public IHotel hotelRepo;
    @Value("${upload.path}")
    private String img;

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("hot", hotelRepo.findAll());
        return "hotel";
    }

    @GetMapping("/pro/{id}")
    public String getProo(@PathVariable("id") int id, Model model) {
        model.addAttribute("use", hotelRepo.findById(id).get());
        log.warn("str = " + hotelRepo.findById(id).get().getImg());
        return "pro";
    }

    @GetMapping("/create")
    public String createAsset(Model model, @AuthenticationPrincipal BUser bUser) {
        if (bUser.getRoles() == Roles.USER) {
            return "redirect:localhost:8000/sclient1/view/test";
        }

        model.addAttribute("buse", new BHotel());
        return "create";
    }

    @PostMapping("/create")
    public String createLocky(@ModelAttribute("buse") BHotel bHotel, @AuthenticationPrincipal BUser bUser,@RequestParam("imgg")MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            File file1 = new File(img);
            if (!file1.exists()) {
                file1.mkdir();
            }
            String random = UUID.randomUUID().toString();
            String photo = random + "." + file.getOriginalFilename();
            file.transferTo(new File(img + "/" + photo));
            bHotel.setImg(photo);
        }
        bHotel.setOwner(bUser);
        bHotel.setGrate((byte) 100);
        hotelRepo.save(bHotel);
        return "redirect:/asset/all";
    }
}

package com.example.client_1.controller;

import com.example.client_1.model.BHotel;
import com.example.client_1.model.BItem;
import com.example.client_1.model.BUser;
import com.example.client_1.model.role.Roles;
import com.example.client_1.repository.IHotel;
import com.example.client_1.service.IOrderService;
import com.example.client_1.service.ServiceSortedById;
import com.example.client_1.service.ServiceSortedByPrice;
import com.example.client_1.service.StrategySortedBy;
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
    @Autowired
    private StrategySortedBy strategySortedBy;

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("hot", hotelRepo.findAll());
        return "hotel";
    }
    @GetMapping("/all/by/id")
    public String getAllByOrder(Model model) {
       model.addAttribute("hot",strategySortedBy.sorted(new ServiceSortedById(),hotelRepo.findAll()));
       return "hotel";
    }
    @GetMapping("/all/by/price")
    public String getAllByOrderPrice(Model model) {
        model.addAttribute("hot",strategySortedBy.sorted(new ServiceSortedByPrice(),hotelRepo.findAll()));
        return "hotel";
    }

    @GetMapping("/pro/{id}")
    public String getProo(@PathVariable("id") int id, Model model) {
        model.addAttribute("use",  hotelRepo.findById(id).orElseThrow());
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
    @GetMapping("/update/{id}")
    public String updateH(@PathVariable("id") int id,@AuthenticationPrincipal BUser bUser,Model model) {
        if (hotelRepo.findById(id).get().getOwner().getId() == bUser.getId() || bUser.getRoles() == Roles.ADMIN) {
            model.addAttribute("hot",hotelRepo.findById(id).get());
            return "up";
        }
        return "redirect:/asset/all";
    }
    @PostMapping("/update/{id}")
    public String postUpdate(@PathVariable("id")int id,@RequestParam("name")String name,
                             @RequestParam("price")int price,
                             @RequestParam("file")MultipartFile file) throws IOException {
        BHotel bHotel = hotelRepo.findById(id).get();
        bHotel.setName(name);
        bHotel.setPrice(price);
        bHotel.setImg(alongPhoto(file));
        hotelRepo.save(bHotel);
        return "redirect:/asset/all";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id,@AuthenticationPrincipal BUser bUser) {
        if (hotelRepo.findById(id).get().getOwner().getId() == bUser.getId() || bUser.getRoles() == Roles.ADMIN) {
            hotelRepo.findById(id);

        }
        return "redirect:/asset/all";
    }

    public String alongPhoto(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            File file1 = new File(img);
            if (!file1.exists()) {
                file1.mkdir();
            }
            String random = UUID.randomUUID().toString();
            String photo = random + "." + file.getOriginalFilename();
            file.transferTo(new File(img + "/" + photo));
            return photo;
        }
        return "";
    }
    @GetMapping("/book/{id}")
    public String getBookAssetByTime(@PathVariable("id") int id,@AuthenticationPrincipal BUser bUser) {
        if (hotelRepo.findById(id).orElseThrow().getOwner().getId() == bUser.getId()) {
            return "redirect:/asset/all";
        }
        return "book";
    }
}

package com.example.client_1.controller;

import com.example.client_1.jwt.CookieUtils;
import com.example.client_1.jwt.JwtUtils;
import com.example.client_1.model.*;
import com.example.client_1.model.role.Direction;
import com.example.client_1.model.role.Roles;
import com.example.client_1.repository.IHotel;
import com.example.client_1.repository.IUser;
import com.example.client_1.service.*;
import com.example.client_1.service.cache.CacheService;
import jakarta.servlet.http.HttpServletRequest;
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
import java.util.Comparator;
import java.util.UUID;

@Controller
@RequestMapping("/asset")
@Slf4j
public class AControllerAsset {
    @Autowired
    public IHotel hotelRepo;
    @Autowired
    private IUser repoUser;
    @Value("${upload.path}")
    private String img;
    @Autowired
    private StrategySortedBy strategySortedBy;
    @Autowired
    private Server server;
    @Autowired
    public JwtUtils jwt;
    @Autowired
    private CacheService cacheService;

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("hot", hotelRepo.findAll());
        return "hotel";
    }
    @GetMapping("/all/for")
    public String forAll(Model model) {
        model.addAttribute("all",hotelRepo.findAll());
        return "all";
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
        BHotel bHotel = null;
        if (cacheService.isObjectInCache("hotel",id)) {
            log.warn("l1");
            bHotel = cacheService.getter(id);
        } else {
            log.warn("l2");
            bHotel = hotelRepo.findById(id).orElseThrow();
            if (cacheService.needToAddToCache(bHotel)) {
                log.warn("l3");
                cacheService.getter(id);
            }
        }
        int gradesSum = 0;//bHotel.getGrades().stream().mapToInt(sum -> { return sum.getGrade();}).sum();
        for (BGrade gg : bHotel.getGrades()) {
            gradesSum+=gg.getGrade();
        }
        int grades = 0;
        if (!bHotel.getGrades().isEmpty()) {
            grades = gradesSum / bHotel.getGrades().size();
        }
        model.addAttribute("use",  bHotel);
        model.addAttribute("grade",grades);
        log.warn("str = " + bHotel.getImg());
        return "pro";
    }

    @GetMapping("/create")
    public String createAsset(Model model, HttpServletRequest response) {
        if (repoUser.findBUserByName(jwt.getUsername(CookieUtils.getCookie(response))).getRoles() == Roles.USER) {
            return "redirect:localhost:8000/sclient1/view/test";
        }

        model.addAttribute("buse", new BHotel());
        return "create";
    }
    @GetMapping("/create/adv")
    public String createAssetAdv(Model model, HttpServletRequest response) {
        if (repoUser.findBUserByName(jwt.getUsername(CookieUtils.getCookie(response))).getRoles() == Roles.USER) {
            return "redirect:localhost:8000/sclient1/view/test";
        }

        model.addAttribute("buse", new BItem());
        return "createAdv";
    }
    @PostMapping("/create")
    public String createLocky(@ModelAttribute("buse") BHotel bHotel, HttpServletRequest response,@RequestParam("imgg")MultipartFile file) throws IOException {
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
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = repoUser.findBUserByName(username);
        bHotel.setOwner(bUser);
        bHotel.setGrate((byte) 100);
        hotelRepo.save(bHotel);
        return "redirect:/asset/all";
    }
    @PostMapping("/create/adv")
    public String createlLocky(@ModelAttribute("buse") BItem bHotel, HttpServletRequest response,@RequestParam("imgg")MultipartFile file) throws IOException {
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
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = repoUser.findBUserByName(username);
        bHotel.setOwner(bUser);
        bHotel.setGrate((byte) 100);
        bHotel.setDirection(Direction.HOUSEHOLD);

        hotelRepo.save(bHotel);
        return "redirect:/asset/all";
    }

    @GetMapping("/update/{id}")
    public String updateH(@PathVariable("id") int id,HttpServletRequest response,Model model) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = repoUser.findBUserByName(username);
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
        BHotel bHotel;
        boolean isCache = false;
        if (cacheService.isObjectInCache("hotel",id)) {
            bHotel = cacheService.getter(id);
            isCache = true;
        } else {
            bHotel = hotelRepo.findById(id).orElseThrow();
        }
        bHotel.setName(name);
        bHotel.setPrice(price);
        bHotel.setImg(alongPhoto(file));
        if (isCache) {
            cacheService.setter(bHotel,id);
        }
        hotelRepo.save(bHotel);
        return "redirect:/asset/all";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id,HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = repoUser.findBUserByName(username);
        if (hotelRepo.findById(id).get().getOwner().getId() == bUser.getId() || bUser.getRoles() == Roles.ADMIN) {
            if(cacheService.isObjectInCache("hotel",id)) {
                cacheService.deleter(id);
            }
            hotelRepo.deleteById(id);

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
    public String getBookAssetByTime(@PathVariable("id") int id,HttpServletRequest response,Model model) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = repoUser.findBUserByName(username);
        if (hotelRepo.findById(id).orElseThrow().getOwner().getId() == bUser.getId()) {
            return "redirect:/asset/all";
        }
        model.addAttribute("tie",new DTO_Time());
        model.addAttribute("boo",hotelRepo.findById(id).orElseThrow());
        return "book";
    }
    @PostMapping("/book/{id}")
    public String getBoBok(@PathVariable("id")int id,HttpServletRequest response,
                           @ModelAttribute("tie")DTO_Time dtoTime) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = repoUser.findBUserByName(username);
        BHotel hotel = hotelRepo.findById(id).orElseThrow(() -> new RuntimeException("not found ex"));
        int withdraw = 3000;
        log.warn("price = " + hotel.getPrice());
        log.warn("day = " + dtoTime.getDay());
        log.warn("hour = " + dtoTime.getHour());


        float day_plus = ((float) dtoTime.getDay() / 10) * hotel.getPrice();
        float hour_plus = (float) ((float) ((float)dtoTime.getHour() / 24) / 10) * hotel.getPrice();
        withdraw = (int) ((int) day_plus + hour_plus);
        log.warn("day sum = " + day_plus);
        log.warn("hour sum= " + hour_plus);


        log.warn("sub = " + withdraw);
        BUser bUser1 = repoUser.findById(bUser.getId()).orElseThrow();
        int currentCurrency = bUser1.getCurrency() - withdraw;
        if (currentCurrency < 0) {
            throw new RuntimeException("not enough money exception");
        }
        hotel.getBookers().add(bUser1);
        hotelRepo.save(hotel);
        int atSeconds = dtoTime.getDay() * 1000;
        int atMillis = dtoTime.getHour() * 100;
        server.toBook(hotel,bUser1, atSeconds + atMillis);
        return "redirect:/asset/all";
    }
    @GetMapping("/pro/grade/{id}")
    public String getUss(@PathVariable("id")int id,HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = repoUser.findBUserByName(username);
        BHotel bHotel = hotelRepo.findById(id).orElseThrow();
        for (BGrade grade : bHotel.getGrades()) {
            if (grade.getUser_id() == bUser.getId()) {
                return "redirect:/asset/all";
            }
        }
        return "grade";
    }
    @PostMapping("/pro/grade/{id}")
    public String getUs(@PathVariable("id")int id,@RequestParam("grade")int grade,HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        grade = Math.clamp(grade,0,100);
        BUser bUser = repoUser.findBUserByName(username);
        BHotel bHotel = hotelRepo.findById(id).orElseThrow();
        bHotel.getGrades().add(new BGrade(grade, bUser.getId()));
        hotelRepo.save(bHotel);
        return "redirect:/asset/all";
    }
    public void aVoid(BItem item) {}
}

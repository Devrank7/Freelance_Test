package com.example.client_1.controller;

import com.example.client_1.model.BUser;
import com.example.client_1.model.role.Roles;
import com.example.client_1.repository.ITask;
import com.example.client_1.repository.IUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/data")
@AllArgsConstructor
@Slf4j
public class AController {

    public ITask repoTask;
    
    public IUser repoUser;

    public PasswordEncoder passwordEncoder;

    @GetMapping("/da")
    public String getdjf(Model model) {
        model.addAttribute("datas",repoTask.findAll());
        return "users";
    }
    @GetMapping("/auth")
    public String getAuth(Model model) {
        model.addAttribute("uses",new BUser());
        return "auth";
    }
    @PostMapping("/auth")
    public String getAutgh(@ModelAttribute("uses") BUser bUser) {
        bUser.setPassword(passwordEncoder.encode(bUser.getPassword()));
        bUser.setRoles(Roles.USER);
        repoUser.save(bUser);
        return "redirect:/data/test";
    }
    @GetMapping("/test")
    public String test() {
        return "test";
    }
    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "Hello, Admin!";
    }
    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal BUser bUser,Model model) {
        model.addAttribute("userd",bUser);
        return "profile";
    }
    @GetMapping("/update")
    public String getUpdate(@AuthenticationPrincipal BUser bUser,Model model) {
        model.addAttribute("buse",repoUser.findById(bUser.getId()).get());
        return "update";
    }
    @PostMapping("/update")
    public String getUpdating(@AuthenticationPrincipal BUser bUserd,@ModelAttribute("buse")BUser bUser) {
        log.warn("id = " + bUser.getId());
        bUser.setId(bUserd.getId());
        bUser.setRoles(Roles.USER);
        bUser.setDate(bUser.getDate());
        bUser.setPassword(passwordEncoder.encode(bUser.getPassword()));
        repoUser.save(bUser);
        return "redirect:/data/profile";
    }
    @GetMapping("/delete")
    public String getDelete(@AuthenticationPrincipal BUser bUser) {
        repoUser.deleteById(bUser.getId());
        return "redirect:/logout";
    }
    @GetMapping("/sander")
    public String getSander(@AuthenticationPrincipal BUser bUser) {
        if (bUser.getRoles() == Roles.SENDER || bUser.getRoles() == Roles.ADMIN) {
            return "redirect:/data/profile";
        }
        return "sender";
    }
    @PostMapping("/sander")
    public String getSender(@AuthenticationPrincipal BUser bUser,@RequestParam(value = "check",defaultValue = "false") boolean cheak) {
        log.warn("check = " + cheak);

        if (cheak) {
            bUser.setRoles(Roles.SENDER);
            repoUser.save(bUser);
        }
        return "redirect:/data/profile";
    }


}

package com.example.client_1.controller;

import com.example.client_1.jwt.CookieUtils;
import com.example.client_1.jwt.JwtUtils;
import com.example.client_1.model.BUser;
import com.example.client_1.model.role.Roles;
import com.example.client_1.repository.ITask;
import com.example.client_1.repository.IUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    public AuthenticationProvider provider;
    public JwtUtils jwt;

    @GetMapping("/da")
    public String getdjf(Model model) {
        model.addAttribute("datas", repoTask.findAll());
        return "users";
    }

    @GetMapping("/auth")
    public String getAuth(Model model) {
        model.addAttribute("uses", new BUser());
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
    public String profile(Model model, HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        model.addAttribute("userd", repoUser.findBUserByName(username));
        return "profile";
    }

    @GetMapping("/update")
    public String getUpdate(Model model,HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        model.addAttribute("buse", repoUser.findBUserByName(username));
        return "update";
    }

    @PostMapping("/update")
    public String getUpdating( @ModelAttribute("buse") BUser bUser,HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUserd = repoUser.findBUserByName(username);
        log.warn("id = " + bUser.getId());
        bUser.setId(bUserd.getId());
        bUser.setRoles(Roles.USER);
        bUser.setDate(bUser.getDate());
        bUser.setPassword(passwordEncoder.encode(bUser.getPassword()));
        repoUser.save(bUser);
        return "redirect:/data/profile";
    }

    @GetMapping("/delete")
    public String getDelete(HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        repoUser.deleteById(repoUser.findBUserByName(username).getId());
        return "redirect:/logout";
    }

    @GetMapping("/sander")
    public String getSander(HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = repoUser.findBUserByName(username);
        if (bUser.getRoles() == Roles.SENDER || bUser.getRoles() == Roles.ADMIN) {
            return "redirect:/data/profile";
        }
        return "sender";
    }

    @PostMapping("/sander")
    public String getSender(HttpServletRequest response, @RequestParam(value = "check", defaultValue = "false") boolean cheak) {
        log.warn("check = " + cheak);
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = repoUser.findBUserByName(username);
        if (cheak) {
            bUser.setRoles(Roles.SENDER);
            repoUser.save(bUser);
        }
        return "redirect:/data/profile";
    }

    @GetMapping("/balance")
    public String sendBalance(HttpServletRequest response) {
        return "send";
    }

    @PostMapping("/balance")
    public String sendBall(HttpServletRequest response, @RequestParam("addd") int add) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = repoUser.findBUserByName(username);
        BUser bUser1 = repoUser.findById(bUser.getId()).orElseThrow();
        bUser1.setCurrency(bUser.getCurrency() + add);
        repoUser.save(bUser1);
        return "redirect:/data/profile";
    }

    @GetMapping("/log")
    public String loging() {
        return "log";

    }

    @PostMapping("/log")
    public String logging(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse httpServletResponse) {
        provider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        log.warn("regis");
        UserDetails userDetails = repoUser.findBUserByName(username);
        CookieUtils.setCookie(httpServletResponse,jwt.generateToken(userDetails));
        return "redirect:/data/profile";

    }


}

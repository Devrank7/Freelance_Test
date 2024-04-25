package com.example.client_1.controller;

import com.example.client_1.jwt.CookieUtils;
import com.example.client_1.jwt.JwtUtils;
import com.example.client_1.model.BUser;
import com.example.client_1.model.role.Roles;
import com.example.client_1.repository.ITask;
import com.example.client_1.repository.IUser;
import com.example.client_1.service.OidcServer;
import com.example.client_1.service.Server;
import com.example.client_1.service.cache.CacheService;
import com.netflix.discovery.converters.Auto;
import com.nimbusds.jose.proc.SecurityContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.*;
import java.io.File;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/data")
@Slf4j
public class AController {

    public ITask repoTask;

    public IUser repoUser;

    public PasswordEncoder passwordEncoder;

    public AuthenticationProvider provider;
    public JwtUtils jwt;
    @Autowired
    private OidcServer server;
    @Autowired
    private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserRequestOidcUserOAuth2UserService;

    private CacheService cacheService;

    @Autowired
    public AController(ITask repoTask, IUser repoUser, PasswordEncoder passwordEncoder, AuthenticationProvider provider, JwtUtils jwt, CacheService cacheService) {
        this.repoTask = repoTask;
        this.repoUser = repoUser;
        this.passwordEncoder = passwordEncoder;
        this.provider = provider;
        this.jwt = jwt;
        this.cacheService = cacheService;
    }


    //@Value("upload.song")
    // private String songs;

    @GetMapping("/da")
    public String getdjf(Model model) {
        model.addAttribute("datas", repoTask.findAll());
        return "users";
    }

    @GetMapping("/auth")
    public String getAuth(Model model) {
        playSound("xv.wav");
        model.addAttribute("uses", new BUser());
        return "auth";
    }

    @PostMapping("/auth")
    public String getAutgh(@Valid @ModelAttribute("uses") BUser bUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth";
        }
        bUser.setPassword(passwordEncoder.encode(bUser.getPassword()));
        bUser.setRoles(Roles.USER);
        repoUser.save(bUser);
        return "redirect:/data/test";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/admin/rest")
    @ResponseBody
    public String admin() {
        return "Hello, Admin!";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        model.addAttribute("userd", ontoCache(username));
        return "profile";
    }

    @GetMapping("/update")
    public String getUpdate(Model model, HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        model.addAttribute("buse", ontoCache(username));
        return "update";
    }

    @PostMapping("/update")
    public String getUpdating(@Valid @ModelAttribute("buse") BUser bUser, BindingResult bindingResult, HttpServletRequest response) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUserd = ontoCache(username);
        log.warn("id = " + bUser.getId());
        bUser.setId(bUserd.getId());
        bUser.setName(bUserd.getName());
        bUser.setRoles(Roles.USER);
        bUser.setDate(new Date());
        bUser.setPassword(passwordEncoder.encode(bUserd.getPassword()));
        if (cacheService.isObjectInCache("users", username)) {
            cacheService.setterUsr(bUser, username);
        }
        repoUser.save(bUserd);
        return "redirect:/data/profile";
    }

    @GetMapping("/delete")
    public String getDelete(HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = ontoCache(username);
        if (cacheService.isObjectInCache("users", username)) {
            cacheService.deleterUsr(bUser.getName());
        }
        repoUser.deleteById(bUser.getId());
        return "redirect:/logout";
    }

    @GetMapping("/sander")
    public String getSander(HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = ontoCache(username);
        if (bUser.getRoles() == Roles.SENDER || bUser.getRoles() == Roles.ADMIN) {
            return "redirect:/data/profile";
        }
        return "sender";
    }

    @PostMapping("/sander")
    public String getSender(HttpServletRequest response, @RequestParam(value = "check", defaultValue = "false") boolean cheak) {
        log.warn("check = " + cheak);
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = ontoCache(username);
        if (cheak) {
            bUser.setRoles(Roles.SENDER);
            if (cacheService.isObjectInCache("users", bUser.getName())) {
                cacheService.setterUsr(bUser, bUser.getName());
            }
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
        BUser bUser = ontoCache(username);
        bUser.setCurrency(bUser.getCurrency() + add);
        if (cacheService.isObjectInCache("users", bUser.getName())) {
            cacheService.setterUsr(bUser, bUser.getName());
        }
        repoUser.save(bUser);
        return "redirect:/data/profile";
    }

    @GetMapping("/log")
    public String loging() {
        return "log";

    }

    @GetMapping("/log/rest")
    @ResponseBody
    public Map<String,Object> restLog() {
        if (server.getOidcUser() != null) {
            return server.getOidcUser().getAttributes();
        }


       return null;
    }
    @GetMapping("/log/rest1")
    @ResponseBody
    public Map<String,Object> restLog1() {

        return null;
    }

    @PostMapping("/log")
    public String logging(@RequestParam("username") String username, @RequestParam("password") String password,  HttpServletResponse httpServletResponse) {
        provider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        log.warn("regis");
        UserDetails userDetails = repoUser.findBUserByName(username);
        CookieUtils.setCookie(httpServletResponse, jwt.generateToken(userDetails));
        return "redirect:/data/profile";

    }

    @GetMapping("/become/admin")
    public String become(HttpServletRequest response) {
        return "admin";
    }

    @PostMapping("/become/admin")
    public String postBecome(@RequestParam(value = "che", defaultValue = "false") boolean check, HttpServletRequest response) {
        if (!check) return "redirect:/data/profile";
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = ontoCache(username);
        int balance = bUser.getCurrency() - 10000;
        if (balance < 0) {
            log.warn("not enough balance");
            return "redirect:/data/profile";
        }
        bUser.setCurrency(balance);
        bUser.setRoles(Roles.ADMIN);
        if (cacheService.isObjectInCache("users", bUser.getName())) {
            log.warn("bb2");
            cacheService.setterUsr(bUser, bUser.getName());
        }
        repoUser.save(bUser);
        log.warn("The user was successful updated");
        return "redirect:/data/profile";

    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String panelAdmin(Model model, HttpServletRequest response) {
        String username = jwt.getUsername(CookieUtils.getCookie(response));
        BUser bUser = ontoCache(username);
        List<BUser> list = repoUser.findAll();
        list.remove(bUser);
        list.removeIf(BUser::isAdmin);
        model.addAttribute("list", list);
        model.addAttribute("your", bUser);
        return "admin_pan";
    }

    @PostMapping("/ban/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String ban(@PathVariable("id") int id) {
        BUser bUser = repoUser.findById(id).orElseThrow();
        bUser.setIsActive(!bUser.getIsActive());
        if (cacheService.isObjectInCache("users", bUser.getName())) {
            log.warn("bb1");
            cacheService.setterUsr(bUser, bUser.getName());
        }
        repoUser.save(bUser);
        return "redirect:/data/admin";
    }

    //GPT Thanks
    public static void playSound(String soundFilePath) {
        try {
            // Получаем аудиофайл из ресурсов
            ClassPathResource resource = new ClassPathResource(soundFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(resource.getInputStream());

            // Создаем Clip и воспроизводим аудио
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            // Ждем, пока аудиофайл не воспроизведется полностью
            Thread.sleep(clip.getMicrosecondLength() / 1000);

            // Закрываем поток и освобождаем ресурсы
            clip.stop();
            clip.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BUser ontoCache(String username) {
        if (cacheService.isObjectInCache("users", username)) {
            log.warn("t23");
            return cacheService.getterUsr(username);
        } else {
            log.warn("t89");
            BUser bUser = repoUser.findBUserByName(username);
            if (cacheService.needToAddToCacheUsr(bUser)) {
                cacheService.getterUsr(username);
            }
            return bUser;
        }
    }


}

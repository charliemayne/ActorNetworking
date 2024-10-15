package com.actornetwork.controllers;

import com.actornetwork.domain.User;
import com.actornetwork.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("pageTitle", "Register");
        model.addAttribute("page", "register");
        return "registration";
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestParam Map<String, String> params) {
        System.out.println(params.toString());
        if(userRepository.findByEmail(params.get("email")) == null) {
            User newUser = new User(params.get("firstName"), params.get("lastName"), params.get("email"), passwordEncoder.encode(params.get("password")));
            userRepository.save(newUser);
        }
        else {
            return "registration";
        }
        return "home";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("pageTitle", "Login");
        model.addAttribute("page", "login");
        return "login";
    }
}

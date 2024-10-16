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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
public class PageController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = {"/", "/home"})
    public String getHome(Model model, Principal principal) {
        if(principal != null) {
            User user = userRepository.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }

        model.addAttribute("pageTitle", "Home");
        model.addAttribute("page", "home");
        return "home";
    }

    @GetMapping("/portfolio")
    public String getPortfolio(Model model, Principal principal) {
        // todo: use principal to get the user and add user-specific info to the model
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "portfolio";
    }

    @PostMapping("/portfolio")
    public String updatePortfolio(@RequestParam Map<String, String> params, Model model, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        user.setSetUpComplete(true);
        user.setAbout(params.get("about"));
        userRepository.save(user);
        //TODO add more setters for other information like headshots and works
        return "redirect:/portfolio";
    }
}

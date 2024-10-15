package com.actornetwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("pageTitle", "Home");
        model.addAttribute("page", "home");
        return "home";
    }

}

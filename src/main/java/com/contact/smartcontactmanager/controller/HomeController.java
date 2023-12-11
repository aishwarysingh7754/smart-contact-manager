package com.contact.smartcontactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model) {

        model.addAttribute("title", "Home-Smart contact manager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {

        model.addAttribute("title", "About-Smart contact manager");
        return "about";
    }

    @RequestMapping("/signup")
    public String signup(Model model) {

        model.addAttribute("title", "Signup-Smart contact manager");
        return "signup";
    }

}

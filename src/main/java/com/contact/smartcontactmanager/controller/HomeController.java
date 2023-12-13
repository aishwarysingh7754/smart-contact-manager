package com.contact.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.contact.smartcontactmanager.dao.UserRepository;
import com.contact.smartcontactmanager.entities.User;
import com.contact.smartcontactmanager.helper.Message;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

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
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user,
            @RequestParam(value = "checkbox", defaultValue = "false") boolean checkbox, Model model,
            HttpSession session) {

        try {
            user.setEnabled(true);
            user.setRole("ROLE_USER");
            model.addAttribute("user", new User());
            this.userRepository.save(user);
            session.setAttribute("message", new Message("Everything Gucci", "Success"));
            return "signup";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message", new Message("Something went wrong" + e.getMessage(), "alert"));
            return "signup";
        }

    }

}

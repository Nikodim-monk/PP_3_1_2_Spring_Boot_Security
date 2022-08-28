package ru.kata.spring_boot_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring_boot_security.model.User;
import ru.kata.spring_boot_security.service.UserService;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/user")
    public String printAllUsers(Principal principal, ModelMap model) {
        User user=service.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user_view";
    }
}

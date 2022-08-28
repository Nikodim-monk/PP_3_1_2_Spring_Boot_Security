package ru.kata.spring_boot_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring_boot_security.model.User;
import ru.kata.spring_boot_security.service.UserService;

@Controller
public class AdminController {

    @Autowired
    private UserService service;

    @GetMapping("/admin")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", service.getAllUsers());
        return "usersAll";
    }

    @GetMapping("/{id}")
    public String printUser(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", service.getUser(id));
        return "user";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute("user") User user) {
        service.addNewUser(user);
        return "redirect:/admin";
    }

    @PutMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        User userNotUpdate=service.getUser(id);
        userNotUpdate.setName(user.getName());
        userNotUpdate.setAge(user.getAge());
        service.updateUser(userNotUpdate);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        service.UserDelete(id);
        return "redirect:/admin";
    }
}

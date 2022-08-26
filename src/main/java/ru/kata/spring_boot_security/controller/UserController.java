package ru.kata.spring_boot_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring_boot_security.model.User;
import ru.kata.spring_boot_security.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/admin")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", service.getAllUsers());
        return "usersAll";
    }

    @GetMapping("/{id}")
    public String printUserById(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", service.getUserById(id));
        return "user";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute("user") User user) {
        service.addNewUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        service.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        service.UserDelete(id);
        return "redirect:/admin";
    }
    @GetMapping("/user")
    public String printAllUsers() {
//        model.addAttribute("users", service.getAllUsers());
        return "user_view";
    }

}

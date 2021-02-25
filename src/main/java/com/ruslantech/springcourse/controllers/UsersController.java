package com.ruslantech.springcourse.controllers;

import com.ruslantech.springcourse.dao.UserDaoImp;
import com.ruslantech.springcourse.models.User;
import com.ruslantech.springcourse.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user_page";
    }

    @PostMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "user_page";
    }

    @GetMapping("/new_user")
    public String newUser(@ModelAttribute("user") User user) {
        return "new_user";
    }

    @PostMapping()
    public String createUser(@RequestParam("name") String name,
                             @RequestParam("age") int age,
                             @RequestParam("email") String email) {
        userService.createUser(name, age, email);
        return "redirect:/users";
    }

    @GetMapping("/remove_user/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}

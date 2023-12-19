package com.expenseOrg.controller;

import com.expenseOrg.entity.User;
import com.expenseOrg.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userRepo.save(user);
    }

    @PostMapping("/login")
    public boolean loginUser(@RequestBody User user) {
        User storedUser = userRepo.findByUsername(user.getUsername());
        return storedUser != null && storedUser.getPassword().equals(user.getPassword());
    }
}


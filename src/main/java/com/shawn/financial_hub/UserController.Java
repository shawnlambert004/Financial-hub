package com.shawn.financial_hub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.shawn.financial_hub.User;
import com.shawn.financial_hub.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/beta/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/regUser")
    public User regUser(@RequestBody User newUser) {
        return userService.registerUser(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User exUser) {
        try {
            User user = userService.login(exUser.getUsername(), exUser.getPassword());
            return ResponseEntity.ok(user);
        } catch (RuntimeException error) {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }

} // UserControllere

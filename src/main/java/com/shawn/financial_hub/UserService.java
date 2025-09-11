package com.shawn.financial_hub;

import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import com.shawn.financial_hub.UserRepo;
import com.shawn.financial_hub.User;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void saveUser(User newUser) {
        userRepo.save(newUser);
    }

    public User registerUser(User newUser) {
        if (userRepo.findByUsername(newUser.getUsername()) != null) {
            throw new RuntimeException("Username" + newUser.getUsername() + " is taken.");
        } else {
            saveUser(newUser);
            return newUser;
        }
    }

    public User login(String username, String password) {
        User existingUser = userRepo.findByUsername(username);
        if (existingUser != null) {
            if (password.equals(existingUser.getPassword())) {
                return existingUser;
            } else {
                throw new RuntimeException("Incorrect Password");
            }
        } else {
            throw new RuntimeException("User does not Exist");
        }
    }

    public Long getUserId(String username) {
        User userboy = userRepo.findByUsername(username);
        return userboy.getId();
    }
}
// UserService
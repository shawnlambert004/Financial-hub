package com.shawn.financial_hub;

import com.shawn.financial_hub.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/beta/feed")
@CrossOrigin
public class FeedController {
    @Autowired
    FeedRepo feedRepo;

    @Autowired
    FeedService feedService;
    @Autowired
    UserRepo userRepo;

    @PostMapping("/addUrl")
    public ResponseEntity<?> addUrl(@RequestParam String url, @RequestParam String username) {
        User userPossible = userRepo.findByUsername(username);
        if (userPossible == null) {
            return ResponseEntity.status(401).body("No User associated with URL");
        }
        feedService.addUrl(url, userPossible);
        return ResponseEntity.ok(userPossible);
    }

    @PostMapping("/delUrl")
    public void delUrl(@RequestParam String url) {
        feedService.deleteUrl(url);
    }
}
// EverySingle one
package com.shawn.financial_hub;

import com.shawn.financial_hub.*;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void addUrl(@RequestBody String url, @RequestBody String userId) {
        User userPossible = userRepo.findByUsername(userId);
        if (userPossible == null) {
            throw new RuntimeException("No User associated with URL");
        }
        feedService.addUrl(url, userPossible);
    }

    @PostMapping("/delUrl")
    public void delUrl(@RequestBody String url) {
        feedService.deleteUrl(url);
    }
}
// EverySingle one
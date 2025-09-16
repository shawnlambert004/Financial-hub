package com.shawn.financial_hub;

import com.shawn.financial_hub.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<?> addUrl(@RequestBody feedDTO feed) {
        User userPossible = userRepo.findByUsername(feed.username);
        if (userPossible == null) {
            return ResponseEntity.status(401).body("No User associated with URL");
        }
        feedService.addUrl(feed.url, userPossible);
        return ResponseEntity.ok(userPossible);
    }

    @DeleteMapping("/delUrl")
    public ResponseEntity<?> delUrl(@RequestBody feedDTO feed) {
        feedService.deleteUrl(feed.url);
        return ResponseEntity.ok(feed.url);
    }

    @PostMapping("/getUrl")
    public List<String> getUrls(@RequestBody feedDTO feed) {
        return feedService.getUrls(feed.user_id);
    }
}
// EverySingle
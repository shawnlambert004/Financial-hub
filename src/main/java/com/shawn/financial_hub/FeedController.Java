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

    @PostMapping("/delUrl")
    public void delUrl(@RequestParam String url) {
        feedService.deleteUrl(url);
    }

    @GetMapping("/getUrl")
    public List<String> getUrls(@RequestParam Long user_id) {
        return feedService.getUrls(user_id);
    }
}
// EverySingle one
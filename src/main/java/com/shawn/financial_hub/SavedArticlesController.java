package com.shawn.financial_hub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/beta/Savearticles")
@CrossOrigin
public class SavedArticlesController {
    @Autowired
    SavedArticlesService SA;

    @PostMapping("/saveArticle")
    public ResponseEntity<?> saveArticle(@RequestBody ArticleDTO article) {
        SA.saveArticle(article);
        return ResponseEntity.ok(article);
    }

    @PostMapping("/getArty")
    public List<SavedArticles> getArticles(@RequestParam String username) {
        return SA.getArticles(username);
    }

    @DeleteMapping("/deleteArty")
    public ResponseEntity<?> deleteArticle(@RequestBody ArticleDTO article) {
        SA.deleteArticle(article);
        return ResponseEntity.ok(article);
    }
}

package com.shawn.financial_hub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/beta/articles")
@CrossOrigin
public class RetrieveArticlesController {

    @PostMapping("/getArticles")
    public Article getarticle() {
        return RetrieveArticlesService.getArticle();
    }
}

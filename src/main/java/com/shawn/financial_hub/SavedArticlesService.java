package com.shawn.financial_hub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavedArticlesService {
    @Autowired
    articleRepo articleRepo;
    @Autowired
    UserRepo userRepo;

    public void saveArticle(ArticleDTO article) {
        SavedArticles savedArticle = new SavedArticles();
        savedArticle.setTitle(article.title);
        savedArticle.setImageURL(article.imageURL);
        savedArticle.setByLine(article.byLine);
        savedArticle.setContents(article.content);
        savedArticle.setSources(article.sources);
        User user = userRepo.findByUsername(article.username);
        savedArticle.setUser(user);
        articleRepo.save(savedArticle);
    }

    public List<SavedArticles> getArticles(String username) {
        User userpos = userRepo.findByUsername(username);
        Long id = userpos.getId();
        return articleRepo.getArticles(id);
    }

    public void deleteArticle(ArticleDTO article) {
        SavedArticles target = articleRepo.findByTitle(article.title);
        articleRepo.delete(target);
    }
}

package com.shawn.financial_hub;

import java.util.ArrayList;
import java.util.List;

public class Article {
    ArrayList<String> titles;
    ArrayList<String> imageUrls;
    ArrayList<String> ArticleContent;
    ArrayList<String> BigImUrls;
    ArrayList<String> Sources;
    ArrayList<String> ByLine = new ArrayList<>();

    public void buildArticle(ArrayList<String> title, ArrayList<String> imageUrl, ArrayList<String> ArticleContent,
            ArrayList<String> Sources, ArrayList<String> ByLine) {
        this.titles = title;
        this.imageUrls = imageUrl;
        this.ArticleContent = ArticleContent;
        this.Sources = Sources;
        this.ByLine = ByLine;
    };

    public Article() {
        titles = new ArrayList<>();
        imageUrls = new ArrayList<>();
    }

    public ArrayList<String> getTitle() {
        return titles;
    };

    public void setTitle(ArrayList<String> title) {
        this.titles = title;
    };

    public ArrayList<String> getImageUrl() {
        return imageUrls;
    };

    public void setImageUrl(ArrayList<String> imageUrl) {
        this.imageUrls = imageUrl;
    };

    public ArrayList<String> getSources() {
        return Sources;
    };

    public void setByLine(ArrayList<String> ByLine) {
        this.ByLine = ByLine;
    };

    public ArrayList<String> getByLine() {
        return ByLine;
    };

    public void setSources(ArrayList<String> Sources) {
        this.Sources = Sources;
    };

    public ArrayList<String> getContents() {
        return ArticleContent;
    };

    public void setContents(ArrayList<String> ArticleContent) {
        this.ArticleContent = ArticleContent;
    };

}

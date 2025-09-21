package com.shawn.financial_hub;

import java.util.ArrayList;
import java.util.List;

public class Article {
    ArrayList<String> titles;
    ArrayList<String> Descriptions;
    ArrayList<String> imageUrls;
    ArrayList<String> content;

    public void buildArticle(ArrayList<String> title, ArrayList<String> Description, ArrayList<String> imageUrl,
            ArrayList<String> content) {
        this.titles = title;
        this.Descriptions = Description;
        this.imageUrls = imageUrl;
        this.content = content;
    };

    public Article() {
        titles = new ArrayList<>();
        Descriptions = new ArrayList<>();
        imageUrls = new ArrayList<>();
        content = new ArrayList<>();

    }

    public ArrayList<String> getTitle() {
        return titles;
    };

    public void setTitle(ArrayList<String> title) {
        this.titles = title;
    };

    public ArrayList<String> getDescription() {
        return Descriptions;
    };

    public void setDescription(ArrayList<String> Description) {
        this.Descriptions = Description;
    };

    public ArrayList<String> getImageUrl() {
        return imageUrls;
    };

    public void setImageUrl(ArrayList<String> imageUrl) {
        this.imageUrls = imageUrl;
    };

    public ArrayList<String> getContents() {
        return content;
    };

    public void setContents(ArrayList<String> content) {
        this.content = content;
    };

}

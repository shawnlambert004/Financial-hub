package com.shawn.financial_hub;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class RetrieveArticlesService {

    public static Article getArticle() {
        String url = "https://www.ft.com/world-uk?_gl=1*10sfbfj*_ga*MjAwMDM5OTM0NS4xNzUzNTI3Njky*_ga_2DSMN2JH8F*czE3NTgxMzcxOTQkbzI5JGcwJHQxNzU4MTM3MTk0JGo2MCRsMCRoMA..";
        Article arty = new Article();
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> Descriptions = new ArrayList<>();
        ArrayList<String> imageUrls = new ArrayList<>();
        ArrayList<String> contents = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Elements articles = document
                    .select(".o-teaser.o-teaser--article.o-teaser--small.o-teaser--has-image.js-teaser");

            for (Element article : articles) {
                String title = article.select("a.js-teaser-heading-link").text();
                String Description = article.select("a.js-teaser-standfirst-link").text();
                String imageUrl = article.select("img.o-teaser__image.o-lazy-load").attr("data-src");
                String content = article.select("a.js-teaser-heading-link").attr("href");
                String fullContent = "https://www.ft.com" + content;

                if (title == "" || imageUrl == "" || Description == "" || content == "") {
                    ;
                } else {
                    titles.add(title);
                    Descriptions.add(Description);
                    imageUrls.add(imageUrl);
                    contents.add(fullContent);
                }

            }

            arty.buildArticle(titles, Descriptions, imageUrls, contents);
            return arty;
        } catch (IOException e) {
            e.printStackTrace();
            return arty;
        }
    }
}

package com.shawn.financial_hub;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrapper {
    public static void main(String[] args) {
        String url = "https://www.ft.com/world-uk?_gl=1*10sfbfj*_ga*MjAwMDM5OTM0NS4xNzUzNTI3Njky*_ga_2DSMN2JH8F*czE3NTgxMzcxOTQkbzI5JGcwJHQxNzU4MTM3MTk0JGo2MCRsMCRoMA..";
        try {
            Document document = Jsoup.connect(url).get();
            Elements articles = document
                    .select(".o-teaser.o-teaser--article.o-teaser--small.o-teaser--has-image.js-teaser");

            for (Element article : articles) {
                String title = article.select("a.js-teaser-heading-link").text();
                System.out.println(title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

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
        String url = "https://finance.yahoo.com/topic/economic-news/";
        Article arty = new Article();
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> imageUrls = new ArrayList<>();
        ArrayList<String> ArticleContent = new ArrayList<>();
        ArrayList<String> Sources = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Elements articles = document
                    .select("section.container.sz-xx-large.optimizedStream.yf-18vjxqk.responsive.rev");

            for (Element article : articles) {
                String contentURL = article.select("a.subtle-link.fin-size-small.thumb.yf-iqvwrv").attr("href");
                String title = article.select("img.tw-bg-opacity-25.yf-1ev0m0b").attr("alt");
                String imageUrl = article.select("img.tw-bg-opacity-25.yf-1ev0m0b").attr("src");
                String source = article.select(".publishing.yf-m1e6lz").text();
                if (source.contains("Investing.com") || source.contains("StockStory")) {
                    ;
                } else {
                    Document doccy = Jsoup.connect(contentURL).get();
                    Elements contents = doccy.select("p.yf-1090901");
                    String Text = "";
                    for (Element content : contents) {
                        Text += content.text() + "\n\n";
                    }
                    ArticleContent.add(Text);
                    titles.add(title);
                    imageUrls.add(imageUrl);
                    Sources.add(source);
                }
            }
            arty.buildArticle(titles, imageUrls, ArticleContent, Sources);
            return arty;
        } catch (IOException e) {
            e.printStackTrace();
            return arty;
        }
    }
}

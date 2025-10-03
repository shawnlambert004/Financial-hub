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
        ArrayList<String> ByLine = new ArrayList<>();
        ArrayList<String> BigImUrls = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Elements articles = document
                    .select("section.container.sz-xx-large.optimizedStream.yf-18vjxqk.responsive.rev");

            for (Element article : articles) {
                String contentURL = article.select("a.subtle-link.fin-size-small.thumb.yf-iqvwrv").attr("href");

                if (contentURL.isEmpty()) {
                    continue;
                }
                String title = article.select("img.tw-bg-opacity-25.yf-1ev0m0b").attr("alt");
                String imageUrl = article.select("img.tw-bg-opacity-25.yf-1ev0m0b").attr("src");
                String source = article.select(".publishing.yf-m1e6lz").text();
                if (source.contains("Investing.com") || source.contains("StockStory")
                        || source.contains("Motley Fool") || source.contains("Bloomberg")
                        || source.contains("Reuters") || source.contains("Yahoo Personal Finance")
                        || source.contains("Benzinga")) {
                    ;
                } else {
                    Document doccy = Jsoup.connect(contentURL).get();
                    Elements contents = doccy.select("p.yf-1090901");
                    String byline = doccy.select("time.byline-attr-meta-time").text();
                    String bigIm = doccy.select("meta[property='og:image']").attr("content");
                    String Text = "";
                    for (Element content : contents) {
                        Text += content.text() + "\n\n";
                    }
                    ArticleContent.add(Text);
                    titles.add(title);
                    imageUrls.add(imageUrl);
                    Sources.add(source);
                    ByLine.add(byline);
                    BigImUrls.add(bigIm);
                }
            }
            arty.buildArticle(titles, imageUrls, ArticleContent, Sources, ByLine, BigImUrls);
            return arty;
        } catch (IOException e) {
            e.printStackTrace();
            return arty;
        }
    }
}

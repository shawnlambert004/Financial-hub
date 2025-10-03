package com.shawn.financial_hub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "application_articles")
public class SavedArticles {
    @Id
    @GeneratedValue
    @JsonProperty("user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "imageURL", columnDefinition = "TEXT")
    private String imageURL;

    @Column(name = "contents", columnDefinition = "TEXT")
    private String contents;

    @Column(name = "sources", columnDefinition = "TEXT")
    private String sources;

    @Column(name = "byLine", columnDefinition = "TEXT")
    private String byLine;

    public SavedArticles() {
    };

    public String getTitle() {
        return title;
    };

    public void setTitle(String title) {
        this.title = title;
    };

    public String getImageURL() {
        return imageURL;
    };

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    };

    public String getContents() {
        return contents;
    };

    public void setContents(String contents) {
        this.contents = contents;
    };

    public String getByLine() {
        return byLine;
    };

    public void setByLine(String byLine) {
        this.byLine = byLine;
    };

    public Long getId() {
        return id;
    };

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

}

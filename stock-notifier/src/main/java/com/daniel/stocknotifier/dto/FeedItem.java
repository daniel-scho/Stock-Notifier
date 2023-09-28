package com.daniel.stocknotifier.dto;

import java.util.List;

public class FeedItem {

    private String title;
    private String url;
    private String time_published;
    private List<String> authors;
    private String summary;
    private String banner_image;
    private String source;
    private String category_within_source;
    private String source_domain;
    private Integer overall_sentiment_score;
    private String overall_sentiment_label;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime_published() {
        return time_published;
    }

    public void setTime_published(String time_published) {
        this.time_published = time_published;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(String banner_image) {
        this.banner_image = banner_image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategory_within_source() {
        return category_within_source;
    }

    public void setCategory_within_source(String category_within_source) {
        this.category_within_source = category_within_source;
    }

    public String getSource_domain() {
        return source_domain;
    }

    public void setSource_domain(String source_domain) {
        this.source_domain = source_domain;
    }

    public Integer getOverall_sentiment_score() {
        return overall_sentiment_score;
    }

    public void setOverall_sentiment_score(Integer overall_sentiment_score) {
        this.overall_sentiment_score = overall_sentiment_score;
    }

    public String getOverall_sentiment_label() {
        return overall_sentiment_label;
    }

    public void setOverall_sentiment_label(String overall_sentiment_label) {
        this.overall_sentiment_label = overall_sentiment_label;
    }

    @Override
    public String toString() {
        return "FeedItem{" +
                "title='" + title + '\n' +
                ", url='" + url + '\n' +
                ", time_published='" + time_published + '\n' +
                ", authors=" + authors +
                ", summary='" + summary + '\n' +
                ", banner_image='" + banner_image + '\n' +
                ", source='" + source + '\n' +
                ", category_within_source='" + category_within_source + '\n' +
                ", source_domain='" + source_domain + '\n' +
                ", overall_sentiment_score=" + overall_sentiment_score +
                ", overall_sentiment_label='" + overall_sentiment_label + '\n' +
                '}';
    }

    public String formatToMessage() {
        return  title + '\n' +
                url + '\n' +
                time_published + '\n' +
                authors +
                summary + '\n' +
                "Category: " + category_within_source + '\n' +
                "Overall Sentiment Score=" + overall_sentiment_score + '\n' +
                "Overall Sentiment Label='" + overall_sentiment_label + '\n';
    }
}

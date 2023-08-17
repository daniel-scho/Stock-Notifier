package com.daniel.stocknotifier.dto;

import java.util.List;

public class AlphaVantageSentimentResponse {

    private String items;
    private String sentiment_score_definition;
    private String relevance_score_definition;
    private List<FeedItem> feed;

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getSentiment_score_definition() {
        return sentiment_score_definition;
    }

    public void setSentiment_score_definition(String sentiment_score_definition) {
        this.sentiment_score_definition = sentiment_score_definition;
    }

    public String getRelevance_score_definition() {
        return relevance_score_definition;
    }

    public void setRelevance_score_definition(String relevance_score_definition) {
        this.relevance_score_definition = relevance_score_definition;
    }

    public List<FeedItem> getFeed() {
        return feed;
    }

    public void setFeed(List<FeedItem> feed) {
        this.feed = feed;
    }

    @Override
    public String toString() {
        return "AlphaVantageSentimentResponse{" +
                "items='" + items + '\'' +
                ", sentiment_score_definition='" + sentiment_score_definition + '\'' +
                ", relevance_score_definition='" + relevance_score_definition + '\'' +
                ", feed=" + feed +
                '}';
    }
}

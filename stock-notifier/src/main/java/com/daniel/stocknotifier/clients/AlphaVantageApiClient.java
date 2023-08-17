package com.daniel.stocknotifier.clients;

import com.daniel.stocknotifier.dto.AlphaVantageSentimentResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class AlphaVantageApiClient {
    @Value("${api.alpha-vantage.key}")
    private String apiKey;

    private final WebClient webClient;

    public AlphaVantageApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.alphavantage.co/query?").build();
    }

    @PostConstruct
    public void init() {
        this.getNewsSentimentOfTicker("IBM");
    }
    public void getNewsSentimentOfTicker(String ticker) {
        WebClient.ResponseSpec response = this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("function", "NEWS_SENTIMENT")
                        .queryParam("tickers", ticker)
                        .queryParam("apikey", apiKey)
                .build())
                .retrieve();

        Mono<AlphaVantageSentimentResponse> mappedJson = response.bodyToMono(AlphaVantageSentimentResponse.class);
        AlphaVantageSentimentResponse responseObject = mappedJson.block();

        System.out.println(responseObject.getFeed().get(0).toString());
    }
}

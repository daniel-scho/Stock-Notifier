package com.daniel.stocknotifier.components;

import com.daniel.stocknotifier.clients.AlphaVantageApiClient;
import com.daniel.stocknotifier.dto.AlphaVantageSentimentResponse;
import com.daniel.stocknotifier.services.messaging.DiscordMessagingService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppTaskScheduler {

    private final AlphaVantageApiClient alphaVantageApiClient;
    private final DiscordMessagingService discordMessagingService;


    public AppTaskScheduler(
            AlphaVantageApiClient alphaVantageApiClient,
            DiscordMessagingService discordMessagingService) {
        this.alphaVantageApiClient = alphaVantageApiClient;
        this.discordMessagingService = discordMessagingService;
    }

    @Scheduled(fixedRate = 10800000) //10800000 milliseconds = 3 hours initialDelay = 10800000
    public void executeEveryThreeHours() {

        AlphaVantageSentimentResponse response = alphaVantageApiClient.getNewsSentimentOfTicker("IBM");
        this.discordMessagingService.sendMessage(response.getFeed().get(0).formatToMessage());
    }

    @Scheduled(cron = "0 0 9-17/2 * * MON-FRI")
    public void doEveryTwoHoursDuringTradingHours() {

    }
}

package com.daniel.stocknotifier.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StocksService {

    private static final Logger logger = LoggerFactory.getLogger(StocksService.class);
    @Value("${test.api_key}")
    public String key;
    public String getStock(Integer stockId) {
        logger.warn("Hier wird der logger ausgeführt");
        logger.info("Hier wird der info logger ausgeführt");

        return "get stock: " + stockId + key;
    }
}

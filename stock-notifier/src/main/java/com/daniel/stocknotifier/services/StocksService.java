package com.daniel.stocknotifier.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StocksService {

    public String getStock(Integer stockId) {
        return "get stock: " + stockId;
    }
}

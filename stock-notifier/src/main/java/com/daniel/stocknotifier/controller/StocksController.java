package com.daniel.stocknotifier.controller;

import com.daniel.stocknotifier.entity.Stock;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stocks")
public class StocksController {

    @GetMapping("/{stockId}")
    public String getStock(@PathVariable Integer stockId) {
        return "get stock: " + stockId;
    }

    @GetMapping("/{stockId}/{userId}")
    public String getStock1(@PathVariable Integer stockId, @PathVariable Integer userId) {
        return "get stockId: " + stockId + "userId: " + userId;
    }

    @PostMapping("add")
    public String addStock(@RequestBody Stock stock) {
        return stock.toString();
    }

    @PutMapping("update")
    public String updateStock() {
        return "stocks updated";
    }

    @DeleteMapping("delete")
    public String deleteStock() {
        return "stocks deleted";
    }
}

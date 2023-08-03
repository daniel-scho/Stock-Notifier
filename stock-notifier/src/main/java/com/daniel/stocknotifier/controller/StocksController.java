package com.daniel.stocknotifier.controller;

import com.daniel.stocknotifier.entity.Stock;
import com.daniel.stocknotifier.services.StocksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;


@RestController
@RequestMapping("/api/v1/stocks")
public class StocksController {

    private StocksService stocksService;

    public StocksController(StocksService stocksService) {
        this.stocksService = stocksService;
    }

    @GetMapping("/{stockId}")
    public ResponseEntity<Stock> getStock(@PathVariable Integer stockId) {
        Stock stock = stocksService.getStock(stockId)
                .orElseThrow(() -> new NoSuchElementException("Stock was not found with id" + stockId));
        return ResponseEntity.ok(stock);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stocksService.getAllStock();
        return ResponseEntity.ok(stocks);
    }

    @PostMapping("add")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        Stock savedStock = stocksService.addStock(stock);
        URI location =  MvcUriComponentsBuilder
                .fromMethodCall(on(StocksController.class).getStock(savedStock.getId()))
                .build()
                .toUri();
        return ResponseEntity.created(location).body(savedStock);
    }

    @PutMapping("/{stockId}")
    public ResponseEntity<Stock> updateStock(@PathVariable("stockId") Integer id,
                              @RequestBody Stock stockDetails) {
        Stock updateStock = stocksService.updateStock(id, stockDetails);
        return ResponseEntity.ok(updateStock);
    }

    @DeleteMapping("/{stockId}")
    public ResponseEntity<Stock> deleteStock(@PathVariable Integer stockId) {
        Stock deletedStock = stocksService.deleteStock(stockId);
        return ResponseEntity.ok(deletedStock);
    }
}

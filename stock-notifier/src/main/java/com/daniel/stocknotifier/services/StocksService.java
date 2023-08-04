package com.daniel.stocknotifier.services;

import com.daniel.stocknotifier.entity.Stock;
import com.daniel.stocknotifier.error.ResourceNotFoundException;
import com.daniel.stocknotifier.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StocksService {
    private static final Logger logger = LoggerFactory.getLogger(StocksService.class);

    private final StockRepository stockRepository;

    public StocksService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }
    public Optional<Stock> getStock(Integer stockId) {
        return stockRepository.findById(stockId);
    }

    public Stock addStock(Stock stock) { return stockRepository.save(stock); }


    public Stock updateStock(Integer id, Stock stockDetails) {
        return stockRepository.findById(id)
                .map(stock -> {
                    stock.setCompanyName(stockDetails.getCompanyName());
                    stock.setTicker(stockDetails.getTicker());
                    return stockRepository.save(stock);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Element not found with id " + id));
    }

    public Stock deleteStock(Integer stockId) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Element not found with id " + stockId));
        stockRepository.delete(stock);

        return stock;

    }
}

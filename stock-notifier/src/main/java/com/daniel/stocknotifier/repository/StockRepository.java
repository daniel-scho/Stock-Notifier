package com.daniel.stocknotifier.repository;

import com.daniel.stocknotifier.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Optional<Stock> findByTicker(String ticker);
}

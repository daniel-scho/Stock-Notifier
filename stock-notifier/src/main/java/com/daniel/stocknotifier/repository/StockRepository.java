package com.daniel.stocknotifier.repository;

import com.daniel.stocknotifier.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}

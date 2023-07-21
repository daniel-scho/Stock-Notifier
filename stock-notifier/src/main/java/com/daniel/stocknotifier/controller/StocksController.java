package com.daniel.stocknotifier.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stocks")
public class StocksController {

    @GetMapping("/hallo1")
    public String helloWorld() {
        return "hallo wie gehts";
    }

    @GetMapping("hallo2")
    public String helloWorld1() {
        return "hallo das ist api/hallo";
    }

    @PostMapping("add")
    public String addStock() {
        return "stocks added";
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

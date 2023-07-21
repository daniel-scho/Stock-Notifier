package com.daniel.stocknotifier.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StocksController {

    @GetMapping("")
    public String helloWorld() {
        return "hallo wie gehts";
    }

    @GetMapping("/api/hallo")
    public String helloWorld1() {
        return "hallo das ist api/hallo";
    }
}

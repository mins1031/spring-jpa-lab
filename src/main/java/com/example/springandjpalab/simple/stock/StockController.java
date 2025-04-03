package com.example.springandjpalab.simple.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping("/test")
    public ResponseEntity<Void> findProductsByStore() {
//        stockService.testMethod();
        return ResponseEntity.of(null);
    }
}

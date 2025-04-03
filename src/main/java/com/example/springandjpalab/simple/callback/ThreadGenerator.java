package com.example.springandjpalab.simple.callback;

import com.example.springandjpalab.simple.stock.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ThreadGenerator implements ThreadGeneratorInterface{
    private final StockService stockService;

    @Override
    @Transactional
    public void create(Integer index) {
        System.out.println(index);
    }

}

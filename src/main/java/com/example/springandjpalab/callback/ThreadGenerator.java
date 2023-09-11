package com.example.springandjpalab.callback;

import com.example.springandjpalab.stock.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Retention;

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

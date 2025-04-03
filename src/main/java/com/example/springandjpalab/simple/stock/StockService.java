package com.example.springandjpalab.simple.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    @Transactional
    public void decrease(Long id, Long minusQuantity) {
        //재고 get -> 재고감소 -> 감소재고 저장
        Stock stock = stockRepository.findById(id).orElseThrow(RuntimeException::new);

        stock.decrease(minusQuantity);

        stockRepository.saveAndFlush(stock);
    }

    public void testMethod() throws Exception {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 11, 7, 8, 9, 10);
//        for (Integer integer : integers) {
//            LoopTestObject.occurExceptionWhenValueOverTen(integer);
//        }
        integers.stream().forEach(integer -> {
                    try {
                        LoopTestObject.occurExceptionWhenValueOverTen(integer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}

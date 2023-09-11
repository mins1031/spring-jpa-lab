package com.example.springandjpalab.stock;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Long quantity;

    public Stock(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public void decrease(Long minusQuantity) {
        if ((this.quantity - minusQuantity) < 0) {
            throw new RuntimeException("잘못된 동작");
        }

        this.quantity = this.quantity - minusQuantity;
    }
}


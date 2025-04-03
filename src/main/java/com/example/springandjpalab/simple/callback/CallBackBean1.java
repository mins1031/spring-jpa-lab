package com.example.springandjpalab.simple.callback;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Component
public class CallBackBean1 {

    private String name;

    public CallBackBean1() {
    }

    @PostConstruct
    public void init() {
        System.out.println("bean1 init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("bean1 destroy");
    }
}

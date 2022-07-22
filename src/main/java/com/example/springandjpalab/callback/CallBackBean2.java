package com.example.springandjpalab.callback;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Component
public class CallBackBean2 {

    private String name;

    public CallBackBean2() {
    }

    @PostConstruct
    public void init() {
        System.out.println("bean2 init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("bean2 destroy");
    }
}

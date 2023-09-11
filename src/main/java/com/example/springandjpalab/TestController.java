package com.example.springandjpalab;

import com.example.springandjpalab.callback.ThreadGenerator;
import com.example.springandjpalab.callback.ThreadGeneratorInterface;
import org.apache.catalina.util.ToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ThreadGeneratorInterface threadGenerator;

    @GetMapping("/4000/{index}")
    public void test_4000(@PathVariable Integer index) throws InterruptedException {
//        for (int i=0; i < 4000; i++) {
//            System.out.println("index : " + i);
//
////            threadGenerator.create();
//        }
        threadGenerator.create(index);
        System.out.println("dd");
        return;
    }

    @PostMapping("/test")
    public void testPost() {
        System.out.println("test");
    }
}

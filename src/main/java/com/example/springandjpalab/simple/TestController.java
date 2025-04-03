package com.example.springandjpalab.simple;

import com.example.springandjpalab.simple.callback.ThreadGeneratorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ThreadGeneratorInterface threadGenerator;

    @GetMapping("/test/sleep")
    public String test() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("test");
        return "done!!";
    }

    @PostMapping("/test2")
    public void testPost() {
        System.out.println("test");
    }
}

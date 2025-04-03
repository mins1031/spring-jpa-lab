package com.example.springandjpalab.simple.callback;

import org.springframework.stereotype.Service;

@Service
public interface ThreadGeneratorInterface {
    void create(Integer index);
}

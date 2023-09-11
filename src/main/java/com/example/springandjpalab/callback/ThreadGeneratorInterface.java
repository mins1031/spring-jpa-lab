package com.example.springandjpalab.callback;

import org.springframework.stereotype.Service;

@Service
public interface ThreadGeneratorInterface {
    void create(Integer index);
}

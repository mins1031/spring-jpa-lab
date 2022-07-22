package com.example.springandjpalab;

import com.example.springandjpalab.callback.CallBackBean1;
import com.example.springandjpalab.callback.CallBackBean2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("h2")
public class CallBackTest {

    @Autowired
    private CallBackBean1 callBackBean1;

    @Autowired
    private CallBackBean2 callBackBean2;

    @DisplayName("초기화 콜백 실행 확인")
    @Test
    public void name() {
        //given
        //when
        //then
    }

}

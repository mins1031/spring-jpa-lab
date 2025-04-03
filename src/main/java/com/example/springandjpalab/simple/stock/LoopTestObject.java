package com.example.springandjpalab.simple.stock;

public class LoopTestObject {

    public static void occurExceptionWhenValueOverTen(Integer integer) throws Exception {
        if (integer > 10) {
            throw new Exception("10 넘어가서 에러 발생");
        }

        System.out.println(integer);
    }
}

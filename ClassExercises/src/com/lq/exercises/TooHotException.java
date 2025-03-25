package com.lq.exercies;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 4 예외 처리
 *
 * @author 이병관
 * @since 2025.03.25
 */
public class TooHotException extends Exception {

    public TooHotException() {
        super();
    }

    public TooHotException(String arg0) {
        super(arg0);
    }
}
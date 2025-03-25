package com.learnquest.demos.transport;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 4 예외 처리
 *
 * @author 이병관
 * @since 2025.03.25
 */
public class SpeedException extends Exception {
    /**
     * 메시지를 받아들이는 생성자
     * 속도 예외를 만들 수 있는 유일한 방법은 속도 예외를 만들고 메시지를 제공하는 것 뿐으로 한정
     */
    public SpeedException(String message) {
        super(message);
    }
}
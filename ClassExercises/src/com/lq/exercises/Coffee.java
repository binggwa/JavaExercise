package com.lq.exercises;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 4 예외 처리
 *
 * @author 이병관
 * @since 2025.03.25
 */
public class Coffee {
    private int temperature;
    /**
     * temperature를 받는 생성자
     */
    public Coffee(int temperature) throws TooHotException {
        super();
        this.setTemperature(temperature);
    }
    /**
     * 기본 생성자
     */
    public Coffee() {
    }

    public int getTemperature() {
        return temperature;
    }
    /**
     * int 온도를 받아 void를 반환하는 setTemperature
     * 온도가 120도가 넘으면 TooHotException으로 던져 예외처리
     */
    public void setTemperature(int temperature) throws TooHotException {
        if (temperature > 120) {
            throw new TooHotException("coffee is too hot");
        } else {
            this.temperature = temperature;
        }
    }
}
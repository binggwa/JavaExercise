package com.lq.enums;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 6 열거형
 *
 * @author 이병관
 * @since 2025.03.28
 */
public enum TirePressures {
    LF(30, "Left Front"),
    RF(30, "Right Front"),
    LR(32, "Left Rear"),
    RR(32, "Right Rear");

    private int pressure;
    private String name;

    private TirePressures(int pressure, String name) {
        this.pressure = pressure;
        this.name = name;
    }

    public int getPressure() {
        return pressure;
    }

    public String getName() {
        return name;
    }

    public void overridePressure(int newPressure) {
        this.pressure = newPressure;
    }
}
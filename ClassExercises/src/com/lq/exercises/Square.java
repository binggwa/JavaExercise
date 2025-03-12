package com.lq.exercises;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조
 * Module 5 인터페이스 작업 예제
 *
 * @author 이병관
 * @since 2025.03.12
 */
public class Square extends Rectangle implements TwoDimensional {
    /**
     * @param side
     */
    public Square(double side) {
        super (side, side);
    }
}
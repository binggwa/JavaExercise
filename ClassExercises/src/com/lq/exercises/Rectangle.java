package com.lq.exercises;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조
 * Module 5 인터페이스 작업 예제
 *
 * @author 이병관
 * @since 2025.03.12
 */
public class Rectangle extends Shape implements TwoDimensional {

    private double length;
    private double width;
    /**
     * @param length
     * @param width
     */
    public Rectangle(double length, double width) {
        this(length, width, "White", "Unknown");
    }
    /**
     * @param length
     * @param width
     * @param color (from Shape)
     * @param name (from Shape)
     */
    public Rectangle(double length, double width, String color, String name) {
        super();
        setLength(length);
        setWidth(width);
        setColor(color);
        setName(name);
    }
    /**
     * 속성에 대한 게터와 세터 설정
     */
    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
    /**
     * TwoDimensional 인터페이스의 메서드 구현
     */
    public double getArea() {
        return ( getLength() * getWidth() );
    }

    public double getPerimeter() {
        return (2 * ( getLength() + getWidth() ));
    }
}
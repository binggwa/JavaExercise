package com.lq.exercises;

import static java.lang.Math.PI;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조
 * Module 5 인터페이스 작업 예제
 *
 * @author 이병관
 * @since 2025.03.12
 */
public class Circle extends Shape implements TwoDimensional {

    private double radius;
    /**
     * @param radius
     */
    public Circle(double radius) {
        this(radius, "White", "Unknown");
    }
    /**
     * @param radius, color, name
     */
    public Circle(double radius, String color, String name) {
        setRadius(radius);
        setColor(color);
        setName(name);
    }
    /**
     * TwoDimensional 인터페이스의 메서드 구현
     */
    @Override
    public double getArea() {
        return PI * radius * radius;
    }
    /**
     * TwoDimensional 인터페이스의 메서드 구현
     */
    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }
    /**
     * 속성 radius에 대한 게터와 세터
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    /**
     * 25.03.13
     * ExercisePrint 예제 출력을 위한 toString
     */
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	builder.append("Circle [radius = ");
    	builder.append(radius);
    	builder.append(", color = ");
    	builder.append(getColor());
    	builder.append(", name = ");
    	builder.append(getName());
    	builder.append("]");
    	return builder.toString();
    }
}
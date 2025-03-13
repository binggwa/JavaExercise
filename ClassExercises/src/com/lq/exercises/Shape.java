package com.lq.exercises;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조
 * Module 5 인터페이스 작업 예제
 *
 * @author 이병관
 * @since 2025.03.12
 */
public abstract class Shape {

    private String name;
    private String color;
    /**
     * 각 속성에 대한 게터와 세터 설정
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    /**
     * 25.03.13
     * ExercisePrint 예제 출력을 위한 toString
     */
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	builder.append("Shape [color = ");
    	builder.append(color);
    	builder.append(", name = ");
    	builder.append(name);
    	builder.append("]");
    	return builder.toString();
    }
}
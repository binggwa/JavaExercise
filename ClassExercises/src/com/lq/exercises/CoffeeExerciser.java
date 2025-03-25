package com.lq.exercises;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 4 예외 처리
 *
 * @author 이병관
 * @since 2025.03.25
 */
import static java.lang.System.out;

public class CoffeeExerciser {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        try {
            /**
             * 너무 뜨겁지 않은 온도로 설정
             */
            coffee.setTemperature(110);
            /**
             * 예외가 던져질 수 있는 온도 설정
             */
            // coffee.setTemperature(150);
        } catch (TooHotException e) {
            out.println(e.getMessage());
        } finally {
            out.println("Coffee is set to " + coffee.getTemperature());
        }
    }
}
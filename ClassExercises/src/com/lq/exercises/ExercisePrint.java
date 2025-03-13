package com.lq.exercises;

/**
 * CoreJava 강의 Java의 객체 지향 계층 구조
 * Module 6 다형성 예제
 *
 * @author 이병관
 * @since 2025.03.13
 */
public class ExercisePrint {

    public static void main(String[] args) {

        Shape[] shape = new Shape[5];

        shape[0] = new Rectangle(5.0, 4.0, "White", "Rec");
        shape[1] = new Square(5.0, "White", "Squ");
        shape[2] = new Cube(5.0, "White", "Cub");
        shape[3] = new Box(5.0, 4.0, 3.0, "White", "Box");
        shape[4] = new Circle(5.0, "White", "Cir");

        for ( Shape shapes : shape ) {
            System.out.println( shapes );
        }
    }
}
package com.lq.exercises;

/**
 * CoreJava 강의 Java의 객체 지향 계층 구조
 * Module 5 인터페이스 작업 예제
 *
 * @author 이병관
 * @since 2025.03.12
 */
public class ExerciseShapes {

    public static void main(String[] args) {
        /**
         * 도형 개체 8개로 구성된 배열
         */
        Shape[] shapes = new Shape[8];
        /**
         * 직사각형, 정사각형, 정육면체, 상자 2개씩을 배열에 추가
         */
        shapes[0] = new Rectangle(5.0, 4.0);
        shapes[1] = new Rectangle(5.0, 5.0);

        shapes[2] = new Square(5.0);
        shapes[3] = new Square(8.0);

        shapes[4] = new Cube(5.0);
        shapes[5] = new Cube(12.0);

        shapes[6] = new Box(12.0);
        shapes[7] = new Box(3.0);
        /**
         * 배열을 반복하면서 setColor와 getVolume 테스트
         * getVolume은 3차원에서만 작동하기 때문에 실패
         */
        /*
        for ( Shape shape: shapes ) { shape.setColor("Silver"); }
        for ( shape shape: shapes ) {
            ThreeDimensional temp = (ThreeDimensional) shape;
            System.out.println(temp.getVolume());
        }
        */
        /**
         * Circle을 테스트할 TwoDimensional 배열 추가
         */
        TwoDimensional[] TwoDs = new TwoDimensional[3];
        /**
         * TwoDimensional 배열에 원, 직사각형, 정사각형 추가
         */
        TwoDs[0] = new Circle(7.0);
        TwoDs[1] = new Rectangle(5.0, 4.0);
        TwoDs[2] = new Square(5.67);
        /**
         * 배열을 반복하며 2차원 인터페이스의 기능인 getArea와 getPerimeter 테스트
         */
        for ( TwoDimensional temp: TwoDs ) {
            System.out.println( temp.getArea() );
            System.out.println( temp.getPerimeter() );
        }
    }
}
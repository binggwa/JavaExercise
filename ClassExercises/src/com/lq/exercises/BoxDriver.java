package com.lq.exercises;
/**
 * CoreJava 강의 Java를 사용하는 객체 지향 프로그래밍 소개 
 * Module 3 객체 만들기 예제
 * 
 * @author 이병관
 * @since 2025.02.26
 */
public class BoxDriver {

	public static void main(String[] args) {
		/**
		 * box1, box2라는 인스턴스를 생성해 생성자로 길이, 넓이, 높이를 지정
		 */
		Box box1 = new Box(5, 6, 7);
		Box box2 = new Box(10);
		/**
		 * get 메서드를 사용해 입력된 길이, 넓이, 높이를 출력
		 */
		System.out.println("Box 1 length is " + box1.getLength());
		System.out.println("Box 1 width is " + box1.getWidth());
		System.out.println("Box 1 height is " + box1.getHeight());
		System.out.println("Box 2 length is " + box2.getLength());
		System.out.println("Box 2 width is " + box2.getWidth());
		System.out.println("Box 2 height is " + box2.getHeight());
		/**
		 * 비즈니스 메서드 테스트
		 * 
		 * box1의 사양을 변경하여 올바르게 작동하는지 확인
		 */
		box1.setLength(3);
		box1.setWidth(4);
		box1.setHeight(5);
		/**
		 * getVolume과 getSurfaceArea 메서드를 이용해 올바르게 작동하는지 확인
		 */
		box1.getVolume();
		box1.getSurfaceArea();
		/**
		 * 만들어둔 printBox 메서드를 이용해 제대로 출력되는지 확인
		 */
		box1.printBox();
		/**
		 * 잘못된 값을 세팅하여 유효하지 않은 값이 들어갔을 때 어떻게 출력되는지 확인
		 */
		box1.setLength(-5);
		box1.printBox();

		
	}
}

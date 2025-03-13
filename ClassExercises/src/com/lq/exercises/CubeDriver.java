package com.lq.exercises;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조 
 * Module 3 상속 작업
 * 
 * @author 이병관
 * @since 2025.03.06
 * 
 * Cube 자식클래스를 실행해보는 CubeDriver 클래스
 */
public class CubeDriver {

	public static void main(String[] args) {
		/**
		 * 큐브 2개를 만들어 각각 변의 길이를 설정
		 */
		Cube cube1 = new Cube(5);
		Cube cube2 = new Cube(8);
		/**
		 * 길이를 변경하여 메서드가 잘 상속되었는지 확인
		 */
		System.out.println("Cube 1 height = " + cube1.getHeight());
		System.out.println("Cube 1 length = " + cube1.getLength());
		System.out.println("Cube 1 width = " + cube1.getWidth());

		System.out.println();

		System.out.println("Cube 2 height = " + cube2.getHeight());
		System.out.println("Cube 2 length = " + cube2.getLength());
		System.out.println("Cube 2 width = " + cube2.getWidth());
		
		System.out.println();
		/**
		 * Box 클래스에 있는 printBox 메서드가 cube1 인스턴스에서 작동함을 확인
		 */
		cube1.setLength(20);
		cube1.printBox();
		System.out.println();
		
		cube1.setSides(40);
		cube1.printBox();
		/**
		 * 유효하지 않은 값을 넣어 오류메시지가 제대로 출력되는지 확인
		 */
		cube2.setWidth(-5);
		cube2.printBox();
	}
}

package com.lq.exercises;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조 
 * Module 3 상속 작업
 * 
 * @author 이병관
 * @since 2025.03.06
 * 
 * Box를 확장하는 Cube라는 새 클래스를 구현
 */
public class Cube extends Box {
	/**
	 * Box와 비슷하지만, 세 변은 모두 동일하도록 설정하기 위해 Box 슈퍼클래스의 side를 이용한 생성자로 Cube 생성자 정의
	 */
	public Cube(double side) {
		super(side);
	}
	/**
	 * 25.03.13 ExercisePrint를 위한 생성자 추가
	 */
	public Cube(double side, String color, String name) {
		super(side);
		setColor(color);
		setName(name);
	}
	/**
	 * 오버라이딩을 통해 높이, 넓이, 길이를 설정하는 메서드를 상속
	 */
	@Override
	public void setHeight(double height) {
		if (super.getHeight() != height) {
			setSides(height);
		}
	}

	@Override
	public void setWidth(double width) {
		if (super.getHeight() != width) {
			setSides(width);
		}
	}

	@Override
	public void setLength(double length) {
		if (super.getHeight() != length) {
			setSides(length);
		}
	}
	/**
	 * 슈퍼클래스의 메서드를 재정의해 세 변의 길이를 설정
	 * double 매개변수 하나를 받아와 유효한 값이 아닐 경우 에러메시지를 출력하도록 설정
	 */
	public void setSides(double sides) {
		if (sides > 0) {
			super.setLength(sides);
			super.setWidth(sides);
			super.setHeight(sides);
			/**
			 * 만약 sides의 길이가 0보다 작을 경우, 에러 메시지를 출력하도록 설정
			 */
		} else {
			System.err.println("Passed value must be greater than zero");
		}
	}
	/**
	 * 매개변수를 받지 않고, 세 변이 같은 길이이므로 한 변의 길이만 가져와 double 형태로 반환하는 게터 생성
	 */
	public double getSides() {
		return super.getHeight();
	}
	

}

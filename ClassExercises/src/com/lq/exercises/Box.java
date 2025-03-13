package com.lq.exercises;

/**
 * CoreJava 강의 Java를 사용하는 객체 지향 프로그래밍 소개 
 * Module 2 클래스 생성하기 예제
 * 
 * @author 이병관
 * @since 2025.02.26
 */
public class Box {
	/**
	 * double 데이터 타입을 갖는 높이, 넓이, 길이 속성 설정
	 * 
	 * 기본값을 private 접근성과 함께 1로 설정하여 0보다 큰 세팅값이 아니면 1이 되도록 설정
	 */
	private double height = 1;
	private double width = 1;
	private double length = 1;
	/**
	 * 각 속성에 대한 게터와 세터 설정
	 */
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height > 0)
			this.height = height;
		else
			System.out.println("Height must be greater than 0");
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width > 0)
			this.width = width;
		else
			System.out.println("Width must be greater than 0");
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if (length > 0)
			this.length = length;
		else
			System.out.println("Length must be greater than 0");
	}
	/**
	 * 3개의 속성을 이용해 부피를 계산하는 메서드를 생성
	 */
	public double getVolume() {
		return (width * height * length);
	}
	/**
	 * 3개의 속성을 이용해 표면적을 계산하는 메서드를 생성
	 */
	public double getSurfaceArea() {
		return ((width*height + height*length + length*width)*2);
	}
	/**
	 * Box라는 길이, 넓이, 높이를 매개변수로 받는 생성자 생성.
	 * 
	 * if문을 통해 0보다 큰 값이 오지 않을 경우, 디폴트 값으로 설정
	 */
	public Box(double length, double width, double height) {
		if (length > 0)
		this.length = length;
		if (width > 0)
		this.width = width;
		if (height > 0)
		this.height = height;
	}
	/**
	 * Box라는 생성자를 1개의 매개변수로 3개의 속성 모두에 할당할 수 있는 생성자 생성.
	 */
	public Box(double cube) {
		this(cube, cube, cube);
	}
	/**
	 * printBox 메서드를 통해 박스의 길이, 넓이, 높이, 부피, 표면적에 대해 표시하는 메서드를 생성.
	 * 길이, 넓이, 높이 셋 중 하나라도 0보다 작거나 같은 값이 있을 경우, 유효하지 않은 속성이 있다고 출력.
	 */
	public void printBox() {
		if((height <= 0) || (width <= 0) || (length <= 0)) { 
			System.out.println("There are some invalid attributes");
		} else {
			System.out.println("Length = " + getLength());
			System.out.println("Width = " + getWidth());
			System.out.println("Height = " + getHeight());
			System.out.println("Volume = " + getVolume());
			System.out.println("Surface Area = " + getSurfaceArea());
		}
	}
}

package com.javaoo.calculators;
/**
 * CoreJava 강의 Java를 사용하는 객체 지향 프로그래밍 소개 
 * Module 2 계산기 클래스 만들기 예제 - 공학용
 * 
 * @author 이병관
 * @since 2025.02.26
 */
public class ScientificCalculator {
	/**
	 * Math 클래스의 PI값을 이용해 모든 인스턴스에서 공유되며 상수인, 즉 static final 값으로 선언함.
	 */
	public static final double PI = Math.PI;
	/**
	 * 값을 메모리에 보유하기 위한 double 형태의 holdValue, 클래스 내에서 관리될 수 있도록 비공개 가시성.
	 */
	private double holdValue;
	/**
	 * e^x를 계산하는 데 사용하는 메서드
	 */
	public static final double exp(double x) {
		return Math.exp(x);
	}
	/**
	 * log x 를 계산하는 데 사용되는 메서드
	 */
	public static final double log(double x) {
		return Math.log(x);
	}
	/**
	 * double 매개변수 1개를 받아 void 형태로 반환하는 메서드
	 * 매개변수에 입력된 값을 메모리에 넣는다.
	 */
	public final void putValueInMemory(double x) {
		holdValue = x;
	}
	/**
	 * 매개변수 없이 double을 반환하는 메서드
	 * 메모리로부터 값을 불러온다.
	 */
	public final double getValueFromMemory() {
		return holdValue;
	}
	/**
	 * Math 클래스의 PI값이 잘 출력되는지 체크하기 위한 main 메서드
	 */
	public static void main(String[] args) {
		System.out.println(PI);
	}
}

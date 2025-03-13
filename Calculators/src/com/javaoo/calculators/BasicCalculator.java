package com.javaoo.calculators;
/**
 * CoreJava 강의 Java를 사용하는 객체 지향 프로그래밍 소개 
 * Module 2 계산기 클래스 만들기 예제 - 기본
 * 
 * @author 이병관
 * @since 2025.02.26
 */
public class BasicCalculator {
	/**
	 * double 매개변수 2개를 받아 double 타입 결과를 반환하는 덧셈, 뺄셈, 곱셈, 나눗셈의 메서드 생성.
	 */
	public final double add(double x, double y) {
		return (x + y);
	}
	
	public final double subtract(double x, double y) {
		return (x - y);
	}
	
	public final double mlultiply(double x, double y) {
		return (x * y);
	}
	
	public final double divide(double x, double y) {
		return (x / y);
	}
}

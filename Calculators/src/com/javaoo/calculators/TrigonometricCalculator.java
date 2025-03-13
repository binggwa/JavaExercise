package com.javaoo.calculators;
/**
 * CoreJava 강의 Java를 사용하는 객체 지향 프로그래밍 소개 
 * Module 2 계산기 클래스 만들기 예제 - 삼각함수
 * 
 * @author 이병관
 * @since 2025.02.26
 */

public class TrigonometricCalculator {
	/**
	 * double 타입의 매개변수를 1개 받아들여 Math 클래스를 이용해 sin, cos, tan, arcsin, arccos, arctan 값을 double 타입으로 도출하는 메서드 작성
	 */
	public static double sin(double x) {
		return Math.sin(x);
	}
	
	public static double cos(double x) {
		return Math.cos(x);
	}
	
	public static double tan(double x) {
		return Math.tan(x);
	}
	
	public static double arcsin(double x) {
		return Math.asin(x);
	}
	
	public static double arccos(double x) {
		return Math.acos(x);
	}
	
	public static double arctan(double x) {
		return Math.atan(x);
	}

}

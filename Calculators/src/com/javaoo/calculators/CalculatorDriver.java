package com.javaoo.calculators;

/**
 * CoreJava 강의 Java를 사용하는 객체 지향 프로그래밍 소개 
 * Module 4 계산기 객체 만들기 예제 main 메서드 구현용
 * 
 * @author 이병관
 * @since 2025.02.27
 */
public class CalculatorDriver {
	/**
	 * main 메서드 시작
	 * 
	 * 공학용 계산기가 돌아가는지 확인하기 위해 계산기 클래스를 인스턴스화 후 메서드를 호출하여 println 구문을 통해 작동확인
	 */
	public static void main(String[] args) {

		ScientificCalculator cal1 = new ScientificCalculator();
		System.out.println(cal1.exp(Math.PI));

		TrigonometricCalculator cal2 = new TrigonometricCalculator();
		System.out.println(cal2.sin(0.523));

	}
}

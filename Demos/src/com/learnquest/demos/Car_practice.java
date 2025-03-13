package com.learnquest.demos;

import java.time.LocalDate;
import java.time.Period;

/**
 * CoreJava 강의 Java를 사용하는 객체 지향 프로그래밍 소개
 * Module 1 클래스 예시
 * 
 * @author 이병관
 * @since 2025.02.25
 * 
 *        클래스에 대한 설명을 위해 자동차를 예시로. 자동차라는 클래스 속도, 가솔린, 엔진상태라는 private attributes
 *        setSpeed(int newSpeed) 라는 public void method, getSpeed() 라는 public int method
 * 
 *        Java Beans에 관한 읽기자료 <- JavaBeans를 마스터하고 싶다면 사양을 읽고 검토 필요
 * 
 */

public class Car_practice {
	private int speed;
	private int gasoline;
	private boolean engineState;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}

	/**
	 * 읽기 전용 property를 만드는 방법에 대해서 학습
	 * 
	 * 자동차의 age property를 다른 age attribute 없이 만드는 방법
	 * 
	 * 읽을 수 있는 property를 만들기 위해서는, getter method가 필요하다. getter인 int getAge()는 값을 계산하거나 검색하는 방법을 보여주지 않는다.
	 * 
	 * LocalDate 클래스를 이용해 자동차의 생산일을 manufactured attribute에 저장하고, java 8의 new Time 패키지를 이용해 age property를 구현한다. 
	 * 
	 */
	private LocalDate manufactured;

	public int getAge() {
		return Period.between(manufactured, LocalDate.now()).getYears();
	}

}

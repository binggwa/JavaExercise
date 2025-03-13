package com.learnquest.demos.transport;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조
 * Module 2 객체 지향 및 다형성의 관계 예제
 * 
 * @author 이병관
 * @since 2025.03.05
 */
public class SportsCar extends Car {
	/**
	 * 부모 클래스의 생성자를 상속
	 */
	public SportsCar() {
	}

	public SportsCar(String name) {
		super(name);
	}

	public SportsCar(String name, int speed, int fuel, boolean running) {
		super(name, speed, fuel, running);
	}
	/**
	 * 부모 클래스의 setSpeed를 오버라이드시켜 newSpeed의 1.1배의 속도를 가지도록 설정
	 * setSpeed는 int값을 받아오기 때문에 int 를 통해 소수점을 떨어뜨릴 수 있음
	 * 
	 * 오버라이드는 런타임에는 전혀 영향을 주지 않음.
	 */
	@Override
	public void setSpeed(int newSpeed) {
		super.setSpeed((int) (newSpeed * 1.10));
	}
	/**
	 * 25.03.11
	 * 참조 유형 학습을 위한 race 메서드 추가
	 * race 메서드는 속도를 최대속도로 설정한다
	 */
	public void race() {
		setSpeed(getMaxSpeed());
	}
	/**
	 * 25.03.11
	 * 추상 클래스 학습으로 인한 getMaxSpeed 추상 메서드 정의
	 * Car 추상 클래스를 상속하여 getMaxSpeed를 자식 클래스에서 정의해줌
	 */
	@Override
	public int getMaxSpeed() {
		return 350;
	}
	
	

}

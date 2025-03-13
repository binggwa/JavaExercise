package com.learnquest.demos.transport;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조
 * Module 2 객체 지향 및 다형성의 관계 예제
 * 
 * @author 이병관
 * @since 2025.03.05
 */
public class StationWagon extends Cargo {

	public StationWagon() {
		super();	
	}

	public StationWagon(String name) {
		super(name);	
	}

	public StationWagon(String name, int speed, int fuel, boolean running) {
		super(name, speed, fuel, running);
	}
	/**
	 * StationWagon 클래스의 적재량 관련 멤버들을 Cargo 슈퍼클래스로 올리는 방법에 대해 학습
	 */
}

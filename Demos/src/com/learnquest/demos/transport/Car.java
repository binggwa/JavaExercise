package com.learnquest.demos.transport;

/**
 * CoreJava 강의 Java를 사용하는 객체 지향 프로그래밍 소개
 * Module 2 객체 예제
 * 
 * @author 이병관
 * @since 2025.02.25
 * 
 * LocalDate와 Period 클래스를 불러와 자동차의 manufactured로부터 age를 판별
 */
import java.time.LocalDate;
import java.time.Period;
/**
 * java.lang.Math.min을 미리 정적 임포트로 불러와둠으로써 이후 Math.min이 아닌, min만으로 사용할 수 있음을 학습함
 */
import static java.lang.Math.min;

public class Car {
	/**
	 * 생성자를 만드는 방법에 대해 학습함
	 */
	public Car() { }
	
	/**
	 * 1개의 매개변수로 4개의 속성에 할당할 수 있는 생성자
	 */
	public Car(String name) {
		this(name, 0, 0, false);
	}
	/**
	 * 서명이 다르면 서로 다른 생성자도 공존할 수 있다
	 */
	public Car(String name, int speed, int fuel, boolean running) {
		setName(name);
		setSpeed(speed);
		setGasoline(fuel);
		setEngineState(running);
	}
	/**
	 * static, 정적 키워드에 관해 학습함
	 * 25.03.05 StationWagon과 SportsCar 클래스를 이용한 상속개념 학습을 위한 MAX_SPEED 한도 변경
	 */
	private static final int MAX_SPEED = 350;
	private LocalDate manufactured;
	private String name;
	private int speed;
	private int gasoline;
	private boolean engineState;
	/**
	 * name 속성에 대한 getter와 setter 설정
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * speed 속성에 대한 getter와 setter 설정
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * 삼항연산자를 이용해 자동차의 스피드가 maxSpeed보다 큰 경우, maxSpeed로 설정하도록 제한을 걸어둔다
	 */
	/* 
	public void setSpeed(int newSpeed) {
		speed = newSpeed <= MAX_SPEED ? newSpeed : MAX_SPEED;
	}
	 */
	/**
	 * Javadocs의 Math 클래스를 통해 간단하게 나타내는 방법에 대해 알아봄
	 * import한 Math의 사용처
	 */
	public void setSpeed(int newSpeed) {
		speed = min(newSpeed, MAX_SPEED);
	}
	/**
	 * gasoline 속성에 대한 getter와 setter 설정
	 */
	public int getGasoline() {
		return gasoline;
	}

	public void setGasoline(int gasoline) {
		this.gasoline = gasoline;
	}
	/**
	 * engineState 속성에 대한 getter와 setter 설정
	 */
	public boolean isEngineState() {
		return engineState;
	}

	public void setEngineState(boolean engineState) {
		this.engineState = engineState;
	}
	/**
	 * manufactured 속성에 대한 getter와 setter 설정
	 */
	public LocalDate getManufactured() {
		return manufactured;
	}

	public void setManufactured(LocalDate manufactured) {
		this.manufactured = manufactured;
	}
	/**
	 * manufactured 속성에 입력된 값과 현재의 LocalDate를 가져와 그 차이를 통해 자동차의 age를 얻는다.
	 */
	public int getAge() {
		return Period.between(getManufactured(), LocalDate.now()).getYears();
	}
}

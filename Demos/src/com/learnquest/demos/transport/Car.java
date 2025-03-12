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
/**
 * 25.03.11 추상 클래스 학습을 위한 클래스 변경
 * 25.03.12 인터페이스 학습을 위한 클래스 변경
 */
public abstract class Car implements Vehicle {
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
	 //private static final int MAX_SPEED = 350;
	/**
	 * 25.03.11 추상 클래스 학습을 위한 abstract getMaxSpeed 추상메서드로 최대속도 변경
	 * 정해진 int 값이 아니라, 다른 종류의 차마다 최대속도를 다르게 설정할 수 있음
	 */
	public abstract int getMaxSpeed();
		
	private String name;

	/**
	 * name 속성에 대한 getter와 setter 설정
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int speed;

	/**
	 * speed 속성에 대한 getter와 setter 설정
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * 삼항연산자를 이용해 자동차의 스피드가 maxSpeed보다 큰 경우, maxSpeed로 설정하도록 제한을 걸어둔다
	 */
	/*public void setSpeed(int newSpeed) {
		speed = newSpeed <= MAX_SPEED ? newSpeed : MAX_SPEED;
	}
	*/
	/**
	 * Javadocs의 Math 클래스를 통해 간단하게 나타내는 방법에 대해 알아봄
	 * import한 Math의 사용처
	 */
	public void setSpeed(int newSpeed) {
		speed = min(newSpeed, getMaxSpeed());
	}
	
	private int gasoline;
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
	private boolean engineState;

	public boolean isEngineState() {
		return engineState;
	}

	public void setEngineState(boolean engineState) {
		this.engineState = engineState;
	}
	
	private LocalDate manufactured;

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
	/**
	 * 25.03.06 Object 슈퍼클래스의 hashCode, equals, toString 학습
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Car))
			return false;
		
		Car other = (Car) obj;
		
		return name.equals(other.getName());
	}
	/**
	 * 25.03.06 manufactured가 없다면, NULL값을 반환할 것이므로 문자열에 오류가 생기지 않도록 null일 경우 빼주도록 변경
	 */
	@Override
	public String toString() {
		if (manufactured == null)
			return String.format("%s is traveling at %d mph", getName(), getSpeed());
		else
			return String.format("%s is %d years old and is traveling at %d mph", getName(), getAge(), getSpeed());
	}
	
	
}

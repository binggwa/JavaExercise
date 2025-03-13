package com.learnquest.demos.transport;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조
 * Module 2 인터페이스 및 연결_화물 클래스 구현 예제
 * 
 * @author 이병관
 * @since 2025.03.05
 */
public class Cargo extends Car {

	private int cargoCapacity;
	private int currentCargoLoad;

	public Cargo() {
		super();
	}

	/**
	 * 부모 클래스의 setSpeed를 오버라이드시켜 현재화물적재량/100 만큼 속도에서 빼주는 식으로 설정
	 */
	@Override
	public void setSpeed(int newSpeed) {
		super.setSpeed(newSpeed - getCurrentCargoLoad() / 100);
	}

	/**
	 * 현재 적재량에 대한 세터 설정을 통해 StationWagon 서브클래스의 메서드가 CarApp에서 제대로 Car 클래스를 상속하면서 Wagon 클래스의 메서드를 가져가는지 확인
	 * 부모 클래스만으로는 자식 클래스의 메서드를 참조할 수 없었고, 자식 클래스 확장에 대해 이야기하려면, 자식 클래스 참조 유형이 있어야 했다.
	 * 
	 * StationWagon 서브클래스에 있던 적재량관련 멤버들을 Car와 StationWagon 사이의 Cargo 슈퍼클래스로 옮기는 방법을 학습.
	 */
	public void setCurrentCargoLoad(int currentCargoLoad) {
		this.currentCargoLoad = currentCargoLoad;	
	}

	public int getCurrentCargoLoad() {
		return currentCargoLoad;
	}

	public Cargo(String name) {
		super(name);
	}

	public Cargo(String name, int speed, int fuel, boolean running) {
		super(name, speed, fuel, running);
	}

}
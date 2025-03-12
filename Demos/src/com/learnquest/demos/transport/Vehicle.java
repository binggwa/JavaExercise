package com.learnquest.demos.transport;
/**
 * CoreJava 강의 Java를 사용하는 객체 지향 프로그래밍 소개
 * Module 5 인터페이스, 추상 클래스 및 다형성 예제 - 차량 데모
 *
 * @author 이병관
 * @since 2025.03.12
 *
 * Vehicle 인터페이스를 작성
 */
public interface Vehicle {
    public String getName();
    public void setName(String name);

    public int getspeed();
    public void setSpeed(int newSpeed);

    // 25.03.12
    // 인터페이스에 사양을 추가하게 되면, 해당 인터페이스를 사용하는 모든 클래스에 메서드를 구현해야 하는 문제점이 있다.
    // public void stop();
    // public void slow();
    /**
     * default 메서드를 이용해 문제없이 구현가능
     */
    public default void stop() {
        setSpeed(0);
    }

    public default void slow() {
        setSpeed(getSpeed() / 2);
    }

    /**
     * 25.03.12 인터페이스 학습을 위한 추가
     * default, static 학습을 위한 코드위치 변경
     */
    public static void travelAtSpeedLimit(Vehicle vehicle) {
        vehicle.setSpeed(55);
    }
}
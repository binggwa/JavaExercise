package com.learnquest.demoapps;

import java.time.LocalDate;

import com.learnquest.demos.transport.Car;
import com.learnquest.demos.transport.SportsCar;
import com.learnquest.demos.transport.StationWagon;

public class CarApp {
	/**
	 * main method 시작
	 * 25.03.05 상속 학습을 위해 Car 클래스로부터 메인 메서드 분리
	 * 
	 * Car 클래스에 대한 인스턴스 car54와 mach5를 만들어 이름, 속도, 제조일자를 설정한다.
	 * 
	 * 이후 Car에 대한 일시적인 배열을 만들어 printf 구문을 통해 %s로 string name을, %d로 int age를, %d로 int
	 * speed를 출력하는 방법에 대해 배운다.
	 */
	public static void main(String[] args) {
		Car car54 = new Car();

		car54.setName("Car 54");
		car54.setSpeed(20);
		car54.setGasoline(20);
		car54.setManufactured(LocalDate.of(1961, 9, 17));
		/**
		 * 25.03.05 상속학습을 위한 mach5의 SportsCar클래스로의 변경
		 * import를 통해 SportsCar 클래스를 가져와야 함에 유의
		 */
		Car mach5 = new SportsCar("Mach V", 250, 21, true);
		mach5.setManufactured(LocalDate.of(1967, 4, 2));
		/**
		 * 25.03.05 상속학습
		 * setSpeed를 자식클래스에서 재정의해 setSpeed가 currentCargoLoad에 영향을 받아 줄어드는 모습을 확인
		 */
		StationWagon wagon = new StationWagon("Wagon");
		wagon.setManufactured(LocalDate.of(1979, 7, 29));
		wagon.setCurrentCargoLoad(500);
		wagon.setSpeed(75);
		
		for (Car car : new Car[] { car54, mach5, wagon }) {
			System.out.printf("%s is %d years old and is traveling at %d mph%n", car.getName(), car.getAge(), car.getSpeed());
		}
		/**
		 * 생성자 학습 후, 새로운 인스턴스 형성 시 생성자의 형태로 만들어보는 것을 학습함
		 */
		Car boost1 = new Car("Boost 1", 500, 100, true);
		boost1.setManufactured(LocalDate.of(2025, 02, 26));
	}
}

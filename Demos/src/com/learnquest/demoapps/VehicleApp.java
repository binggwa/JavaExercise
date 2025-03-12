package com.learnquest.demoapps;

import java.time.LocalDate;

import com.learnquest.demos.transport.Car;
import com.learnquest.demos.transport.SportsCar;
import com.learnquest.demos.transport.StationWagon;
import com.learnquest.demos.transport.Vehicle;

public class VehicleApp {
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
		/**
		 * 25.03.11 추상 클래스 학습을 위한 Car 클래스의 추상 클래스로의 변경으로 인해
		 * 인스턴스화 불가능 -> Car클래스를 SportsCar로 변경
		 */
		Car car54 = new SportsCar();
		/**
		 * 25.03.11 
		 * Car와 Cargo 클래스가 추상클래스이기 때문에 new를 이용해 정의하지 못한다
		 */
		// car54 = new Car();
		// car54 = new Cargo();

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

		Train train = new Train("City of New Orleans");
		/**
		 * 25.03.06 Car 클래스에서 정의한 toString으로 println(car)로의 코드변경
		 */
		/*
		for (Vehicle vehicle : new Vehicle[] { car54, mach5, wagon, train }) {
			if (vehicle instanceof SportsCar) {
				((SportsCar) vehicle).race();
			} else {
				Vehicle.travelAtSpeedLimit(vehicle);
			}
			System.out.println(vehicle);
		}
		 */
		/**
 		 * 25.03.12 배열의 사용을 Java 리스트로 변경
		 * 유틸리티 메서드의 배열을 목록으로 요청, 목록에서 우리가 원하는 것을 가져와 반환하는 것을 만든다
 		 */
		List<Vehicle> vehicles = Arrays.asList(car54, mach5, wagon, train);
		/**
		 * 25.03.12 forEach 구문을 사용해 람다표현식으로 기존 구문을 단순화
		 */

		vehicles.forEach(vehicle -> {
			if (vehicle instanceof SportsCar) ((SportsCar) vehicle).race();
			else Vehicle.travelAtSpeedLimit(vehicle);
			System.out.println(vehicle);
		});

		// 25.03.12 차량의 종류와 관련된 문제를 없애고, 빠른 속도로 주행하도록 변경
		vehicles.forEach(vehicle -> Vehicle.travelAtSpeedLimit(vehicle));
		vehicles.forEach(vehicle -> System.out.println(vehicle));

		// 25.03.12 람다표현식 단순화, 바로 위 구문과 같은 기능 수행
		// forEach 명령에서 나오는 매개변수가 개별 Vehicle의 매개변수로 전달되어 println에서 제한 속도로 주행할 수 있다는 것을 알아냄.
		vehicles.forEach(Vehicle::travelAtSpeedLimit);
		vehicles.forEach(System.out::println);

		// 컴파일러는 여기서 stop 을 인스턴스 변수인 것으로 알아냄.
		vehicles.forEach(Vehicle::stop);	// vehicle -> vehicle.stop()
		vehicles.forEach(System.out::println);

		vehicles.forEach(vehicle -> vehicle.setSpeed(25));
		vehicles.forEach(vehicle -> System.out.printf("%s is traveling at %d mph\n", vehicle.getName(), vehicle.getSpeed()));

		/**
 		* 25.03.12 인터페이스 사양 추가로 인한 default 메서드가 잘 작동하는지 확인용으로 추가
 		*/
		/*for (Vehicle vehicle : new Vehicle[] { car54, mach5, wagon, train }) {
			vehicle.stop();
			System.out.println(vehicle);
		}*/
		/**
		 * 생성자 학습 후, 새로운 인스턴스 형성 시 생성자의 형태로 만들어보는 것을 학습함
		 */
		//Car boost1 = new Car("Boost 1", 500, 100, true);
		//boost1.setManufactured(LocalDate.of(2025, 02, 26));
		/**
		 * 25.03.11 참조유형 학습
		 * sc와 c는 정확히 같은 객체, 동일한 구현을 가리키고 있다
		 * 하지만 c의 참조유형이 Car이기 때문에, SportsCar 클래스에만 있는 race 메서드를 c로는 사용할 수 없다.
		 */
		// Type reference = new Class(...)
		/*SportsCar sc = new SportsCar();
		Car c = sc;
		sc.race();
		c.race();
		*/
	}
}

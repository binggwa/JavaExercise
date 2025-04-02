# 1. 다형성
***
- 다형성의 메커니즘과 Java에서 다형성을 사용한 설계의 모범 사례에 대해 소개
- 실제 JRE에서 다형성이 작동하는 방식을 이해하는 것은 까다로울 수 있음
***
모든 참조에는 유형이 있고, 모든 참조는 객체를 가리키며, 이 객체는 인스턴스 데이터를 가지고 있고,
인터페이스의 메서드를 구현하는 클래스와 연결되어 있다.
```java
Car myCar = new SportsCar();
```
스포츠카는 클래스이자 구현

1. Java는 참조테이블에 new 엔트리를 만든다.
2. Java가 new 엔트리에 Car로서 타입을 입력한다.
3. Java가 new 엔트리에 myCar라는 이름을 입력한다.
4. Java는 SportsCar의 속성을 저장하기 위해 메모리블럭을 설정한다, 
그리고 이 메모리의 주소를 new 엔트리의 **Attribute Block** 필드에 입력한다.
5. Java는 SportsCar의 메서드를 저장하기 위해 메모리블럭을 설정한다,
   그리고 이 메모리의 주소를 new 엔트리의 **Method Block** 필드에 입력한다.
***
메서드는 인터페이스에 있는 것이 아니라, 참조의 유형이다.

단일 객체를 다룰 때에는 다형성이 중요하지 않게 보일 수 있지만, Java에서 다루는 것들중 중요한 내용에 속한다.
***
ex)
```java
Car[] someCars = new Car[5];
someCars[0] = new SportsCar();
someCars[1] = new StationWagon();
someCars[2] = new SUV();
someCars[3] = new SportsCar();
someCars[4] = new StationWagon();

for ( int i=0; i<someCars.length; i++ ) {
    someCars[i].setSpeed(50);
    System.out.println("Speed of Car " + i + " is " + someCars[i].getSpeed());
}
```
예제에 설정했던 대로, SportsCar는 빠르고, 화물차는 화물 적재량에 따라 속도가 느려지기 때문에,

결과는 SportsCar에 70, 화물차에 45가 나오게 된다.

하지만, Car 타입에 정의된 메서드만 호출할 수 있고, Car[5] 에 있는 모든 Car들은 해당 인터페이스를 구현해야 한다.
그렇지 않으면 할당조차 되지 않았을 것.
***
### 모범사례
- Java 인터페이스를 사용하여 디자인하라. 클래스는 **요구사항을 인터페이스로부터 상속**해야한다.
- **모든 참조(멤버, 로컬 변수, 매개변수를 포함하는)는 인터페이스 측면에서 정의**해야한다.
- new와 같은 키워드를 사용할 때 같이 **필요한 때에만 클래스를 이름으로 참조**하라.

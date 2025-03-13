# **1. 생성자**
***
**Constructor, 생성자**는 Java가 클래스의 인스턴스를 초기화하는데 사용할 수 있는 특별한 메서드이다.

생성자는 **void마저도 리턴값을 갖지 않는다.**
***
새 키워드를 통해 인스턴스를 생성하겠다고 말할 때, 실제 동적 값을 제공할 수 있는 특수한 메서드.

예제의 new car 에서 봤듯이 클래스 이름과 생성자 이름은 같다.
> ex) new 생성자호출.
> new, 생성자이름(=클래스이름) 다음은 생성자의 매개변수 목록 << 오버로딩이 발생할 수 있음.
***
새 인스턴스와 생성자 호출에서 반환되는 것은 인스턴스가 초기화된 후의 해당 인스턴스에 대한 참조가 된다.

생성자를 제공하지 않아도 괜찮음. 
*생성자를 제공하지 않으면*, Java는 인수를 취하지 않는 생성자를 자동으로 생성하며, 필요에 따라 모든 항목이 0과 동일한 값으로 초기화된 상태로 유지된다.

일단 생성자를 제공한 후에도 인수를 취하지 않는 생성자를 원한다면, 명시적으로 생성자를 제공해야 한다.

일단 다른 생성자를 제공하고 나면, 더 이상 기본적으로 인수 생성자가 생성되지 않는다.

ex)
```java
public class Car {

	private int speed;
	private int gasoline;

	Car() {}
	Car(int newSpeed) {
		speed = newSpeed;
	}
	Car(int gasLevel){ //error
		gasoline = gasLevel;
```
같은 서명을 가진 두 개의 메서드( 생성자 포함 )를 사용할 수 없다.
```java
public Car(String name) {
	this(name, 0, 0, false);
}

public Car(String name, int speed, int fuel, boolean running) {
	setName(name);
	setSpeed(speed);
	setGasoline(fuel);
	setEngineState(running);
}
```
위와 같이 생성자를 사용할 수 있음.
 

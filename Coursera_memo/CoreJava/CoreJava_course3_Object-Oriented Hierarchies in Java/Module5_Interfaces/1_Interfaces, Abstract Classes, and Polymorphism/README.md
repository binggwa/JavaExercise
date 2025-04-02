# 1. 인터페이스, 추상 클래스 및 다형성
***
### *인터페이스*와 *추상 클래스*를 비교할 예정

인터페이스를 **정의하고 구현하는 법**, 인터페이스의 **디자인에 미치는 영향**
, 인터페이스와의 **상속**, **다형성에 대해 논의**할 것.
***
### _인터페이스_ 와 _추상 클래스_

유사하지만 중요한 차이점이 있다.

+ 인터페이스에는 속성 측면에서 ***final 속성***만 가질 수 있다.
+ 인스턴스가 존재할 수 없기 때문에 인터페이스에 속하는 **static 속성만 가질 수 있다.**
+ 인터페이스는 **abstract 메서드만 가질 수 있다.** (Java 8 에서는 default와 static 추가)
+ 인터페이스를 만드는 구문은 추상클래스와 조금 다르다. (class 대신 **interface로 선언**)
+ 클래스는 단 하나의 부모 클래스에서만 상속할 수 있지만, 
인터페이스는 **필요한 만큼 구현**할 수 있다.
+ 인터페이스는 **다른 인터페이스에서 상속이 가능하지만, 클래스에서는 불가능**하다.
+ 인터페이스는 **둘 이상의 인터페이스에서 상속**할 수 있다.
***
### 인터페이스를 정의
1. interface 키워드를 사용
2. 순서대로 액세스, 리턴타입, 메서드이름, 파라미터 리스트, 세미콜론을 나열하여 메서드를 선언.
세미콜론은 메서드의 코드블록을 대체
3. Java 8 이후 : default 메서드 사용 가능. 클래스가 기본 메서드로 인터페이스를 
구현하는 경우, 해당 메서드를 구현하도록 선택할 수 있음. 인터페이스이기 때문에, 
기본 메서드 구현은 인스턴스 데이터가 아닌 다른 메서드나 static 멤버로만 작성할 수 있음.
4. static 키워드를 사용해 static 메서드를 선언. static 메서드는 
다른 static 멤버와 비슷하게 제한된다.
***
# 2. 인터페이스 구현 및 사용
***
### ex) 컨버터블 인터페이스의 예
```java
public interface Convertible {
    // Methos declared in an interface are
    // implicitly public abstract
    void putTopUp();
    void putTopDown();
}
```
2개의 메서드만 있고, 속성은 없음. -> **인터페이스는 static, final, 즉 상수 이외의 속성을 허용하지 않는다.**
***
### ex) 인터페이스 구현
```java
public class SUV extends Car implements Convertible {
    private boolean topIsUp;
    
    @Override
    public void putTopUp() {
        topIsUp = true;
    }
    
    @Override
    public void putTopDown() {
        topIsUp = false;
    }
    
    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public boolean isTopUp() {
        return topIsUp;
    }
}
```
인터페이스를 사용하기 위해서는, 다른 클래스처럼 import할 필요가 있다.

import한 이후에는, **implements 키워드**를 사용해서 가져온다.
***
### 인터페이스의 구현
+ 인터페이스를 구현하기 위해서는, 클래스가 인터페이스에 있는 각 메서드의 구현을 제공해야만 한다.
+ 구현하는 클래스에서 메서드 정의를 제공하지 못하면, 컴파일러 에러가 뜬다.
+ Java 8부터 default, static 메서드는 이런 규칙의 예외이다. 
default 메서드는 구현 클래스에서 사용하도록 명시적으로 구현된 구현을 제공하기 때문이다.
***
### 인터페이스의 사용
주어진 클래스가 특정 인터페이스를 구현한다면, 해당 인터페이스 타입의 참조를 할당한다.
```java
ex) Convertible ragTopSUV = new SUV();
```
여기서, **SUV는 컨버터블**이고, 또 다른 **is-a 관계**이며, 그때마다 **업캐스팅**이 되며, **참조를 할당**할 수 있다.

우리가 **ragTopSUV에서 호출할 수 있는 메서드는 putTopUp()과 putTopDown()뿐**이다.

이외의 다른 **SUV의 메서드를 호출하는 것은 컴파일러 에러**를 일으킨다.
***
# 3. vehicle 다형성 예제
***
### 디자인 요약
다형성의 좋은 점은, 관련이 없는 클래스를 공통 인터페이스를 통해 조작할 수 있다는 점이다.
```java
public static void main(String[] args) {
    Convertible[] cars = new Convertible[3];
    cars[0] = new SUV();
    cars[1] = new SportsCar();
    cars[2] = new SUV();
    
    for ( Convertible car : cars ) {
        car.putTopUp();
    }
}
```
Convertible 배열, cars는 배열에 대한 참조, 배열의 각 요소는 Convertible에 대한 참조.

여기에 SUV, SportsCar를 할당하고 있다. 모두 컨버터블이기 때문에 가능
***
### Example
abstract 클래스 Car 가 name과 speed에 대한 bean 속성을 가지고 있다.

다형성 방식을 이용해 cars에 작용하는 방식으로 다루고 싶은 비슷한 클래스가 있지만, 
이 클래스는 자동차에서 상속되지 않을 수 있다.

여기에 새 interface, Vehicle을 정의, 우리가 원하는 공통적인 특징을 표현하기 위한 인터페이스.

Vehicle은 두 가지 bean 특성(name, speed)을 가지고 있다.
```java
package com.learnquest.demos.transport;

public interface Vehicle {
    public String getName();
    public void setName(String name);
    
    public int getSpeed();
    public void setSpeed(int newSpeed);
}
```
properties는 메서드로 정의되는 것에 주의.
***
여기에 name, RPM, wheelSize라는 3개의 속성을 가진 타사 클래스 Train 을 통합해보려 함.

Train 클래스 소스코드에 대한 수정권한도 없이, 우리만의 Train 서브클래스를 만들고 Train을 extends, Vehicle을 implements할 것.

이렇게 하면 해당 서브클래스를 Vehicle 계층 구조에 연결할 수 있게 된다.

이후, CarApp이 Trains를 사용하도록 수정
***
- Original Train Class 예제
```java
package com.devtech.training.transportation;

public class Train {
    public Train(String Name) {
        setName(name);
        setWheelSize(60);
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getRPM() { return rpms; }
    public void setRPM(int rpms) { this.rpms = rpms; }
    public int getWheelSize() { return wheel_size; }
    private void setWheelSize(int sz) { wheel_size = sz; }
}
```
- Train Subclass 예제
```java
package com.learnquest.demos.transport;

public class Train extends com.devtech.training.transportation.Train implements Vehicle {
    /**
     * 부모 생성자를 호출하는 우리 클래스의 Train 생성자
     */
    public Train(String name) { super(name); }
    // The name property can be inherited; implement speed
    /**
     * speed에 대한 세터와 게터
     */
    public int getSpeed() {
        return (int) (2 * Math.PI * (getWheelSize() / 2) / 12 * getRPM() * 60 / 5280);
    }
    public void setSpeed(int Speed) {
        setRPM((int)(mph * 5280 * 12 / (2 * Math.PI * (getWheelSize()) / 2) * 60)));
    }
}
```
우리 패키지 안에 있는 Train은 다른 패키지의 Train을 extends, Vehicle을 implements.
***
- setSpeed 메서드 호출
```java
// ... existing code omitted ...
Train train = new Train("City of New Orleans");

for (Vehicle vehicle : new Vehicle[]{ car54, mach5, wagon, suv, train }) {
    travelAtSpeedLimit(vehicle);
    System.out.println(vehicle);
}
```
***
### 예제가 포함하는 것
+ 다른 방법으로는 엮일 수 없는 계층구조를, 인터페이스(메서드에 대한 signature가 존재하는 것이 보장되는)를 사용함으로써 
성공적으로 다형성을 만들 수 있었다.
+ vehicle이 SportsCar를 참조할 때, Java는 SportsCar에 대한 setSpeed() 구현을 호출한다.
+ vehicle이 SUV일 떄, Java는 Cargo의 setSpeed() 메서드를 호출한다.
+ vehicle이 Train일 때, Java는 해당 클래스의 setSpeed() 메서드를 호출한다.
+ 참조 유형이 우리가 무엇을 말할 수 있는지 정의한다면, 클래스는 그 의미를 정의하기 때문이다.
+ 다형성을 다루고자 할 때 중요한 개념.
***
# 4. 차량 데모
***
Train 예제를 통해 학습
***
# 5. 인터페이스 확장
***
인터페이스는 다른 인터페이스를 extends 할 수 있다.

ex) 확장 인터페이스
```java
public interface SoftTopwithLight extends Convertible {
    void turnLightOn();
    void turnLightOff();
}
```
클래스가 인터페이스를 구현할 때는 implements 키워드를,

인터페이스가 인터페이스를 확장할 때는 extends 키워드를 사용한다.

ex) SoftTopWithLight를 구현하는 LuxurySportsCar 예제
```java
public class LuxurySportsCar extends SportsCar implements SoftTopWithLight {
    private boolean lightIsOn;
    
    @Override
    public void turnLightOn() {
        lightIsOn = true;
    }
    
    @Override
    public void turnLightOff() {
        lightIsOn = false;
    }
    
    public boolean isLightOn() {
        return lightIsOn;
    }
}
```
스포츠카는 이미 컨버터블이다.
***
클래스와 다르게, 인터페이스는 하나 이상의 인터페이스로부터 상속받을 수 있다.

ex)
```java
public interface RearWindowDefogger {
    void turnDefoggerOn();
    void turnDefoggerOff();
}

public interface DeluxeSoftTop extends SoftTopWithLight, RearWindowDefogger {
    String getRoofMaterial();
}
```
새로운 인터페이스인 RearWindowDefogger, DeluxeSoftTop.

여기서 DeluxeSoftTop은 Convertible을 확장하는 SoftTopWithLight를
확장하고, RearWindowDefogger를 확장하면서, getRoofMaterial 메서드가 추가되었다.
***
DeluxSoftTop을 구현하려면, 클래스는 반드시 다음 메서드를 모두 포함하는 코드 블럭들을 제공해야만 한다.
- RearWindowDefogger
- SoftTopWithLight
- Convertible
- DeluxeSoftTop 자체가 가지고 있는 모든 메서드
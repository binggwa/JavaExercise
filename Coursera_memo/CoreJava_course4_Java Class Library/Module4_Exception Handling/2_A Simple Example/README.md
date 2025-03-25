# 1. 간단한 예
***
예외 처리
```java
SportsCar myCar = new SportsCar();

try {
    myCar.setSpeed(220);
} catch (SpeedException e) {
    System.out.println("Car is going too fast!");
}
```
```java
public void setSpeed(int new_speed) throws SpeedException {
    int s = new_speed;
    if( speeder == true )
        s = s + 20;
    if( s > MAX_SPEED ) {
        throw new SpeedException();
    }
    this.speed = s;
}
```
**메서드 signature의 뒤에** *throws* 키워드가 붙는다.

speed가 MAX_SPEED보다 빠를 떄에만 **예외가 발생**한다. 이럴 경우, **메서드는 즉시 반환**하여 마지막줄이 실행되지 않는다.
***
### SpeedException 클래스는 무엇인가?
Exception 클래스를 단순히 확장하는 클래스이다.
```java
ex)
package com.lq.exceptions;

public class SpeedException extends Exception {
    
}
```
현재 Exception 클래스를 확장하는 것 외에는 어떤 것도 추가되지 않은 클래스.

**마커 클래스** 라고도 불린다.
***
### 예외 클래스
- 무엇이 잘못되었는지 로그를 볼 수 있어야 한다.
- 적절한 메시지를 제공할 생성자를 가지고 있어야 한다.
- 어디서 예외가 발생했는지 메시지를 보내거나, 클래스가 메시지를 생성하게 해야한다.
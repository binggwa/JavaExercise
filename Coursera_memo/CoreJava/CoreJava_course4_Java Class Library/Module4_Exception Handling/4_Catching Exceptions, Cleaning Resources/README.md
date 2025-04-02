# 1. Stack Trace
***
간단한 stack trace
```java
Exception in thread "main"
    com.lq.exceptions.SpeedException
at com.lq.cars.Car.setSpeed(Car.java:12)
at com.lq.cars.Car.main(Car.java:19)
```
SpeedException 은 Car.java의 12번째 라인 set speed 메서드에서 thrown되었다.

setSpeed 는 메인 메서드의 19번째 라인에서 호출되었다.
***
# 2. 예외 잡기
***
### try-catch로 작업하기
- 던져진 예외를 catch할 수 있다.
- setSpeed가 SpeedException을 throw하면, 자바는 try 블록 안의 남아있는 코드를 스킵하고 catch 블록 안의 코드를 대신 실행한다.
- 예외 객체 e 는 catch 블록 내에서 참조될 수 있다.
***
### 다중 catch 블록
- 모든 예외 클래스는 Exception 으로부터 상속받는다.
- Java는 이를 이용해 에러가 던져졌을 때, 어떤 catch 블럭을 실행할지 결정한다.
- Java는 catch블록을 순서대로 살펴보고, 타입이 일치하는 첫 번째 catch블록을 찾는다.
```java
ex)
try {
    PrintWriter pR = new PrintWriter(
            new FileWriter("myCars.txt"));
    // ...
    pR.close();
} catch (FileNotFounException e) {
    System.out.println("Could not open file");
} catch (IOException e) {
    System.out.println("Some type of I/O error");
} catch (Exception e) {
    System.out.println("Some other problem");
}
```
### *finally* Block
- 위 에제에서 만약 close()가 나오기 전 예외가 발생했다면, catch 블록으로 넘어가기 때문에 PrintWriter는 열린 상태로 남아있는다.
- 이 때문에 catch 블록 다음에, finally 블록이라는 블록을 포함할 수 있다.
  - catch 블록이 없는 try 구문 뒤에 나오거나
  - 가장 마지막 catch 블록 다음에 올 수 있다.
- finally 블록은 예외가 있던 없던 실행된다.
```java
ex)
        ...
} catch (Exception e) {
    System.out.println("Some other problem");
} finally {
    pR.close();
}
```
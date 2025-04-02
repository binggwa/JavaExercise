# 1. 향상된 타입 checking과 Try-With-Resources
***
- finally 구문은 필요하지만, 종종 실수가 나오곤 한다.
- 이에 Java 7은 **try-with-resources 구문**을 도입했다.
- try-with-resources 문은 **여는 중괄호 앞에 괄호 안에 리소스를 선언**하는 try 문이다.
- *resource*는 닫혀야 하는 모든 객체이다.
  - resource는 AutoClosable 인터페이스를 구현해야 한다.
***
이전 예제를 try-with-resources를 활용해 재작성
```java
ex)
try (PrintWriter pR = new PrintWriter(new FileWriter("myCars.txt"))) {
    ...
} catch (FileNotFoundException e) {
    // Despite its name, this is also thrown when a file exists but can't be open for write
    out.println("can't open myCars.txt for write.");
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
```
***
### Java 프로그래밍 언어 업데이트
- 예외 타입만 다른 경우, 여러 개의 catch 구문을 반복하길 강제하기보단, 파이썬의 기능을 가져와 구문을 간단화했다.
- 여러 가지 예외 타입을 catch해서 향상된 타입 Checking으로 예외를 던질 수 있다.
- catch 구문이 블록이 처리할 수 있는 예외의 타입을 구체화하고, 각 타입별로 수직 바 ( | ) 를 통해 분리된다.
```java
ex)
Catch (IOException|SQLException ex) {
    logger.log(ex);
    throw ex;
}
```
읽기 자료 : [try-with-resources](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)
***
- 여러 가지 checked 예외 객체를 던질 수 있는 메서드는, 각 타입의 예외를 명시해야 한다.
***
# 2. 모범 사례
***
### 하지 말아야 할 예시
```java
try {
    myCar.setSpeed(1000);
} catch (exception e) {
    /* notice that there's no code here */
}
```
예외가 발생했을 때, 아무것도 하지 않는 빈 중괄호는 좋지 않다.
***
### 커스텀 예외 작성
- 사용자 지정 예외를 직접 작성할 수 있다.
- 예외가 아닌 이상 메시지를 제공할 수 있는 생성자를 제공해야 한다.
***
```java
try
{
    // do something here
} catch (OutOfMemoryError oe) {
    System.gc(); // flag the garbage collector to run
    System.out.println("wow! I didn't think of that!!!");
}
```
메모리 부족 오류는 가비지 컬렉터가 메모리 부족 오류를 발생시켰기 때문인데, 시스템에 가비지 수거를 하라고 지시한다?
***
- 예외는 던져질 수 있는 메서드로 처리되어야 한다.
- 예외는 문제가 있다는 뜻이기에, 문제가 발생한 이유와 문제가 무엇인지, 소스 코드에 액세스할 수 없는 사람도 문제를 해결하기 위해 취해야 할 조치를 이해할 수 있을 만큼 충분한 정보를 제공해야 한다.
- 예외는 비용이 많이 들기 때문에, 발생할 때만 사용한다.
- 적절한 메시지 형식을 지정하여, 운영 담당자가 무슨일이 발생했고 어떻게 해야하는지 알 수 있도록 해야한다.
***
### 무엇이 예외인가?
- 존재하지 않는 파일을 열러고 할 때, 올바른 형식이 아닌 파일을 열면 파싱할 수 없다
- 네트워크 연결이 설정되지 않거나 연결이 끊길 때
- 배열의 범위 밖의 요소에 접근할 때
- 0으로 나누기와 같은 하드웨어 기능을 포함한 여러가지
***
### 예외와 함께 디자인하기
- 앞서 배울 때에는, 예외 처리에 관한 내용은 배제하고 학습했으나,
- Java 시스템을 디자인할 때, 시스템이 마주할 다양한 에러 상황을 처리하기 위해 예외 클래스를 설정하는 것이 보통이다.

읽기 자료 : [예외 처리](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)

# 1. 예외 및 에러 : Checked, Unchecked
***
### 다른 종류의 예외
- 앞서 학습한 내용이 Checked 예외
- 일반적으로 코드에서 처리할 수 있는 것으로 간주되는 Checked 예외에 더해서, **실제 해결책이 없는 다른 오류** 조건도 있다.
  - ex) 하드웨어 오류
  - 이런 경우 Java는 **Error 클래스**를 제공한다.
***
### 런타임 문제
- 코드, 데이터 오류
- 표준 메서드 예외
- Throwing 커스텀 예외
- Java 에러

자바는 이런 예외를 객체로 취급해서, 모든 것은 **java.lang.Throwable** 클래스나 그 서브클래스에 속해있다.
***
Throwable 계층구조

![Alt text](주소 추가)

***
### Checked, Unchecked 예외
- checked 예외를 throw할 수 있는 메서드를 호출할 때마다, 컴파일러는 예외를 처리하도록 요구한다.
- checked 예외는 처리하도록 강제된다. throws 구문으로 명시되어야 한다.
- 런타임예외를 제외한 예외의 서브클래스들은 모두 checked 예외이다.
- unchecked 예외는 컴파일러에 의해 강제로 처리요구받지 않는다. (null, 0으로 나누기 문제 등 런타임예외)
***
# 2. 예외 및 main()
***
- 메인 메서드는 자바 프로그램의 시작점이다.
- 만약 메인 메서드에 예외를 throw한다면,
```java
ex) 
public static void main (String[] args) 
    throws FileNotFoundException {}
```
- JRE는 **Stack Trace**를 출력하고 프로세스를 중단한다.
***
읽기 자료
- [Throwable](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html)
- [Exception](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html)
- [Error](https://docs.oracle.com/javase/8/docs/api/java/lang/Error.html)
- [RuntimeException](https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html)
# 1. 람다 및 함수형 인터페이스
***
### 함수형 인터페이스란?
오로지 하나의 추상 메서드만 가지고 있는 인터페이스

>ex) java.lang.Runnable 은 run() 이라는 단 하나의 메서드만 가지고 있다.

>ex) java.lang.Autocloseable 은 close() 만 가지고 있다.
***
@FunctionalInterface 가 java8부터 추가

인터페이스가 functional이 아닐 경우(메서드가 2개 있다던가), 컴파일 에러가 발생함
***
### 람다 표현식
+ 람다 표현식은 익명 함수로서 사용된다.
+ 사용할 메서드를 작성하고, 해당 코드를 매개변수로 전달할 수 있게 해주는 표기법적인 속기
+ 코드블럭을 매개변수로서 함수형 인터페이스의 구현을 기다리는 코드에 전달하기 쉽게 해준다
***
### 람다 표현식은 언제 사용하는가?
+ 구문에 익숙해진다면, 함수형 인터페이스를 구현하고 사용하는 쉬운 방법이다.
+ 메서드가 로컬에서 단 한번만 사용될 때 람다로 한줄만 표현하면 돼서 유용하다.
***
### 람다 표현식의 구문
쉼표로 구분된 매개변수 목록, 화살표, 본문(중괄호로 구분되어 있음)

```java
ex)
button.addActionListener( (e) -> {
        System.out.println("람다 표현식의 예");
})

ex)
        (type1 arg1, type2 arg2...) -> { body }
```
읽기자료 link : [Java 8 Lambda](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
***
# 2. VehicleApp에서 람다 표현식 사용
***
VehicleApp을 통한 학습
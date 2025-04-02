# 1. 제네릭 스택 선언하기
***
제네릭은 꺽쇠괄호를 이용한 타입 파라미터의 선언으로 사용된다.
```java
ex)
public interface List<E> {
    void add(E x);
    Iterator<E> interator();
}
```
예제의 E와 같은 것이 제네릭

맵을 정의할 때 키, 값 유형에 따라 K, V를 사용할 수 있음
***
제네릭이 사용되면, 꺽쇠괄호 안에 있는 파라미터화된 타입이 타입을 구체화한다.
```java
ex)
public class ListTest {
    List<String> ls;
}
```
예제에서 List는 String 타입으로 구체화되었다.

이 List는 오로지 String만 포함할 수 있으며, Car, Vehicle, int 등은 포함할 수 없다.
***
- 제네릭은 런타임에는 없고, 컴파일러에만 관련되어있다.
  - 제네릭의 선언은 딱 한번만 컴파일된다.
  - 제네릭이 invoke되면, 실제 타입은 해당 invocation에 쓰인 arguments로 대체된다.
- 제네릭은 메서드와 비슷하게 동작한다.
  - invoke됬을 때, method 값 파라미터들은 실제값으로 대체된다.

읽기 자료 : [중첩 및 내부 클래스](https://docs.oracle.com/javase/tutorial/java/generics/why.html)
***
읽기 자료 : [Deque](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)

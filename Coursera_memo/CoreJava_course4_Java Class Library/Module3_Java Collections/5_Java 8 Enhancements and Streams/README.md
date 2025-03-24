# 1. Java 8 개선 사항 및 Java 스트림
***
Java 8은 인터페이스와 관련된 많은 새로운 기능들을 도입했다.
- 함수형 인터페이스
- 람다
- Default 및 Static 메서드
- 및 이런 새 기능을 활용하는 많은 새로운 인터페이스와 메서드들
***
### Java 8 개선사항
ex)

- Iterable 인터페이스는 new default 메서드, forEach를 Consumer라는 파라미터와 함께 받았다.
  - Consumer는 함수형 인터페이스이다.
- 컬렉션 인터페이스는 Iterable을 확장하므로, 모든 컬렉션 클래스는 forEach를 지원한다.
- Map 인터페이스는 Iterable이 아니지만, 자체적으로 forEach 메서드를 포함한다.
***
- forEach 메서드는 Consumer를 호출한다.
- Consumer의 필수 메서드는 void accept(T t) 이다.
- 다른 default 메서드인, andThen은 일련의 Consumer를 구성하여 단일 forEach라는 처리 파이프라인을 생성할 수 있다.
```java 
ex) 
Consumer<Vehicle> go25 = vehicle -> vehicle.setSpeed(25);
vehicles.forEach(go25.andThen(System.out::println));
```
여기서, 참조에 명시적으로 할당하고 있는데, go25 참조가 주어지면, . 을 호출한 다음 해제할 수 있다.
***
읽기 자료
- [Java 8 스트림](https://docs.oracle.com/javase/tutorial/collections/streams/index.html)
- [병렬 처리 파이프라인](https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html)
- [Java SE 8 스트림으로 데이터 처리하기 1부](https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html)
- [Java SE 8 스트림으로 데이터 처리하기 2부](https://www.oracle.com/technical-resources/articles/java/architect-streams-pt2.html)
- [Java 8의 Java 스트림 가이드: 예제가 포함된 심층 튜토리얼](https://stackify.com/streams-guide-java-8/)
- [Java 8 병렬 스트림 예제](https://examples.javacodegeeks.com/java-development/core-java/java-8-parallel-streams-example/)
# 1. 제네릭이란?
***
- 제네릭이 무엇인지, 왜 필요한지
- 어떻게 제네릭을 선언하는지
- 여러종류의 제네릭을 살펴볼 것 - wildcards, sub-typing, super-types
- 타입 선언뿐 아니라, 메서드 선언에서 제네릭이 어떻게 쓰이는지
- 제네릭 erase와 transition
***
### 제네릭이란 무엇인가?
- 제네릭은 타입에 대한 추상화를 가능하게 한다.
  - type safety를 잃지 않으면서 제네릭 코드를 작성할 수 있다.
  - 컨테이너 안에서 객체의 타입을 선언하는 방법을 제공한다.
  - compile-time type checking을 허용하고, 런타임 typecasting exceptions를 피하는데 도움을 준다.
  - 다운캐스트를 할 필요성을 줄인다.
  - Collection Framework에 널리 사용된다.
***
제네릭은 컬렉션 프레임워크의 필요에 의해 나왔다.

예전에는 객체 컬렉션밖에 없었고, 객체를 내보낼 때 예상한 것과 같은지 확인하기 위해 캐스팅이 필요했다.

그렇지 않으면 클래스 캐스트 예외가 발생했다.
***
```java
List<String> cs = new ArrayList<String>();
cs.add(0, "this is a string");
cs.add(new Object()); // error... not a String
String s = cs.get(0); // no downcast needed!
```
Link : [제네릭 튜토리얼](https://docs.oracle.com/javase/tutorial/java/generics/why.html)
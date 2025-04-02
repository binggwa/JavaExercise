# 1. 제네릭 메서드
***
- _개별 메서드_ 는 타입 파라미터를 선언할 수 있다.
- 구문은 인터페이스와 클래스에서 사용한 것과 비슷하다.
  - Access-modifiers generics-declaration return-type name(args)

```java
ex) 
public static <T> Collection<T> unmodifiable(Collection<T> c);
public <T> T getBean(class<T> requiredType);
```
- unmodifiable이라는 메서드 : typed Collection을 받아들이고 typed Collection을 반환하는 메서드


- 리턴타입 또한 제네릭선언에 영향을 받을 수 있다.
- 어떤 타입에 대한 클래스를 전달하고, 해당 타입의 인스턴스를 다시 가져와서 반환된 형식이라도 타입 파라미터의 영향을 받을 수 있다.
- 두번째 예는 Spring에서 온 것. 예를 들면 employeeService.class 와 같은 클래스를 전달할 때, 타입 안전성이 보장되고 캐스팅할 필요 없이 인스턴스를 가져올 수 있다는 점이 유용하다.
***
객체 배열을 가져와서 Collection 안으로 넣는 메서드를 작성하고 싶을 때,
```java
void fromArrayToCollection (Object[] a, Collection<?> c) {
    for (Object o : a) {
        c.add(o); // error
    }
}
```
위 예제에서는 타입이 어떤 것인지 알 수 없다.
```java
<T> void fromArrayToCollection(T[] a, Collection<T> c) {
    for (T o : a) {
        c.add(o); // correct
    }
}
```
제네릭 메서드를 사용, T 타입으로 입력, T가 자리 표시자이다.

T 타입 배열과 T 타입 컬렉션이 있으며, 타입 T로 루프를 돌려 반복해서 add한다.
***
### 제네릭 메서드 인수 Type
- 제네릭 메서드로 전달되는 인수 타입은 실제 인수의 타입에 기반하여 컴파일러가 유추한다.
  - employeeService.class를 전달하면, employeeService 타입으로 유추한다.
  - 다른 타입을 가지는 경우, 가장 구체적인 타입을 유추하여 메서드 호출 타입을 올바르게 만든다.
- 메서드로 전달되는 인수와 리턴타입간에 종속성이 있을 경우, 제네릭 메서드를 사용하라.
- 인수와 메서드 바디간의 다형성 관계를 표현하기 위해 와일드카드를 사용하라.
  - 와일드카드는 유연한 서브타이핑을 지원하는 데 사용된다.
***
### 바운드 와일드카드의 final word
- Car 클래스이면서 Convertible 인터페이스인 타입만을 받아들이는 메서드를 표현하려면 어떻게 해야하는가?
```java
public static <T extends Car & Convertible> park(T car) {
    car.setSpeed(0);
    car.putTopUp();
}
```
- 예제의 T는 Car와 Convertible을 extends한다.
- 인터페이스를 원하는대로 추가할 수 있지만, extends 키워드 바로 뒤에는 **반드시 슈퍼클래스가 먼저 와야 한다.**
***
읽기 자료 : [제네릭 메서드](https://docs.oracle.com/javase/tutorial/java/generics/methods.html)
***
# 2. 타입 Erasure
***
- Collection과 같은 제네릭 타입이 타입 파라미터 없이 사용될 때, 이것을 _**raw**_ 타입이라 부른다.
- raw 타입의 사용은 컴파일러에 의해 unchecked warnings을 만들어낸다. 
  - 타입 safety를 보장하지 않기 때문.
  - 컴파일 타임 체킹을 못하고, 캐스팅을 해야 하는데, 잘못되면 클래스 캐스트 예외가 발생할 수 있다.
  - 이 때문에 제네릭이 도입된 것
- 대부분의 IDE는 raw 타입에 대한 quick fix를 제공한다.
  - 올바른 파라미터화된 타입을 입력하는 데 도움이 될 수 있다.
- 코드가 작동하도록 보장하는 것은 프로그래머의 책임이다.
***
### 타입 Erasure
- 제네릭은 타입 erasure라는 변환 프로세스를 사용해 컴파일러에 의해 구현된다.
  - 컴파일러는 모든 제네릭 코드를 non-제네릭으로 변환한다.
  - 꺽쇠괄호 안의 모든 타입정보는 지워진다.
  - 모든 타입변수는 보통 Object와 같은 상위 계층의 타입변수로 대체된다.
  - 객체를 re-type하기 위해 캐스팅이 필요한만큼 추가된다.
  - 런타임에는 타입 파라미터가 없고, 런타임에 타이핑할 필요도 없게 사라졌다.
***
### 제네릭 클래스 Sharing
런타임에는 파라미터화된 클래스가 없고, raw 타입만 있다.

- 런타임에는 raw 클래스만 있기 때문에, 런타임에는 모두 같은 클래스를 사용한다.
```java
ex)
List<String> 11 = new ArrayList<String>();
List<Integer> 12 = new ArrayList<Integer>();
System.out.println(11.getClass() == 12.getClass()); // true
```
- 모든 제네릭 클래스는 타입 파라미터와 관계없이 런타임에서 같은 클래스를 가지고 있다.
  - 그런 클래스들의 모든 static 변수와 메서드는 공유된다.
  - 제네릭의 타입 파라미터를 참조하는 것이 illegal인 이유
```java
ex)
Collection cs = new ArrayList<String>();
if (cs instanceof Collection<String>){} // no can do
```
여기서, Collection은 문자열로 구성된 ArrayList이다. 문자열 collection의 인스턴스인 경우, 타입 파라미터 정보가 손실되었으므로 불가능하다.
***
### 배열과 제네릭
- 배열의 타입은 와일드카드 타입을 제외하고는 제네릭 타입이 될 수 없다.
```java
ex)
List<String>[] lsa = new List<String>[5];   // won't work
```
- 제네릭 타입인 오브젝트를 포함하는 배열을 만들 수는 있다.
***
읽기 자료 :

[제네릭 튜토리얼](https://docs.oracle.com/javase/tutorial/java/generics/index.html)

[제네릭, 상속, 서브타입](https://docs.oracle.com/javase/tutorial/java/generics/inheritance.html)

[와일드카드 캡쳐 및 헬퍼 메서드](https://docs.oracle.com/javase/tutorial/java/generics/capture.html)

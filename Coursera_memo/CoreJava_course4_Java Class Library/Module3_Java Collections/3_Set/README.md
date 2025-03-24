# 1. Set (집합)
***
- Set은 중복 element를 허용하지 않는 컬렉션이다.
- Set에 Add 할 떄, 중복을 없애기 위해 해싱하거나, 정렬된 트리로 구성하는 기법을 사용한다. 
따라서, 추가한 순서대로 가져올 수 있다는 보장은 없다.
- Sorting에 관해서도, 값을 기준으로 정렬하지 추가된 순서대로 하지는 않는다.
- Set를 구현하는 concrete 클래스는 HashSet, LinkedHashSet, TreeSet이다. 
- SortedSet은 TreeSet의 서브 인터페이스다.
***
### Set을 언제 사용하는가?
- elements를 꺼내는 순서가 중요하지 않은 경우에만.
- 값을 기준으로 무언가를 검색하는 측면에서, 순서대로 정렬하는 컬렉션보다 **Set가 더 빠르기 때문에 선호**된다.
***
### ex) HastSet
HashSet은 객체를 저장하는걸 허용하지만, 순서대로 정렬하는 어떤 메서드도 제공하지 않는다.
```java
HashSet<Car> h = new HashSet<Car>();

h.add(new SUV());
h.add(new SportsCar());

System.out.println(h.size());
```
HastSet은 **Iterator 인터페이스**를 구현하는 객체를 제공한다.
***
# 2. Iterator (반복자)
***
- Iterator 인터페이스는 컨테이너의 element를 처음부터 끝까지 access하기 위한 간단한 메서드를 제공한다.
- 주요 메서드는 두 가지가 있다.
  - **next()** : 컨테이너의 다음 값을 얻을 수 있다.
  - **hasNext()** : 컨테이너에 또 다른 다음 값이 있는지 true, false로 반환한다.
- Java 8의 Iterator에는 remove 메서드와 forEachRemaining 메서드가 있다.
***
### ex) Iterator와 HashSet
- **iterator()**는 element의 iterator를 얻는데 사용하는 메서드다.
- iterable 인터페이스에 선언되어있는 메서드이다.
```java
HashSet<Car> h = new HashSet<Car>();
h.add(new SUV());
h.add(new SportsCar());
// ... add more elements

Iterator<Car> iter = h.iterator();
while (iter.hasNext()) {
    Car car = iter.next();
    System.out.println(car.getSpeed());
}
```
- 이 예제가 iterator를 명시적으로 사용한 예이다.
***
### Iterator를 사용할 때의 문제점
- 만약, Iterator를 가져온 후에, **컬렉션의 내용이 변경되면** 어떻게 되는가?
  - Iterator가 더 이상 컬렉션의 내용을 반영하지 못한다는 문제점이 존재
  - 이런 경우, Java에서 **Exception(예외)** 이라는 런타임에러를 만든다.
- 만약, Iterator에 있는 **remove를 이용해 제거**한다면, 이러한 문제는 **발생하지 않는다**.
***
읽기 자료
- [Iterator](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html)
- [Iterable](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)
- [Spliterator](https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html)
***
# 3. Sorted Sets (정렬)
***
- 표준 라이브러리에는 SortedSet에 대한 하나의 구현인 **TreeSet**이 포함되어 있다.
- 정렬은 Comparator 클래스의 인스턴스를 사용하여 수행된다.
- Comparator는 TreeSet이나 Java의 다른 정렬부분에서 **비교를 목적으로 사용**된다.
- Comparator는 두 객체를 가져와서 비교보다 작거나 큰 값에 따라 -1, 0, 1 을 반환하는 비교 메서드를 정의한다.
***
### ex) TreeSet
```java
TreeSet<String> tS = new TreeSet<String>()
tS.add("Zebra");
tS.add("Elephant");
tS.add("Aardvark");
tS.add("Bear");
Iterator<String> i = tS.iterator();
while (i.hasNext()) {
    System.out.println(i.next());
}
```
위 예제의 경우, TreeSet의 내부 Comparator에 의해 알파벳으로 정렬된 String들이 출력될 것이다.
```java
Aardvark
Bear
Elephant
Zebra
```
***
읽기 자료
- [Comparator](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)
- [SortedMap](https://docs.oracle.com/javase/8/docs/api/java/util/SortedMap.html)
- [SortedSet](https://docs.oracle.com/javase/8/docs/api/java/util/SortedSet.html)
- [Comparable](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)
- [Comparable과 Comparator 예제](https://www.digitalocean.com/community/tutorials/comparable-and-comparator-in-java-example)
# 1. List
***
### List 컬렉션
- List는 element가 특정한 순서로 위치할 수 있는 컬렉션이다.
- 대괄호 대신 **메서드를 사용**한다.
- 배열과 마찬가지로 특정 위치에 element를 할당하고 해당 위치에서 검색할 수 있다.
- 구현하는 클래스는 다음과 같다.
  - LinkedList
  - ArrayList
  - Vector
  - Stack
***
### Linked List
- ArrayList가 있는데 왜 LinkedList가 있는가?
  - 특정 위치에 할당하는 게 아니라, 이미 추가한 **데이터의 중간의 특정 위치에 insert**하고 싶다면?
  - ArrayList나 다른 배열의 경우, 공간을 만들고 새 element가 들어갈 수 있게 **모든 것을 바꿔야 한다**.
  - **delete** 또한 삭제 이후 다른 모든 데이터를 옮겨 격차를 메워야 한다.
  - ArrayList는 스토리지 관점에서 compact하고, **끝에서** 추가하거나 제거하는 작업에 효율적이다.
  - LinkedList는 중간에 삽입하거나 제거하는 등의 작은 변화에 더 효율적이다.
- Vector와 Stack 은?
  - Java 1에서 사용했던, 원래의 List와 유사한 구조
  - Vector는 일종의 리스트
  - Stack은 Vector의 서브클래스로, push, pop 타입 메서드를 추가한다.
***
### List 인터페이스의 중요한 메서드
```java
public interface Lilst<E> extends Collection {
    
    E get(int index);
    E set(int index, E element);
    void add(int index, E element);
    boolean remove(Object o);
    boolean addAll(int index, Collection<? extends E> c);
    
    // indexes specific elements
  int indexOf(Object o);
  int lastIndexOf(Object o);
  
  // provides listiterator references
  ListIterator<E> listIterator();
  ListIterator<E> listIterator(int index);
  
  // gets a sublist from the current list
  List subList(int fromIndex, int toIndex);
}
```
***
# 2. Map
***
### Map 컬렉션
- Map은 key value pairs(키 값 쌍)을 저장한다.
- 키 값 쌍은 둘 모두 객체이다.
- 키 자체는 고유해야 하며, Map의 키는 키 세트이며 중복이 없다.
- Value 는 복제에 대한 제한은 없다.
- 다양한 구현이 있다.
  - HashMap : 대부분의 경우 사용
  - LinkedHashMap
  - PrinterStateReasons
  - IdentityHashMap
  - TreeMap : 정렬이 중요할 때 사용
  - WeakHashMap : 캐싱 동작을 구현하는 데 사용
***
### Map 인터페이스의 중요한 메서드
```java
public interface Map {
    Object put(Object key, Object value);
    Object get(Boject key);
    Object remove(Object key);
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    int size();
    boolean isEmpty();
    
    // Bulk Operations
    void putAll(Map t);
    void clear();
    
    public Set keySet();
        public Collection values();
        public Set entrySet();
}
```
***
### ex) HashMap
- key/value 쌍을 가지므로, Map에 새 element를 넣기 위해선 **add 대신 put을 사용**한다.
```java
HashMap h = new HashMap();

h.put("MySUV", new SUV());
h.put("MySportsCar", new SportsCar());

System.out.println(h.size());
```
위 예제같은 경우, get 메서드를 통해 각 항목을 불러올 때,
```java
Car aCar = (Car) h.get("MySUV");
```
와 같이 불러와야 하는데, 선언할 때
```java
Map<String, Car> = new HashMap<>()
```
을 대신 사용했다면 더 좋았을 것이다.
***
### Map을 Iterating하는 방법
1. keySet() 메서드를 호출하고, 키 세트를 iterate한다.
2. values() 메서드를 호출하고, 컬렉션을 iterate한다.
3. 키와 값을 원하는경우, entrySet() 메서드를 호출하고, 엔트리들의 세트에 대해 iterate한다.
   - Map.Entry 는 getKey()와 getValue() 메서드와 함께 [키, 값] 쌍을 포함한다.
4. Java 8 : Map.forEach() 메서드를 사용해 엔트리들에 대해 iterate한다.
   - Iterable은 단일 매개변수를 취하는 forEach로 간주한다.
   - 그래서 Map은 자체 forEach 메서드를 선언했다.
```java
ex) m.forEach((k,v)->System.out.printf("%s -> %s", k, v));
```
***
# 3. Linked 컬렉션
***
- LinkedList, LinkedHashSet에 이어, LinkedHashMap도 있다.
- 콘텐츠를 정의된 순서대로 반복할 수 있게 하려는 경우 사용
***
- 빠른 액세스를 위한 hash element뿐 아니라, 내부적으로 linked list를 유지하여 정의된 순서대로 iterate할 수 있다.
- LinkedHashMap은 access-order를 지원한다.

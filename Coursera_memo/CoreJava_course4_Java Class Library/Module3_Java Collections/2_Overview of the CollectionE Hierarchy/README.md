# 1. 컬렉션<E> 계층 구조 개요
***
### 컬렉션 프레임워크
- 컬렉션 인터페이스는 모두 java.util 패키지에 저장되어있다.

![Alt text](https://github.com/binggwa/JavaExercise/blob/develop/Coursera_memo/CoreJava_course4_Java%20Class%20Library/Module3_Java%20Collections/2_Overview%20of%20the%20CollectionE%20Hierarchy/The_Collection_Framework.png)

- Collection의 서브타입 Set, Set의 서브타입 SortedSet
- List : 한 쌍의 Set를 컬렉션으로 백업하는 것을 List라 함 
- Map은 엄밀히 Collection이 아니다. : Collection은 elemente를 add하는 것을 포함하고 있지만, Map은 키 값 쌍이 전부이다. 
- 일반적으로 Map을 Collection의 일부라 생각하지만, 실제로 Map이 Collection을 확장하지는 않는다.
***
### 컬렉션 인터페이스
- Collection을 구현하는 클래스 목록
  - 추상 클래스
    - AbstractCollection : 모든 컬렉션이 공유할 수 있는 구현이 있어서 추상 컬렉션까지 확장된다.
    - AbstractList
    - AbstractSet
  - 실제 구현
    - ArrayList : List의 구현
    - HashSet : Set의 구현
    - LinkedHashSet : Set의 구현
    - LinkedList : List의 구현
    - TreeSet : Set의 구현
    - Vector : Java 5에서 AbstractList의 서브클래스로 재작업됨
  - 서브 인터페이스
    - BeanContext
    - BeanContextServices
    - List
    - Set
    - SortedSet
***
```java
ex)
public interface Collection<E> {
    
    // Basic Operations
    int size();
    boolean isEmpty();
    boolean contatins(Object o);
    boolean add(E e);
    boolean remove(Object o);
    Iterator<E> iterator();
    
    // Bulk Operations
    boolean containsAll(Collection<?> c);
    boolean addAll(Collection<? Extends E> c);
    boolean removeAll(Collection<?> c);
    boolean retainAll(Collection<?> c);
    void clear();
    
    // Array Operations
    Object[] toArray();
    Object[] toArray(T[] a);    
}
```
Collection<E>를 구현하는 모든 클래스는 해당 메서드들을 모두 구현해야 한다.

참고 링크 :

[컬렉션 프레임워크](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/)

[java.util](https://docs.oracle.com/javase/8/docs/api/index.html?java/util/package-summary.html)

[Collections](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html)

[Iterable](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)

[Collection_E](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)


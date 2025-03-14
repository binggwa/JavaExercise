# 1. 컬렉션 소개
***
### 컬렉션 프레임워크를 살펴보고 Java 8 스트림에 대해서 알아보는 단원
***
- 컬렉션은 배열의 대안을 제공하며, 더 유연하고 더 강력하다. 
  - 배열의 주요 한계점은 만들어질 때 길이가 고정된다는 점과 선형적으로 쌓인다는 점이다.
  - 컬렉션은 자동으로 더 많은 elements를 담을 수 있게 늘어날 수 있다.
- 컬렉션은 인터페이스에 매우 강하게 의존한다.
- 컬렉션에는 3가지 주요 타입들이 있다.
  - Sets - exclude duplicates
  - Lists - allow duplicates
  - Maps - key value pair access
***
- 컬렉션은 모든 java 객체를 포함할 수 있다.
  - 컬렉션은 프리미티브나 배열을 포함할 수 없다.
  - 하지만 프리미티브는 래퍼 클래스의 컬렉션에 전달될 수 있다.
  - 컬렉션에 배열을 포함하는 대신, ArrayList 클래스와 같은 것을 사용할 수 있다.
- 제네릭을 사용함으로써, 컬렉션에 들어갈 객체의 타입이 무엇인지 구체화할 수 있다.
  - 객체가 컬렉션에서 찾아질 때, 컴파일러에 의해 타입 safety가 보장된다.
  - 제네릭이 없다면, 자바는 모든것을 object까지 업캐스팅하고, 컬렉션에서 항목을 꺼낼 때 타입을 확인하길 강제하며, 안전한 코드를 입력하기 위해 어쩔 수 없이 다운캐스팅했을 것이다.
***
```java
public class MyCars {
    
    public static void main(String[] args) {
        
        // create the ArrayList to hold types of Cars
        ArrayList<Car> a =new ArrayList<Car>();
        
        // each car will go into consecutive positions of the ArrayList
        a.add(new SUV());
        a.add(new SportsCar());
        a.add(new StationWagon());
    }
}
```

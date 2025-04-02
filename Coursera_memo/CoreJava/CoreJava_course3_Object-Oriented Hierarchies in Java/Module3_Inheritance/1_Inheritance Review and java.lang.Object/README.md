# **1. 상속 검토**
***
상속에 관해 더 자세히 알아보는 모듈
- 상속에 대한 개요
- is-a 관계에 관한 재설명
- 상속 모델
- 확장, 슈퍼 키워드 사용
- 확장, 상속, 재정의, 오버로딩
***
_상속 관계_는 _is-a관계_이며, 객체 지향 프로그래밍에서 **코드를 재사용**하기 위한 기본 메커니즘 중 하나이다.

ex) employee 클래스가 person을 extends하면 모든 직원이 사람이 된다. 즉, **슈퍼클래스의 모든 특성을 물려받는다.**

서브클래스는 슈퍼클래스를 따라 루트까지, 즉, **java lang object까지 상속**된다. 오버라이드 하지 않는 한 해당 코드를 모두 재사용하게 된다.

클래스의 **상속은 주로 재사용을 위한 것**임. 

인터페이스를 사용할 때는 클래스 계층 구조의 서로 다른 부분에서 다형성을 찾아야 한다.
***
# **2. java.lang.Object**
***
Java에서 서브클래스를 정의하는 방법은 다음과 같다.

ex)
```java
public class subclassname extends superclassname {
	attribute declarations;
	method declarations;
}
```
액세스 한정자(public), class, 서브클래스의 이름, extends, 슈퍼클래스, 이후 데이터와 메서드 선언의 혼합.

자바에서 정의되는 클래스는 사실 모두 서브클래스이다.

extends가 생략되었을 때에는, 최소한 object의 속성과 메서드는 얻을 수 있다. (java.lang.Object)

즉, 모든 클래스는 Object로 정의된 내용을 공유한다.
***
###### **Object clone()**
###### **boolean equals(Object obj)** 
이중 등호 연산자 == 는 프리미티브에서만 사용할 수 있다. 두 객체 참조의 값이 정확히 같은지 여부를 확인하는 방법. 
###### **void finalize()**
파이널라이즈를 **절대로 구현해서는 안된다.** (가비지컬렉션 및 성능에 영향을 미침)
###### **getClass()**
getClass를 호출하면, 해당 클래스를 나타내는 런타임 객체를 얻게 된다.
###### **int hashCode()**
Java 맵이나 해싱을 사용하는 세트의 키로 사용되는 경우 사용해야할 의무가 있다.
###### **String toString()**
System.out.println을 사용해 객체를 제공할 때, toString 메서드가 호출되고 toString이 반환하는 모든 것이 출력된다.

> 멀티스레딩과 동기화에 관여하는 내용, Java EE 런타임이나 다른 프레임워크의 멀티스레드 관리형 런타임에서 실행하는 경우 프레임워크에서 자동으로 관리되는 것들을 멀리해야 한다. 고급 수준의 마스터리에 도달하여 수동으로 멀티스레딩을 수행해야 하는 경우가 아니라면 notify나 wait는 사용하지 않아도 된다.
> void notify()    
> void notifiyAll()    
> void wait()   
> void wait(long ms)    
> void wait(long ms int ns)    
***
# **3. 자바독 살펴보기**
***
+ 자바독의 equals에 관한 규칙 : 재귀적, 대칭적, 전이적, 일관성

equals와 hashCode 메서드 사이에 관계가 있다.

hashCode 메서드는 Java 맵, 즉 집합을 넣을 때마다 사용된다. 해싱 성능을 위해 사용된다. Signature를 계산하는 것.

두 객체가 equals 메서드에 따라 같다면, 각 두 객체에 대한 hashCode 메소드 호출시에 같은 integer 결과를 도출해야 한다.
***
# **4. equals 및 해시코드 메서드 구현하기
# **5. toString 메서드 구현하기
***
### com.learnquest.demos.transport.Car 클래스에서 예제를 통해 학습
***

# **1. 추상 클래스 - 왜, 언제?**
***
### 구체적인 클래스와 추상 클래스의 차이와 어떻게 사용되는지 알아볼 것
***
_**추상 클래스**_란?
+ 인스턴스화 할 수 없는 클래스. new를 사용할 수 없지만, 참조는 만들 수 있다.
+ _추상 클래스_는 클래스이므로 속성, 메서드, 추상 메서드를 포함할 수 있다.
+ 추상 메서드는 코드가 없으며 Signature가 있는 자리의 표시자이다.
***
_**추상 클래스**_는 언제 쓰는지?
+ 다양한 서브클래스와 공유하길 원하는 속성과 메서드의 구현이 있을 경우.
+ 추상 클래스의 인스턴스를 만드는 것은 불가능하다.
+ 구현을 설명할 수 없는 메서드(_추상메서드_)가 있을 수 있으므로, 해당 메서드는 서브클래스에서 정의해야 한다.
***
_추상 클래스_는 대체적으로 누락된 부분에 대한 자리 표시자로 사용하는 부분적인 클래스로, 프레임워크를 구축하는데 주로 쓰인다. 

추상인 부모 클래스는 일반적인 동작을 할 수 있지만, 정의해야 하는 특정 세부 정보를 자식 클래스로 **강제로 위임**할 수 있다. 

자식 클래스가 추상 클래스가 아니거나, 추상 메서드의 부족한 부분을 구현하지 않으면 구문 오류가 난다.
***
ex)
```java
public abstract class DBTransaction {
	protected abstract Statement getStatement();
	// ... other stuff ...
	public void perform() {
		// prepare transaction
		do(getStatement());
		// commit or rollback
	}

}
```
상위 클래스인 DBTransaction이 전반적인 관리를 제공하는 DBTransaction 클래스의 경우.

이를 확장하는 개별 자식 클래스는 명령문 구성을 제공하므로 DBTransaction은 추상적으로 표시됨.

DBTransaction 참조가 이루어지면, perform 메서드를 호출할 수 있다. 이를 통해 트랜잭션을 수행할 수 있도록 설정하는 등 일반적인 작업을 모두 수행할 수 있다.
***
ex)
```java
public abstract class Car {
	protected int speed;
	private boolean engineState;
	/* Other attributes omitted to save space */

	// Each subclass must provide an implementation
	// of setSpeed()
	public abstract void setSpeed( int speed );

	public boolean getEngineState() {
		return engineState;
	}
	/* Other methods omitted to save space */
}
```
추상 클래스 Car 설정. 

speed는 protected, setSpeed는 abstract로 설정.

속성을 protected로 하는 것은, 모든 서브클래스에서 직접 볼 수 있다는 것으로, 일반적으로 권장되지는 않는다.

*추상 메서드 setSpeed는 중괄호 대신 바로 세미콜론이 붙는 것에 주의
***
# **2. 추상 클래스 데모**
***
- Demos의 Car, Cargo, CarApp 클래스를 통해 추상클래스와 추상메서드에 대해 학습함.
***
# **3. 구문 검토**
***
_추상 클래스_의 구문을 검토하는 것은 다른 클래스 구문검토와 똑같다.

클래스 정의에 abstract가 들어가는 순간, **new 키워드로는 인스턴스화가 불가능**하다.

_추상 메서드_의 구문은 단순히 abstract를 메서드 앞에 추가하고, **중괄호 대신 세미콜론으로 마무리**하는 것.

추상 클래스로부터 상속되는 클래스는 클래스 자체가 추상 클래스이거나 **상속된 모든 추상 메서드를 구현해야 한다.**
***
# **4. 디자인 결정**
***
_추상으로 표현되지 않은 것_들은 이미 모두 구현되어있고,

_추상으로 표현된 것_들은 추상이 아닌 모든 서브클래스에서 추후 구현해야만 한다.

따라서 추상 클래스는 필수 메서드 목록을 지정한다는 점에서 **인터페이스와 약간 비슷한 역할**을 한다.

인터페이스와 달리 추상 클래스는 사실 클래스이므로 단일 상속의 제한이 있지만, 데이터 지원, 메서드 구현을 제공할 수 있다.
***
# **5. 추상 클래스 및 참조 유형**
***
ex)
```java
Car mySportsCar = new SportsCar();
```
위 예제에서 **Car**는 **Type**, **mySportsCar**는 객체가 아닌, **프리미티브, 참조** 이다. 이 참조의 유형은 Car이다.

**new**는 실행되어 힙에 새 객체를 만들고 생성자를 호출한 다음, 해당 객체의 참조를 반환한다. 이것이 mySportsCar에 저장되는 것

위 예제에서 mySportsCar가 참조하는 것은 Car 타입이기 때문에, 실제로 접근할 수 있는 것은 Car에서 가능한 것 뿐이다.

ex)
```java
	SportsCar sc = new SportsCar();
	Car c = sc;
	sc.race();
	c.race();
```
sc와 c는 정확히 같은 객체, 동일한 구현을 가리키고 있다.

하지만 **c의 참조유형이 Car이기 때문에**, SportsCar 클래스에만 있는 **race 메서드를 c로는 사용할 수 없다.**
***

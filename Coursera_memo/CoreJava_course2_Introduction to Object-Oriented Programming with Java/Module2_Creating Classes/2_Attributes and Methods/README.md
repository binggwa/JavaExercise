# **1. 클래스 해부학**
***
## 클래스에 속성, 데이타, 메서드를 추가하는 방법에 대해 알아봄.
***
일반적인 형식은
```java
public class classname {
	type attribute1;

	type methodname1(parameter-list) {
		// body of method
	}
}
```
와 같이 구성됨.
***
**게터와 세터가 attribute보다 먼저 선언되는 것도 가능함.**

생성자를 먼저 두는 것이 권장됨.

클래스 구성의 형태는 **고정된 것이 아님.**
***
중괄호의 사용에 유의할 것. 

**클래스와 메서드의 내용을 나타낼 때** *중괄호*를 사용하며, 해당 부분을 클래스 블럭, 메소드 **블럭**이라 칭함.
**attribute는 클래스 블럭 내부, 메서드 블럭 외부에서 정의**된다.

들여쓰기는 보기 편하게 하는 것일 뿐, python처럼 실제로 들여쓰기가 구문의 일부로 인식되지 않음.
***
# **2. 속성 및 메서드 추가**
***
## 클래스에 데이터, 속성을 추가하는 방법에 대해 학습.
***
속성이나 메서드를 **멤버**라고 칭하기로 함.
멤버들은 항상 접근성(accessibility)을 가지고 있다. 누가 메서드를 호출한다거나 속성에 접근하는 데 제한을 두는 것을 의미한다.
접근성에서 가장 유명한 것은 **public과 private** 두가지이다.
> **public** : 시스템의 다른 모든 객체에 접근을 허가함
> **private** : 같은 클래스 정의 내부에서만 접근을 허가함

Java에선 **클래스 내부의 속성을 private**로 선언하고 **세터와 게터를 private**으로 설정해 세터와 게터로만 데이터에 접근해도 퍼포먼스 코스트가 들어가지 않는다.
JVM과 JIT을 통해 최적화가 이루어지는 것의 장점.
***
# **3. 메서드 매개변수**
***
메서드 파라미터는 데이터가 메서드 안으로 들어올 수 있게 허락해줌.

동시에 여러가지 메서드 파라미터를 넣을 때는 콤마를 사용함. : **오버로딩**이라고 부름.

메서드를 **오버로딩한다**는 것은 이름은 같지만 **서명은 다르다**는 뜻.
서명에는 메서드 이름뿐만 아니라 *매개변수의 유형과 갯수도 포함*되기 때문.
ex) 
```java
public void setTirePressures( int tire1, int tire2 )
public void setTirePressures( int tires )
```
Java는 **메서드가 다른 서명을 가지고 있는 한, 같은 이름의 메서드를 허용**한다. 

하지만 리턴값은 메서드 서명의 유일함을 결정짓는 요소가 아니다.
ex) 
```java
public void setSpeed(int newspeed)
public int setSpeed(int newspeed)
```
의 2개는 공존불가. 같은 서명을 가지고 있으며 **리턴값인 void나 int는 관계없기 때문**. 
***
가변 길이 인수 variable length arguments
* **arguments (인수)** : 같은 타입이어야 함. 여러 개의 arguments를 메서드 매개변수에 사용할 수 있는 유연함이 있음.
ex)
```java
public void myExample( int ... v ) {}
```
__*주의__ 
```java
public void setTirePressures( int[] pressures )
```
의 경우 
```java
setTirePressures(new int[] {10,20,30,40} )
```
와 같은 식으로 정의해야 하므로 varargs 구문이 java에 허용된 이유.
```java
public void setTirePressures( int ... pressures )
```
의 경우 
```java
setTirePressures(10, 20, 30, 40)
```
처럼 사용가능

하지만, 둘다 int 배열로 수행될 것이므로 같은 서명을 지녀 공존할 수 없음에 주의.

앞서 배운 printf 또한 printf(String format, Object ... args) 와 같은 형태의 varargs였음. 서식을 위한 문자열로 정의되고, 그 뒤 객체에 ... 으로 인수가 문자열에 채워지도록 하는 것.
***
# **4. 메서드 변수**
***
메서드 내에서 변수를 가지고 싶음.

파라미터는 메서드 변수의 한 형태임.

if, else if, else 를 **삼항 연산자**를 사용해 효율적으로 나타낼 수 있음.
> ex) speed = newSpeed <= maxSpeed ? newSpeed : maxSpeed;
***
# **5. Java 액세스 수정자**
***
접근성, 가시성에 대한 전체 목록은 다음과 같다.
* **private** : 이것이 정의된 클래스 내부에서만 접근가능함.
* **default** : 같은 패키지 안에서의 클래스로의 접근은 허가, 하지만 같은 패키지 안에 있지 않으면 서브클래스로의 접근도 불허.
* **protected** : 같은 패키지 안에 있는 모든 클래스, 서브클래스에서 접근가능
* **public** : 어떤 클래스, 어떤 패키지에서도 접근가능
액세스 수정자가 없을 경우 default로 설정됨. 다른 이유가 없으면 **private으로 하는것이 기본**.

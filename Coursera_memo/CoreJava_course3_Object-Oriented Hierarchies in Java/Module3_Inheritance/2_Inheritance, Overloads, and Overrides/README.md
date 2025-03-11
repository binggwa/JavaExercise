# **1. 오버로딩 및 오버라이딩**
***
오버로딩의 예

```java
package com.lq;

public class SportsCar extends Car {

	double preciseSpeed;

	//overloading setSpeed(int) from Car
	public void setSpeed(double s) {
		preciseSpeed = s;
	}
}
```

**Car의 setSpeed는 int**를 사용하기 때문에, **스포츠카의 속도는 double**을 사용하기로 변경하고자 할 때,

setSpeed(double) 부분이 오버로드인가? **매우 잘못된 예시**

스포츠카는 세터말고도 getSpeed 또한 오버라이드할 수 있지만 getSpeed는 int를 반환하므로 잘못되었다.

또한 만약 getSpeed가 double을 반환하게 바뀌었다고 해도, **메서드는 리턴타입에 기반해 오버로드 될 수 없으므로** 컴파일러 에러가 뜨게 된다.

이에 전형적으로, **오버로딩은 클래스계층에서 같은 레벨에서 수행**된다.

오버라이딩 했을 경우, 부모클래스와 자식클래스간의 메서드는 같은 signature를 지녀야하며, 잘못하여 오버로드 될경우 @Overrides 가 컴파일러에게 경고해주도록 만들 수 있음.
***
# **2. 오버라이딩 예**
***
```java
public class StationWagon extends Car {

	private int cargo_weight;

	//overriding setSpeed(int) from Car
	public void setSpeed(int s) {
		if(s > 50)
			s = 50;
		// speed = s;   <- speed에 직접 접근할 수 없음
		super.setSpeed(s);  // 상속받은 setSpeed를 통해 speed를 변경할 수 있음
	}
}
```
speed는 **private이기 때문에 직접 할당할 수 없다.**

protected의 경우 가능하겠지만, 일반적으로 좋지 않음.

```java super.setSpeed```를 통해 speed를 변경할 수 있다.
***
# **3. 생성자**
***
생성자를 설정하지 않으면, java는 다음과 같은 기본 인수 없는 생성자를 제공한다.

> public MyClass() { super(); }

java.lang.Object까지 이어지는 체인이 작동하려면 생성자가 있어야 하기 때문.

생성자를 만들 때, 인수가 있던 없던 super에 대한 호출을 명시적으로 제공하지 않으면, **java는 생성자의 첫 번재 항목으로 인수가 없는 super에 대한 호출을 삽입한다.**

만약 생성자를 만들면, java는 default 생성자를 제공하지 않으므로, 인수가 없는 생성자를 정의하지 않는다면, 이것이 존재하지 않는다.

이 경우, **모든 서브클래스 생성자**는 부모 생성자에 있는 생성자 중 하나에 대한 적절한 인수를 사용하여 **명시적으로 super를 호출해야 한다.** 그렇지 않으면 구문 오류가 발생한다.
***
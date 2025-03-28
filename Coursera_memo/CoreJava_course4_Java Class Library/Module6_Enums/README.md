# 1. Enums (열거형)
***
- Enum 이 무엇인가?
- Enum 을 어떻게 선언하는가?
- Enum 을 어떻게 확장하는가?
- Enum 을 사용하는 제네릭
- Enum 을 코드에 사용해보기
***
### Enum 이란?
```java
enum Cardsuit { CLUBS, DIAMONDS, SPADES, HEARTS };
```
- 다른 것을 더 추가하는 것은 **불가능**하다.
- *enum* 타입이란, **고정된 상수 값의 세트를 가지고 있는 타입**이다.
- java.lang.Enum 클래스를 확장한다.
- *enum*은 서브클래스이므로, **생성자를 넣을 수 있다.**
- **새 인스턴스는 만들 수 없다.**
- *enum*은 가능한 모든 값을 선언한다.
***
### 언제 사용하는가?
- 고정된 상수 값의 세트를 표현하고 싶은 곳
- 자연적인 enum 타입을 포함한다 (태양계 행성, 행성 연도, 공전 주기, 1일의 시간 등 고정된 것)
- 컴파일 타임에 모든 데이터 세트를 알고있을 때, 사용한다.
***
- 본래 열거는 int 상수 값의 세트로 표현되었었다.
```java
ex)
// int Enum Pattern - has severe problems!
public static final int SEASON_WINTER = 0
public static final int SEASON_SPRING = 1
public static final int SEASON_SUMMER = 2
public static final int SEASON_FALL =  3
```
- int 값으로 계절을 정의했기 때문에, 계절에 맞는 달은 무엇인지와 같이 데이터를 추가할 수 없었다.
- enum은 타입에 안전하며, 클래스의 concrete 인스턴스이다.

읽기 자료 : [Enum](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
***
# 2. Enums 구현
***
- enum 타입은 가능한 값의 세트가 한정적인, 고정된, 그런 값들을 묘사해둔 인스턴스이다.
```java
ex) enum Directions{NORTH, SOUTH, EAST, WEST}; 
```
- 가장 중요한 정보가 값의 존재 자체일 때, 사용한다.
***
### Enum 확장
- Enum에 상속은 없다.
  - 고정된 유한한 요소의 집합이다.
  - 서브클래스는 규칙을 위반하는, 부모 요소의 수를 증가시킬 수 있기 때문이다.
  - enum은 더이상 확장될 수 없다.
```java
public enum TirePressures {
    LF(30), RF(30), LR(32), RR(32);
    int pressure;
    private TirePressures(int pressure) {
        this.pressure = pressure;
    }
    public int getPressure() {
        return pressure;
    }
    public void overridePressure(int newPressure) {
        this.pressure = newPressure;
    }
}
```
- enum은 여러 개의 메서드를 가질 수 있다.
***
### Switch/Case
- enum은 switch 문의 상수 값으로 사용될 수 있다.
```java
ex)
for (tirePressures tp : TirePressures.values()) {
    switch (tp) {
    case LF: tp.overridePressure(28);
        break;
    case RF: tp.overridePressure(28);
        break;
    case LR: tp.overridePressure(30);
        break;
    case RR: tp.overridePressure(30);
        break;
    default:
        break;
    }
    System.out,println(tp + "  " + tp.getPressure());
}
```
읽기 자료 : [EnumMap](https://docs.oracle.com/javase/8/docs/api/java/util/EnumMap.html)
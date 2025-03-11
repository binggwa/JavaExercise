# **1. String 클래스**
***
문자열 : 순서가 지정된 문자 시퀀스

문자는 ASCII가 아니라 유니코드임.

큰 따옴표로 묶은 문자열 리터럴을 사용할 수 있음.

문자열 연결과 같은 작업을 수행할 수 있음.

substring을 얻을 수 있음. 문자열 리터럴을 메서드의 객체로 사용할 수 있음. 매우매우 중요할 수 있음. <- 문자열 리터럴에는 아주 특별한 속성이 하나 있기 때문에 _**절대 null이 될 수 없음**_. <- 메서드를 호출하는 객체가 null 일 가능성을 피할 수 있음.

ex)
```java
	String cde = "cde";
	System.out.println("abc" + cde);
	String c = "abc".substring(2,3);
	String d = cde.substring(1,2);
```
***
# **2. 문자열 객체 만들기**
***
문자열을 부트스트랩하려면 어떻게 하나? 바이트 배열을 만들고 개별 바이트를 입력해서 유니코드로 작업한 다음 이를 문자열에 전달하여 내부 구조를 만들고 문자열 객체가 되도록 했었지만, Java는 문자열 객체를 이용해 큰 따옴표로 처리했다.

문자열은 불변의 특징이 있다. 

문자열은 맵이나 해시 테이블 등에서 사용하기 위해 필요한데, 문자열을 변경하려 할때마다 변경해야하므로 많은 복사가 필요하고, 많은 객체가 생성되고 결국 더이상 사용하지 않는 객체는 가비지 수거를 해야하기때문에 성능에 영향을 미치게 된다. 

이런 성능 문제를 줄이기 위해 Java는 StringBuffer 클래스가 있다. 

Java5부터는 StringBuilder라는 동일한 문자열 버퍼 복사본을 도입했다.

StringBuilder는 문자열 데이터를 훨씬 더 효율적으로 조작하는데 사용될 것이다.
***
toUpperCase() 는 모든 문자를 대문자로 바꿔주는 메서드이다.
```java
	int anotherSize = "BryanTheHappyMinnow".length();
```
위와 같이 직접적으로 String을 치고 뒤에 .length() 를 통해 길이를 구할 수 있음.
***
# **3. 문자열 버퍼 및 문자열 빌더**
***
오버헤드를 피하고 문자열 조작에 더 많은 성능을 제공하기 위해 StringBuffer와 StringBuilder가 도입되었다.

둘 중 하나를 사용하면 조작, 편집과 관련된 String 클래스의 성능 문제를 피할 수 있으며 자체적으로 버퍼를 관리한다.

String은 데이터 조작측면에서는 상당한 오버헤드를 발생한다. 따라서 문자열 내용 조작으로 인한 오버헤드를 제거하거나 줄일 수 있는 문자열 빌더가 있다.

ex)
```java
StringBuilder nameBuffer = new StringBuilder("John");

nameBuffer.append(" ");
nameBuffer.append("Richard");
nameBuffer.append(" ");

nameBuffer.append(" ");
nameBuffer.append("Cornwell");

System.out.println(nameBuffer.toString());
```
StringBuilder는 프린트 되기 전, toString()을 통해 반드시 Strings으로 변환되어야 한다.

John으로 버퍼를 미리 로드하고 버퍼에 공백을 추가한 다음, Richard를 추가하면 이 버퍼가 내부적으로 관리된다.

이 버퍼는 초기 크기로 시작했을 것이고, 점점 커질 것이다. toString()을 통해 최적의 크기의 버퍼를 만드려고 할 것이다.
***
# **4. Math 클래스**
***
메서드가 모두 static 메서드이므로 인스턴스는 없다. 

객체는 속성과 메서드의 모음이다. 

메서드는 클래스의 모든 인스턴스와 공유되고, 인스턴스를 통해 액세스할 수 있다.

실제로 어떻게 배열되었는지 기억하기 위해 new 연산자를 사용하여 새 인스턴스를 만든다.
***
*번외*
CLASSPATH는 컴파일러에 패키지 검색 위치를 알려주는 환경 변수이다.
***

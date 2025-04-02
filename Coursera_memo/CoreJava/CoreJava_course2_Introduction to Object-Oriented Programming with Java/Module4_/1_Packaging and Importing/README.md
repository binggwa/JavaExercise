# **1. JAR 파일 및 네임스페이스(패키지)**
***
>배포를 위해 클래스 파일을 패키징 하는 방법에 대해 살펴보는 모듈
>패키지를 더 자세하게 알아봄.
>널리 사용되는 Java 클래스인 String, StringBuilder, StringBuffer, Math에 대해 살펴봄.
***
자바는 브라우저에서 주로 사용되었다. - 클래스인 애플릿을 요청하곤 했다. 애플릿을 브라우저에 로드하면 필요한 다른 모든 클래스에 대해 알아낼 수 있었다.
즉 필요한 클래스를 모두 다운로드할 떄까지 백엔드를 더 많이 호출해야 했다. 그래서 많은 오버헤드가 발생했던 이 프로세스를 최적화하기 위해 sun이 이런 모든 클래스를 zip 파일로 패키징하는 기능을 도입함. 이제 zip 파일을 브라우저에 한번에 다운로드할 수 있어 오버헤드가 크게 줄었다.
zip 파일에서 클래스를 로드하는 기술을 개발한 후에는 로컬에서도 실행하는 것이 나을 것이므로 런타임은 zip 파일로 패키징되었다. 그러다 zip 파일의 이름이 JAR로 바뀌었다. 자바빈즈라는 개념이 있었기 때문. 콩을 jar에 넣기 때문에 jar라 이름붙이고, 이들은 zip파일이다.

우리가 보게 될 다양한 종류의 Java 아카이브는 어디에 저장해야 하는지에 대한 확장자와 규칙이 모두 다른 zip이다. 
JAR 파일에 있는 zip 파일의 코드는 추출할 필요가 없다. 클래스 로더 기술이 단순히 파일을 열고 zip 내에서 런타임 메모리로 직접 로드하는 클래스 로더 기술이 개발되었기 때문이다. 파일을 파일 시스템을 수동으로 추출할 필요 없이 JAR에서 RAM으로 직접 로드된다. 

이제 JAR파일을 사용하여 라이브러리 및 기타 여러 항목을 배포할 수 있다. 

Spring Boot를 보면, 런타임, 다른 모든 JAR, 모든 것을 하나의 JAR 파일 안에 패키징 한다. like 러시아인형
모든 것이 하나의 JAR 파일 안에 들어있다. 크기가 50메가이상일수도 있음. 
스프링 부트 애플리케이션을 실행하는 데 필요한 JRE 자체 외에 필요한 모든 것이 하나의 큰 JAR 파일 안에 들어있다.
***
서로 다른 패키지에 같은 이름을 가진 클래스가 있을 수 있음.
JAR 파일은 디렉토리 트리의 패키징에 불과하기 때문에 이러한 문제를 해결하지 못한다.

네임스페이스 충돌 문제를 해결하는 것은 디렉터리 트리 자체와 이를 패키지에 매핑하는 것이다.

앞서 자동차 시스템과 관련된 드라이버 클래스와 데이터베이스 연결과 관련된 드라이버 클래스의 예를 통해 얘기해봄.
com.learnquest.cardemo.driver.와 com.MySQL.Driver 와 같이 클래스의 완전한 이름에 대해 이야기할 필요가 있음.
예제를 통해 만든 클래스는 항상 com.learnquest.demo.car 와 같이 저장되고, 참조된다.
***
패키지는 플랫폼 중립적인 디렉토리 시스템이다.
패키지는 JAR 파일 안에 들어가고, 이는 플랫폼 중립적이다. 파일 시스템이 JAR 파일 안에 있으므로, 시스템의 본질이 무엇인지에 대해 얘기하지 않음.
이제 패키지가 있으면 동일한 단순 이름을 가진 여러 클래스를 만들 수 있다. 정규화된 이름이 항상 다를 것이기 때문.
즉 실제 이름은 항상 packages.class와 같이 사용됨. 이 이름이 런타임에서 검색되는 이름이며, 이름 충돌을 쉽게 피할 수 있다.
***
# **2. 패키징 클래스**
***
패키지의 구성원 자격은 package 문에 의해 결정된다. 이는 Java 파일에 있는 첫번째 비주석 명령문이어야 한다.
ex)
```java
package com.mybookstore.items;

public class Book {
	//code here
}
```
도메인인 mybookstore.com의 소유자인 경우에만 사용해야 함.
누구나 이 코드를 사용하여 mybookstore.com 패키지를 가져올 수 있음.
***
패키지는 파일 시스템에 매핑되어야 하므로 JVM에 대한 클래스 경로를 제공함.
클래스 경로에는 패키지를 찾기 위한 상대 경로가 되는 디렉토리가 나열되어 있음. 클래스 경로를 따라 나열된 디렉토리에서 com, org, edu, net과 같은 경로를 찾아보거나, 해당 디렉토리에서 JAR 파일을 찾아 그 안을 살펴볼 수도 있음. 이런 JAR 파일도 상대 경로가 될 수 있음.
JVM은 패키지 명령문을 변환하여 파일 시스템의 적절한 부분을 안내해 줌. 그런 다음 JAR로 패키징하면, JVM은 import 문에 있는 패키지를 활용하여 찾고 있는 클래스를 찾는다.
***
**패키지를 만드는데 필요한 step**
1. 패키지를 만드려면, 이름이 같은 디렉토리를 만들어야 함. 
2. 패키지에 넣어야 하는 모든 것을 해당 디렉토리에 JAVA 파일로 정의하고
3. 각 파일 상단에 package 문을 지정해야 함.
***
# **3. 패키지 가져오기**
***
우리가 속한 패키지가 아닌 패키지의 멤버를 사용하려면, 어떤 식으로든 구성원을 import해야 한다. 공개(public) 멤버만 가져올 수 있음.
외부 패키지 멤버를 가져오려면 import 없이 가져올 수는 없다. 이름으로 간단히 참조할 수 있음. 
해당 패키지멤버만 가져올 수도 있고, java.text.Asterisk를 가져와서 해당 패키지의 모든 항목을 가져올 수도 있음. << 별로 좋지 않음. 필요없는 모든 클래스를 가져아 이름 충돌의 문제를 일으킬 수도 있음.
구문은 다음과 같다.
```java
import package1[.package2][.package3].className;
```
디렉토리 트리와 같이 패키지 공간을 통과하는 경로이다. 
***
import 문의 사용을 통해 자바 패키지의 내용에 접근할 수 있음.
ex)
```java
import java.io.*; // all classes are available
import java.sql.Connection; // only Connection

public class DatabaseReader {
	Connection conn = new Connection();
}
```
***
# **4. 임포트된 클래스 사용**
***
java.util.Date;를 import함으로써 날짜 클래스를 간단히 참조할 수 있음.
>** 컴파일러가 기본적으로 네임 테이블을 유지하고 있음**
>Car 클래스는 LocalDate를 유지하고 있고, java.time.LocalDate에 매핑되어있음.
>Period 는 java.time.Period에 매핑되어있음.
>java.lang.* 에 있는 모든 것은 implicit(암시적)임.
***
*이름 충돌의 예
```java
import java.util.Date;
import java.sql.Date;

public class DatePrinter {
	public void printDate(Date aDate) {
		System.out.println(aDate.toString());
	}
	public void printSQLDate(Date aDate) {
		System.out.println(aDate.toString());
	}
}
```
만약 와일드카드 * 를 이용해 불러왔을 때에, 이름 충돌이 발생했을 것.
컴파일러가 어떤 Date가 어떤 Date일지 모르기 때문.
해결을 위해 코드를 다음과 같이 완전히 검증하는 식으로 변경 가능.
```java
import java.util.Date;

public class DatePrinter {
	public void printDate(Date aDate) {
		System.out.println(aDate.toString());
	}
	public void printSQLDate(java.sql.Date aDate) {
		System.out.println(aDate.toString());
	}
}
```
***
Java lang에 있는 모든것은 암시적으로 가져왔으므로 사용할 수 있음.
	ex) 
	1. String : immutable character string을 조작하는 클래스
	2. StringBuilder : dynamically building mutable character string에 대한 클래스
	3. System : operating system(운영체제)와 정보나 신호를 주고받기(인터페이스)를 위한 클래스
***
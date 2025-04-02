# 1. Why Annotations? (주석)
***
- 주석이 무엇인지
- 주석이 왜 필요한지
- 주석을 어떻게 선언하는지
- 다양한 타입의 주석
- 코드에서 어디에, 어떻게 사용되는지
***
- 객제 지향 API는 지속성을 위한 설정, 유지를 위한 엔드포인트 설정과 같은 boilerplate 코드를 필요로 한다.
- 주석은 java 코드 자체에 클래스나 그 멤버에 관한 메타정보를 제공할 수 있다.
- 클래스가 메모리에 있는 런타임 중에도 보존할 수 있다.
***
# 2. 예제
***
### Common Annotation 
- Annotation 환경 지원, 패키징
jcp.org에서 나온 자바 사양은 JSR로 알려져 있으며, JSR은 java SE와 EE를 모두 살펴보았다.
- annotation은 javax.annotation이나, javax.annotation.security과 같은 하위 패키지에 있다.
***
- Annotation은 메타데이터일 뿐, 자체로 코드가 아니다.
- 코드나 동작에 직접적인 영향을 끼치지 않는다.
- 컴파일러에 정보를 제공한다. ex) suppress warnings, detect errors 등
***
### @Generated
- Java 코드를 생성하는 도구에서 삽입할 수 있으며, 이를 통해 **어떤 도구가 언제 생성했는지 알 수 있다.**
- JavaServer 페이지 파일로 작업할 때마다 해당 페이지에서 서블릿이 생성된다.

```java
ex)
public class MyClass {
    @Generated(
            value = "ClassNameThatGeneratedThisCode",
            comments = "This is Tool Generated Code",
            date = "28 March 2025"
    )
}
```
***
### @Resource
- 일반적으로 Java EE의 다양한 프레임워크에서 사용할 수 있는 범용 주석
- Spring이 지원한다.
- xml 파일과 같은 별도의 파일 없이 주석을 통해 리소스가 무엇인지 정의할 수 있다.

```java
ex)
@Resource(name = "MyQueue", type = javax.jms.Queue,
        shareable = false, 
        authenticationType = Resource.AuthenticationType.CONTAINER,
        descrption = "A Test Queue"
)
private javax.jms.Queue myQueue;
```
***
### Role 기반
- @DeclareRoles
- @RolesAllowed
- @PermitAll
- @DenyAll
- @RunAs
```java
@DeclareRoles(value = {"A", "B", "C"})
class MyClass {
    @PermitAll()
    public void commonService(){}
    
    @DenyAll
    public void confidentialService(){}
}
```
- common 서비스는 누구나 이용할 수 있어야 하고, 기밀서비스는 아무나 이용할 수 없어야 한다.
- 주석은 수동적인 메타데이터를 코드에 집어넣는 것뿐이기 때문에, 모든 것이 제대로 작동하려면 런타임 환경이 필요하다.
***
읽기 자료
- [JPA Annotations](https://www.objectdb.com/api/java/jpa/annotations)
- [Spring Annotations](https://groupe-sii.github.io/cheat-sheets/spring/spring-core/index.html)
- [Javadocs Annotations](https://jakarta.ee/specifications/annotations/1.3/apidocs/)
- [JakartaEE Annotations](https://jakarta.ee/about/faq/)
- [JAX-RS Annotations](https://www.techferry.com/articles/RESTful-web-services-JAX-RS-annotations.html)
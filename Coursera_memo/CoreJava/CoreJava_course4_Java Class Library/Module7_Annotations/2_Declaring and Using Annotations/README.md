# 1. Annotation 선언
***
### Annotation 타입
- Marker 주석 - 요소 없이, 이름만 있는 것
  - @Deprecated
- Single element 주석
  - @Target(ElementType.Method)
- Full-value 주석 - 여러가지 요소 포함, 요소들의 완전한 naming이 필요
  - @MyClassAnnotation(name="myClass", type="view")
***
### @Deprecated
- Common Annotation
- 사용하기 위한 것이 아니라는 뜻
***
### @Override
- 컴파일러에 계층 구조에서 해당 메서드 시그니처를 찾을 수 없다면, 보호하는 목적
- Java의 변경점으로 인해 오버라이드라고 생각할 수 있는 오버로드가 발생한 경우가 있었다.
***
### @SuppressWarnings
- 더 이상 사용되지 않는 것을 사용하고 싶다면?
- 컴파일러에 경고를 표시하지 말라고 표시하는 용도
- ex) @SuppressWarnings("unused")
***
# 2. 메타 Annotations
***
- 메타 주석은 다른 주석에 주석을 달 때 사용한다.
- 다른 주석을 정의할 때 사용
- Standard List
  - @Target
  - @Retention
  - @Inherited
  - @Documented
  - @Repeatable
***
### Retention 메타 주석
- 다른 주석 타입은 다른 목적으로 가지고 있다.
  - RetentionPolicy.SOURCE
  - RetentionPolicy.CLASS
  - RetentionPolicy.RUNTIME
***
읽기 자료
- [Predefined Annotation](https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html)
- [Meta Annotation](https://dzone.com/articles/what-are-meta-annotations-in-java)
- [Annotation 만들기](https://dzone.com/articles/creating-custom-annotations-in-java)
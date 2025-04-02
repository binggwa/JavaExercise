# 1. Introduction and File I/O Example
***
### *java.io*의 기초
### 입력, 출력 스트림
### 파일 처리
***
### Java의 Input, Output
- *input*과 *output*이란 파일, 네트워크 소켓, 다른 장치에 읽고 쓰는 것을 포함
- Java는 플랫폼 중립적이므로 파일로 작업하는 것이 약간 번거로울 수 있다. 특정 플랫폼에 너무 얽매이지 않도록 코드를 짠다.
***
### java.io.* : input and Output
- Java는 입력, 출력의 *스트림*이라는 개념을 사용. (유닉스의 구조를 기반으로 하며, C에서도 사용되는 **바이트 스트림**
- *스트림*이란 input,output를 목적으로 하는 외부 소스와의 논리적인 연결을 의미한다.
***
### ex) 텍스트 라인 읽기
- 텍스트 한 줄을 적고, 라인넘버와 함께 출력해보기.
- 코드의 각 비트에 대한 설명

```java
public static void main(String[] args) {
    /**
     * 현재 디렉터리가 무엇인지 출력해서 가져온다.
     * user.dir라는 시스템 property
     */
    System.out.println("Current dir: " + System.getProperty("user.dir"));
    /**
     * try-with-resource를 사용한 문장
     * src/com/learnquest/demos/HelloWorld.java 파일을 찾기 위해 새 FileInputStream을 만든다.
     * FileInputStream은 바이트 지향이므로, 스트림에서 만든 reader인 InputStreamReader에 래핑
     * InputStreamReader는 문자 지향이므로, BufferedReader의 서브클래스인 LineNumberReader로 래핑
     * LineNumberReader로 래핑함으로써, 라인별로 처리할 수 있게 된다.
     */
    try (FileInputStream inFile = new FileInputStream("src/com/learnquest/demos/HelloWorld.java");
        InputStreamReader inStreamReader = new InputStreamReader(inFile);
        LineNumberReader lineReader = new LinewNumberReader(inStreamReader))
    {
        // Pre-Java 8:
        // String outputLine = null;
        // while ((outputLine = lineReader.readLine()) != null) {
        //     System.out.printf("%d: %s%n", lineReader.getLineNumber(), outputLine);
        // }
        /**
         * lineReader의 새로운 메서드 lines()는 문자열 스트림을 반환하는 Java 8 스트림
         * forEach를 포함하는 람다를 가져온다.
         */
        lineReader.lines().forEach(line -> out.printf("%d: %s%n", 
                lineReader.getLineNumber(), line));
    } catch (IOException e) {
        e.printstackTrace();
    }
}
```

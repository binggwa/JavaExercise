# 1. Property 파일
***
### Property (프로퍼티) 파일
- Java에는 *프로퍼티 파일*이라고 하는 특별한 타입의 텍스트 파일에 대한 지원을 제공한다.
- 프로퍼티 파일은 **키 = 값의 쌍**이다.
```java
ex)
user.name = John Doe
user.dob = January 15th, 1955
user.os = linux
```
- 키는 변경되지 않는다.
- 기본 이름이 같은 파일을 여러 개 만들 수 있도록 mymessages.properties 가 기본값이다.
- myMessages_FR.propterties나 myMessages_ES.properties는 같은 키이다.
***
```java
ex)
import java.io.*;
import java.util.*;

public class MyCars {
    
    public static void main(String[] args) throws Exception {
        /**
         * MyFile.properties를 사용하여 프로퍼티를 생성
         */
        FileInputStream fIS = new FileInputStream("MyFile.properties.txt");
        /**
         * 프로퍼티 객체에 파일 input 스트림을 로드하도록 지시
         */
        Properties p = new Properties();
        p.load(fIS);
        /**
         * user.name, user.favorite.car 키를 요청
         */
        String userName = (String) p.get("user.name");
        String carType = (String) p.get("user.favorite.car");
        
        System.out.println("User name is " + userName);
        System.out.println("Favorite car is " + carType);
    }
}
```
읽기 자료 : [properties files](https://docs.oracle.com/javase/tutorial/i18n/resbundle/propfile.html),
[locale-specific data tutorial](https://docs.oracle.com/javase/tutorial/i18n/resbundle/index.html)
***
# 2. java.io.InputStream, java.io.OutputStream
***
- java.io 패키지는 모든 io 스트림이 파생되는 **2개의 기본 추상 클래스**를 제공
- *InputStream* : 바이트 지향 입력을 위한 입력스트림의 기본 추상 클래스
- *OutputStream* : 위와 같은 출력을 위한 추상 클래스
***
### IO 계층구조
- 파일을 읽고 쓰는 용도로만 사용되는 것이 아니다.
- buffered, unbuffered 읽고 쓰기 지원 - ActualOutputStream
- binary 바이트 배열, 어떠한 non-text 데이터 지원
***
### InputStream 클래스
```java
public abstract class InputStream
{
    public atstract int read() throws IOException;
    public int read(byte b[]) throws IOException;
    public int read(byte b[], int off, int len) throws IOException;
    public long skip(long n) throws IOException;
    public int available() throws IOException;
    public void close() throws IOException;
    public synchronized void mark(int readlimit);
    public synchronized void reset() throws IOException;
    public boolean markSupported();
}
```
***
### OutputStream 클래스
```java
public abstract class OutputStream
{
    public abstract void write(int b) throws IOException;
    public void write(byte b[]) throws IOException;
    public void write(byte b[], int off, int len) throws IOException;
    public void flush() throws IOException;
    public void close() throws IOException;
}
```
***
### Buffered vs Unbuffered IO
- 버퍼링을 사용하면 더 효율적으로 더 많은 양의 정보를 읽은 다음 버퍼에서 더 많은 부분까지 읽을 수 있다.
- 최종적으로 플러시되기 전에 버퍼에 여러 번 쓸 수 있다.
- 데이터는 버퍼가 꽉 차있을 때, 스트림으로부터 읽어오거나, 스트림으로 써질수밖에 없다.
- 크기가 얼마나 될지 알려주는 출력 헤더를 추가한 다음, 데이터를 전송한다.
***
읽기 자료 
- [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html)
- [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html)
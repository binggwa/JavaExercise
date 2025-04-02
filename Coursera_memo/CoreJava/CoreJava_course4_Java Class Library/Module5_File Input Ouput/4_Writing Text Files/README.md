# 1. 텍스트 파일 Writing
***
### 텍스트 파일에 쓰기
1. 파일로 output 스트림을 연결한다.
2. 스트림에 텍스트 데이타를 쓴다.
3. 스트림을 닫는다.
***
ex)
```java
package com.lq;
import java.io.*;
/**
 * bufferedWriter를 이용해 텍스트 파일에 글을 쓰는 예제
 */
public class MyFileWriter
{
    public static void main(String[] args) {
        try {
            /**
             * 파일 라이터에 BufferedWriter를 생성
             * 파일 라이터는 파일 이름을 가져와서 연다
             */
            BufferedWriter bR = new BufferedWriter(
                    new FileWriter("myCars.txt")
            );
            bR.write("Corvette ");
            bR.write("Escalade ");
            bR.write("Town Car ");
            /**
             * bufferedWriter를 닫는다
             */
            bR.close();
        } catch (IOException e) {}
    }
}
```
읽기 자료
- [BufferedWriter](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html)
- [PrintWriter](https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html)
# 1. 파일과 디렉토리
***
- 파일 클래스는 IO에 관한 것이 아니라, 파일 시스템에 관한 것
- 파일로부터 읽고쓰기는 허락하지 않고, 파일과 디렉토리에 대한 다양한 프로퍼티를 찾을 수 있다.
- File을 이용해서, 디렉토리 구조, 어떤 디렉토리에 어떤 파일이 있는지, 어떤 타입인지 등을 알 수 있다.
***
### File input/output
- 파일 객체는 파일 시스템을 추상화한 프록시로, 파일과 디렉토리를 모두 나타낸다.
- **직접적으로 파일을 조작하는 데 사용되지 않는다.**
- IO를 수행하려면, FileInputStream, OutputStream, RandomAccessFile 등을 사용한다.
- **파일에 액세스하거나, 파일이 존재하는지 확인하는 용도**
***
### File 클래스 메서드
- isFile()
- isDirectory()
- canRead()
- canWrite()
- exists()
- length()
- delete() : * 임시파일을 삭제할 땐, delete on exit보다는 파일 클리닝 트래커를 사용하라.
- list()
- mkdir()
***
### 디렉토리 조작 예제
```java
package com.lq;
import java.io.*;

public class DirectoryChecker
{
    public static void main(String[] args) {
        File aDirectory = new File (".");
        if (aDirectory.isDirectory()) {
            String[] contents = aDirectory.list();
            for (int f = 0; f < contents.length; f++) {
                System.out.println(contents[f]);
            }
        }
    }
}
```
읽기 자료
- [NIO.2](https://www.oracle.com/technical-resources/articles/javase/nio.html)
- [파일 IO 튜토리얼](https://docs.oracle.com/javase/tutorial/essential/io/fileio.html)
- [Stream을 이용하여 파일 한 줄씩 처리하기](https://mkyong.com/java8/java-8-stream-read-a-file-line-by-line/)
- [Java 8 스트림을 사용한 파일 IO](https://www.nextptr.com/tutorial/ta1321112508/file-io-with-java-8-streams)
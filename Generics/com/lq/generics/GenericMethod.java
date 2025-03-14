package Generics.com.lq.generics;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 2 제네릭 예시
 *
 * @author 이병관
 * @since 2025.03.14
 */
import static java.lang.System.out;

public class GenericMethod {

    public static <E> void printArray( E[] inputArray ) {
        for ( E element: inputArray ) {
            out.printf("%s ", element);
        }
        out.println();
    }
}

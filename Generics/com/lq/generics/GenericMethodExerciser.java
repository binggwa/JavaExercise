package Generics.com.lq.generics;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 2 제네릭 예시
 *
 * @author 이병관
 * @since 2025.03.14
 */
import static java.lang.System.out;
import static Generics.com.lq.generics.GenericMethod.*;

public class GenericMethodExerciser {

    public static void main(String[] args) {

        Integer[] integerArray = { 1,2,3,4,5 };
        Double[] doubleArray = { 1.1,2.2,3.3,4.4,5.5 };
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        out.println("Integer array contains: ");
        printArray(integerArray);
        out.println("Double array contains: ");
        printArray(doubleArray);
        out.println("Character array contains: ");
        printArray(charArray);
    }
}

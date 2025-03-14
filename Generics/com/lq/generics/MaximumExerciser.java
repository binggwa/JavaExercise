package Generics.com.lq.generics;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 2 제네릭 예시
 *
 * @author 이병관
 * @since 2025.03.14
 */
import static java.lang.System.out;
import static Generics.com.lq.generics.Maximum.*;

public class MaximumExerciser {

    public static void main(String[] args) {
        out.printf("Maximum of %d, %d, and %d is %d\n", 5, 4, 3, maximum(5, 4, 3));
        out.printf("Maximum of %.1f, %.1f, and %.1f is %.1f\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
        /**
         * p 가 알파벳의 가장 나중 글자이기 때문에 pear가 출력된다.
         */
        out.printf("Maximum of %s, %s, and %s is %s\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
    }
}

package Generics.com.lq.generics;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 2 제네릭 예시
 *
 * @author 이병관
 * @since 2025.03.14
 */
import static java.lang.System.out;

public class GenericBoxExerciser {

    public static void main(String ... args) {
        GenericBox<Integer> integerBox = new GenericBox<>();
        GenericBox<String> stringBox = new GenericBox<>();
        integerBox.setT(10);
        stringBox.setT("Hello World");
        out.println("IntegerBox value: " + integerBox.getT());
        out.println("StringBox value: " + stringBox.getT());
    }
}

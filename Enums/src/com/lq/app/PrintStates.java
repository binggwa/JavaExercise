package com.lq.app;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 6 열거형
 *
 * @author 이병관
 * @since 2025.03.28
 */
import static java.lang.System.out;
import static com.lq.enums.States.values;
import com.lq.enums.States;

public class PrintStates {

    public static void main(String[] args) {
        for (States state : values()) {
            out.println(state + ": " + state.getName() + ", Capitol: " + state.getCapitol());
        }
    }
}

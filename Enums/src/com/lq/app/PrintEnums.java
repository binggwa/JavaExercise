package com.lq.app;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 6 열거형
 *
 * @author 이병관
 * @since 2025.03.28
 */
import com.lq.enums.TirePressures;
import static com.lq.enums.TirePressures.*;

public class PrintEnums {

    public static void main(String[] args) {

        TirePressures t = valueOf("RR");
        t.overridePressure(22);

        for (TirePressures tp: values()) {
            System.out.printf("%s is %d pounds%n", tp.getName(), tp.getPressure());
        }
    }
}

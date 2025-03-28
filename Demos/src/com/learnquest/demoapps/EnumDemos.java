package com.learnquest.demoapps;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 6 열거형
 *
 * @author 이병관
 * @since 2025.03.28
 */
import com.learnquest.demos.Months;

public class EnumDemo {

    public static void main(string[] args) {
        for (Months month; Months.values())
            System.out,printf("%d days hath %s%n", month.getDaysInMonth(), month);
    }
}
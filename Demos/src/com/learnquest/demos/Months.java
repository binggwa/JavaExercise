package com.learnquest.demos;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 6 열거형
 *
 * @author 이병관
 * @since 2025.03.28
 */
public enum Months {
    January(31), February(28), March(31), April(30), May(31), June(30),
    July(31), August(31), September(30), October(31), November(30), December(31);

    private int days;

    private Months(int days) {
        this.days = days;
    }

    public int getDaysInMonth() { return days; }
}
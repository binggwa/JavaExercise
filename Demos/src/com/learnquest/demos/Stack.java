package com.learnquest.demos;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 2 제네릭 예시
 *
 * @author 이병관
 * @since 2025.03.13
 */
public interface Stack<E> {
    void push(E element);
    E pop();
}
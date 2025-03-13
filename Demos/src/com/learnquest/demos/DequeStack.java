package com.learnquest.demos;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 2 제네릭 예시
 *
 * @author 이병관
 * @since 2025.03.13
 */
public class DequeStack<E> implements Stack<E> {
    private Deque<E> stack;

    public DequeStack() {
        stack = new LinkedList<E>();
    }

    @Override
    public void push(E element) {
        stack.push(element);
    }

    @Override
    public E pop() {
        return stack.pop();
    }
}
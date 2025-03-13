package com.learnquest.demos;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 2 제네릭 예시
 *
 * @author 이병관
 * @since 2025.03.13
 */
private static class StackArray<E> implements Stack<E> {
    int tos;
    E[] stack;
    /**
     * 스택을 10으로 초기화
     */
    public StackArray() {
        this(10);
    }
    /**
     * 모든 E는 객체이므로, 객체배열을 만들어 캐스팅하여 스택에 넣는다
     */
    @SuppressWarnings("unchecked")
    public StackArray(int maxdepth) {
        tos = 0;
        stack = (E[]) new Object[maxdepth];
    }
    /**
     * 스택에 push하는 메서드
     */
    @Override
    public void push(E element) {
        stack[tos++] = element;
    }
    /**
     * 스택에서 제거하는 pop 메서드
     */
    @Override
    public E pop() {
        // Empty stack returns null, since we have not covered Exception Handling, yet
        return tos > 0 ? stack[--tos] : null;
    }
}

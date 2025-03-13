package com.learnquest.demos;

import java.util.ArrayDeque;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 2 제네릭 예시
 *
 * @author 이병관
 * @since 2025.03.13
 */
public class GenericStackImpl<E> implements Stack<E> {
    /**
     * 우리가 만든 Deque 스택과 Java에서 제공하는 legacystack을 동시에 사용, Java에서 사용하는 것은 우리가 사용하는 것과 충돌할 수 있으므로 검증해야한다.
     * stack이 null이 아니라면 우리 스택을, null이라면 java.util.stack을 이용하도록 설정
     */
    Deque<E> stack;
    java.util.Stack<E> legacyStack;

    public GenericStackImpl() {
        switch (new java.util.Random().nextInt(5)) // Randomly pick an implementation
        {
            case 0:
                stack = new LinkedList<E>();
                break;

            case 1:
                stack = new ArrayDeque<E>();
                break;

            case 2:
                stack = new concurrentLinkedDeque<E>();
                break;

            case 3:
                stack = new LinkedBlockingDeque<E>();

            default:
                legacyStack = new java.util.Stack<E>();
        }

        System.out.printf("Using %s as the Stack<E> implementation\n", (stack != null ? stack : legacyStack).getClass().getName());
    }

    @Override
    public void push(E element) {
        if (stack != null) stack.push(element);
        else legacyStack.push(element);
    }

    @Override
    public E pop() {
        return stack != null ? stack.pop() : legacyStack.pop();
    }
}
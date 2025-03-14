package Generics.com.lq.generics;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 2 제네릭 예시
 *
 * @author 이병관
 * @since 2025.03.14
 */
public class GenericBox<T> {
    /**
     * T로 파라미터화된 클래스는 제네릭 T에 대한 private 바인딩, 게터와 세터가 존재해야 한다.
     */
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

}

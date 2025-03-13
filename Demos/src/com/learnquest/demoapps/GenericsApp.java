package com.learnquest.demoapps;

import com.learnquest.demos.GenericStackImpl;
import com.learnquest.demos.Stack;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 2 제네릭 예시
 *
 * @author 이병관
 * @since 2025.03.13
 */
public class GenereicsApp {

    public static Stack<String> makeStackString(Stack<String> strings) {
        strings.push("World");
        strings.push("Hello");

        return strings;
    }

    public static Stack<Integer> makeStackInteger(Stack<Integer> ints) {
        ints.push(5);
        ints.push(3);
        ints.push(2);
        ints.push(1);
        ints.push(1);

        return ints;
    }

    public static Stack<SportsCar> makeStackSportsCar(Stack<SportsCar> cars) {
        cars.push(new SportsCar("Mach 1", 250, 21, true));
        cars.push(new SportsCar("Mach 2", 250, 21, true));
        cars.push(new SportsCar("Mach 3", 250, 21, true));
        cars.push(new SportsCar("Mach 4", 250, 21, true));
        cars.push(new SportsCar("Mach 5", 250, 21, true));

        return cars;
    }
    /*
    public static void printStackRaw(Stack stack) {
        for (Object e = stack.pop(); e != null ; e = stack.pop()) {
            System.out.println(e);
        }
    }

    public static void raceStackRaw(Stack stack) {
        for (Object e = stack.pop(); e != null ; e = stack.pop()) {
            ((SportsCar)e).race();
        }
    }

    public static void printStackObject(Stack<Object> stack) {
        for (Object e = stack.pop(); e != null ; e = stack.pop()) {
            System.out.println(e);
        }
    }

    public static void printStackInteger(Stack<Integer> stack) {
        for (Object e = stack.pop(); e != null ; e = stack.pop()) {
            System.out.println(e);
        }
    }

    public static void printStackString(Stack<String> stack) {
        for (Object e = stack.pop(); e != null; e = stack.pop()) {
            System.out.println(e);
        }
    }

    public static void printStackSportsCar(Stack<SportsCar> stack) {
        for (Object e = stack.pop(); e != null; e = stack.pop()) {
            System.out.println(e);
        }
    }

    public static void printStackCar(Stack<Car> stack) {
        for (Object e = stack.pop(); e != null; e = stack.pop()) {
            System.out.println(e);
        }
    }
    */
    /**
     * 와일드카드의 활용법 학습을 위한 예시
     */
    public static void printStack(Stack<?> stack) {
        // Explicitly allow Stack of any type, but what else could we safely treat it as, other than Object?
        for (Object e = stack.pop(); e != null; e = stack.pop()) {
            System.out.println(e);
        }
    }

    public static void setSpeedStackCar(Stack<Car> stack) {
        for (Car e = stack.pop(); e != null; e = stack.pop()) {
            e.setSpeed(25);
        }
    }

    public static Stack<Car> makeStackCar(Stack<Car> cars) {
        cars.push(new SportsCar("Mach 5", 250, 21, true));
        cars.push(new SUV("Jurassic Explorer"));

        return cars;
    }
    /**
     * 바운드 와일드카드를 활용하여 Car와 SportsCar 둘 모두에 대해 동작하도록 설정
     */
    public static void setSpeedStackExtendsCar(Stack<? extends Car> stack) {
        for (Car e = stack.pop(); e != null; e = stack.pop()) {
            e.setSpeed(25);
        }
    }
    /**
     * 푸시할 때 오류 발생
     * 타입이 정확히 무엇인지 모르기 때문에 아무것도 추가할 수 없다.
     */
    public static Stack<? extends Car> makeStackExtendsCar(Stack<? extends Car> cars) {
        // <? extends X> cannot assign
        // if this were allowed, we could pass a Stack<SUV> and add add a SportsCar to it!
        cars.push(new SportsCar("Mach 5", 250, 21, true));
        cars.push(new SUV("Jurassic Explorer"));

        return cars;
    }

    public static Stack<? super Car> makeStackSuperCar(Stack<? super Car> cars) {
        // <? extends X> cannot assign
        // if this were allowed, we could pass a Stack<SUV> and add add a SportsCar to it!
        cars.push(new SportsCar("Mach 5", 250, 21, true));
        cars.push(new SUV("Jurassic Explorer"));

        return cars;
    }

    public static void setSpeedStackSuperCar(Stack<? super Car> stack) {
        // <? super X> cannot read
        // We only know that we've been giving Car or a super class.
        // We could pass a Stack<Object> and it would be OK.
        // We do not know anything about the instances on hand.
        for (Car e = stack.pop(); e != null; e = stack.pop()) {
            e.setSpeed(25);
        }
    }

    public static void main(String[] args) {
        /**
         * ints와 String 타입의 스택
         * 참조유형에서 이미 Interger와 String을 선언했으므로, 우항에서는 <>만으로 컴파일러가 인식할 수 있다.
         */
        /*
        Stack<Integer> ints = new GenericStackImpl<>();
        Stack<String> strings = new GenericStackImpl<>();
         */
        /**
         * 제네릭을 통해 타입 유형을 정했지만, 둘 다 메모리에서는 하나로 인식
         */
        /*
        if (ints.getClass() == strings.getClass())
            System.out.printf("Stack<Integer> and Stack<String> are both %s!\n", ints.getClass());

        strings.push("World");
        strings.push("Hello");
        // strings.push(5);  <-  String 제네릭으로 선언한 strings 배열에 int가 들어와 type safety 위반

        ints.push(5);
        ints.push(3);
        ints.push(2);
        ints.push(1);
        ints.push(1);
        // ints.push("Hello World");  <-  int 제네릭으로 선언한 ints 배열에 string이 들어와 type safety 위반
        */

        // Create stacks of different types
        Stack<Integer> ints = new StackArray<>();
        Stack<String> strings = new StackArray<>();
        Stack<SportsCar> racers = new StackArray<>();

        // Print them out raw ... it works
        // printStackRaw(makeStackInteger(ints));
        // printStackRaw(makeStackString(strings));
        // printStackRaw(makeStackSportsCar(racers));
        /**
         * racer의 raw타입 스택을 실행시켰을 때, raw 타입이었기 때문에 컴파일 타임 오류는 없다
         */
        // But this is why we use Generics instead of raw types ...
        // raceStackRaw(makeStackInteger(ints));        blows up
        // raceStackRaw(makeStackString(strings));      blows up
        // raceStackRaw(makeStackSportsCar(racers));    actually works

        // switch to Generics, and since OBject defines println
        // we can use Stack<Object>, right? NO.
        // printStackObject(makeStackInteger(ints));
        // printStackObject(makeStackString(strings));
        // printStackObject(makeStackSportsCar(racers));

        // The compiler demands that we have exact matching types
        // printStackInteger(makeStackInteger(ints));
        // printStackString(makeStackString(strings));
        // printStackSportsCar(makeStackSportsCar(racers));

        // It won't even let us use Car because we have SportsCar
        // printStackCar(makeStackSportsCar(racers));

        // This is becoming way too much work to usee generics, right?
        // But we can use a wildcard, Stack<?>, to fix it.
        printStack(makeStackInteger(ints));
        printStack(makeStackString(strings));
        printStack(makeStackSportsCar(racers));

        // The ? wildcard is acting as if it allows anything, but we treat the type as Object, since we know nothing else about it.

        // But what if we want to work with Car types generically, e.g., set the speed, which is not a method of Object?
        Stack<Car> cars = new StackArray<>(10);

        // Stack<Car> is OK as an exact match
        setSpeedStackCar(makeStackCar(cars));
        // But, we cannot use Stack<Car> when we have Stack<SportsCar>
        // setSpeedStackCar(makeStackSportsCar(racers));
        /**
         * 바운드 와일드카드를 활용하여 바로 위 구문과 다르게 Car와 SportsCar 둘 모두에 대해 동작하도록 설정
         */
        // So now we learn that wildcards can be "bounded", so that ? isn't just Object, but perhaps something else, like Car.
        // We can declare that the type is <? extends Car> -- something that EXTENDS Car, And now both are OK.
        setSpeedStackExtendsCar(makeStackCar(cars));
        setSpeedStackExtendsCar(makeStackSportsCar(racers));

        // So now let's have a method that will populate a stack of Car types
        // Right now, we have a Stack<Car> *and* a Stack<SportsCar>, Let's consolidate, and put them both in the Stack<Car> ...
        makeStackCar(cars);
        makeStackSportsCar(cars);   // incompatible types!

        // let's do the <? extends Car> that we just learned ...
        // But it may look ok HERE, but the method, itself, shows errors!
        // makeStackExtendsCar(cars);

        // Methods using <? extends> can only read not assign
        // We need a new way, <? super Car> to be able to assign
        makeStackSuperCar(cars);
        makeStackSuperCar(new StackArray<Object>());
        makeStackSuperCar(racers);
    }
}
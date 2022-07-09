package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new HelloGreeting();
        greeting.sayHello();

        Greeting greeting2 = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello");
            }
        };
        greeting2.sayHello();

        Greeting greeting3 = () -> System.out.println("Hello");
        greeting3.sayHello();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(n -> {
            System.out.println(n);
        });
        Calculator calculator = (x, y) -> {
            Random random = new Random();
            int randomNumber = random.nextInt(50);
            return x + y + randomNumber;
        };
        internalFunctionalInterfaces();
        internalDoubleFunctionalOperator();
        internalFunctionTypes();

        consumer();
        function();
    }

    public static void internalFunctionalInterfaces(){
        IntBinaryOperator calculator = (x, y) -> {
            Random random = new Random();
            int randomNumber = random.nextInt(50);
            return x + y + randomNumber;
        };

        System.out.println(calculator.applyAsInt(1, 2));
    }

    public static void internalDoubleFunctionalOperator(){
        DoubleBinaryOperator calculator = (x, y) -> {
            Random random = new Random();
            double randomNumber = random.nextDouble();
            return x + y + randomNumber;
        };

        System.out.println(calculator.applyAsDouble(1, 2));
    }

    public static void internalFunctionTypes(){
        DoubleConsumer consumer = (x) -> {
            System.out.println(x);
        };
        consumer.accept(10);

        DoubleConsumer consumer2 = (x) -> System.out.println("consumer2 "+x);
        consumer2
            .andThen((x) -> System.out.println("consumer3 "+x))
            .accept(1);;
    }

    public static void internalSupplier(){
        DoubleSupplier supplier = () -> {
            Random random = new Random();
            return random.nextDouble();
        };
        System.out.println("supplier "+supplier.getAsDouble());
    }

    public static void internalOneOperator(){
        DoubleUnaryOperator operator = (x) -> {
            Random random = new Random();
            return x + random.nextDouble();
        };

        System.out.println("unitary : "+operator.applyAsDouble(10));
    }

    public static void transformData(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach((e) -> {

        });
    }

    public static void consumer(){
        Consumer<String> consumerString= (x) -> {
            System.out.println(x);
        };
        consumerString.accept("Hello");

        BiConsumer <String, Integer> strCounter2 = (x, y) -> {
            System.out.println("double consumer : "+x+" "+y);
        };
        strCounter2.accept("daniel", 10);
    }

    public static void function(){
        Function<Integer, Integer> strCounter = (x) -> {
            return x*2;
        };

        Function<Integer, Integer> strCounter2 = (x) -> {
            return x*3;
        };

        Function<Integer, Integer> strCounter3 = (x) -> {
            return x*4;
        };
        System.out.println("str counter: "+strCounter.apply(1));

        BiFunction <String, Integer, Integer> strCounter10 = (x, y) -> {
            return x.length() + y;
        };
        System.out.println("str counter2: "+strCounter10.apply("Hello", 10));

        strCounter.andThen(strCounter2).compose(strCounter3).apply(10);
    }

    public static void biFunction(){
        BiFunction<String, String, Integer> strCounter = (strOne, strTwo) -> {
            return strOne.length() + strTwo.length();
        };
        
        System.out.println("str counter: "+strCounter.apply("Hello", "World"));
        
    }

    public static void producer(){
        Supplier<String> supplier = () -> {
            return "Hello";
        };
        System.out.println(supplier.get());
    }

    public static void predicate(){
        Predicate <String> predicate = (x) -> {
            return x.length() > 5;
        };
        System.out.println("less than"+predicate.test("Hello"));

        BiPredicate <String, Integer> predicate2 = (x, y) -> {
            return x.length() > y;
        };

        BiPredicate <String, Integer> predicate3 = (x, y) -> {
            return x.length() > y;
        };

        BiPredicate <String, Integer> predicate4 = (x, y) -> {
            return x.length() > y;
        };
        System.out.println(predicate2.test("asdfas", 10));

        predicate2.and(predicate3).or(predicate4).test("daniel", 10);

    }

    public static void operators(){
        UnaryOperator <String> operator = (x) -> {
            return x.toUpperCase();
        };
        operator.apply("hi there");

        BinaryOperator <String> operator2 = (x, y) -> {
            return x + y;
        };
        operator2.apply("daniel", "molina");
    }
    
}


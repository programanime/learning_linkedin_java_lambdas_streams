package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    }
}


package com.example;

public class HelloGreeting implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("hello world from sayhello");
    }
}

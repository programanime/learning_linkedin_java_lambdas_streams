# learning_linkedin_java_lambdas_streams

# Linkedin lambdas and streams

[lambda repo](https://github.com/LinkedInLearning/java-lambdas-streams-2453107)

# functional programming
- they  are call pure function too, which means, for the same input, same output

![](img/functional_programming.png1)  

- function could have functions as input


## functional interface
 - base for lambda function
 - they could be use as a functional argument
 - you could not add more than one method to keep it as a functional interface

[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Greeting.java)
```java
@FunctionalInterface
public interface Greeting {
    void sayHello();
}

```

## passing lambda as argument
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
list.forEach((e) -> {
    System.out.println(e);
});
```

## invoking functionalInterface
 1. building a class base on it

[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Greeting.java)
```java
package com.example;

@FunctionalInterface
public interface Greeting {
    void sayHello();
}
```
 
 2. anonymous class
 


[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
Greeting greeting2 = new Greeting() {
    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
};
greeting2.sayHello();
```

 3. lambda function
 

[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
Greeting greeting3 = () -> System.out.println("Hello");
        greeting3.sayHello();
```

[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
list.forEach(n -> {
            System.out.println(n);
        });
```

## how to implement a lambda
 1. write the functional interface


[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Calculator.java)
```java
package com.example;

@FunctionalInterface
public interface Calculator {
    int calculate(int x, int y);
}

```
 2. implement the functional interface with one class

[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
Calculator calculator = (x, y) -> {
    Random random = new Random();
    int randomNumber = random.nextInt(50);
    return x + y + randomNumber;
};
```

## java.util.function
[java.util.function](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)  

 - group of functional interfaces to work with integers, doubles, strings, ...., and the general one which is function

 - there are some kind of functions
 1. Binary: get two values and return one


[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
DoubleBinaryOperator calculator = (x, y) -> {
            Random random = new Random();
            double randomNumber = random.nextDouble();
            return x + y + randomNumber;
        };

        System.out.println(calculator.applyAsDouble(1, 2));
```
 
 2. Consumer: get the value, but does not return anything
    
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
DoubleConsumer consumer = (x) -> {
    System.out.println(x);
};
consumer.accept(10);
```

 3. Function
 4. Supplier: return a value, without get any argument

[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
DoubleSupplier supplier = () -> {
            Random random = new Random();
            return random.nextDouble();
        };
        System.out.println("supplier "+supplier.getAsDouble(););
```
 5. Unary operator: get just one value and return one value

[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
DoubleUnaryOperator operator = (x) -> {
    Random random = new Random();
    return x + random.nextDouble();
};

System.out.println("unitary : "+operator.applyAsDouble(10));
```

# general lambda function
1. function
get one value and return one
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
        Function<String, Integer> strCounter = (x) -> {
            return x.length();
        };
        System.out.println("str counter: "+strCounter.apply("Hello"));
```
2. BiFunction
get two values and return one
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
        BiFunction<String, String, Integer> strCounter = (strOne, strTwo) -> {
            return strOne.length() + strTwo.length();
        };
        
        System.out.println("str counter: "+strCounter.apply("Hello", "World"));
```


3. consumer
get one value and return nothing
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
        Consumer<String> consumerString= (x) -> {
            System.out.println(x);
        };
        consumerString.accept("Hello");
```

4. BiConsumer
get two values and return nothing
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
    BiConsumer <String, Integer> strCounter2 = (x, y) -> {
        System.out.println("double consumer : "+x+" "+y);
    };
    strCounter2.accept("daniel", 10);
```

5. supplier
receives not parameters and return a value
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
        Supplier<String> supplier = () -> {
            return "Hello";
        };
        System.out.println(supplier.get());
```

7. predicate: return a boolean
get one parameter and return a boolean
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
Predicate <String> predicate = (x) -> {
            return x.length() > 5;
        };
        System.out.println("less than"+predicate.test("Hello"));
```

8. BiPredicate
get two parameters and return a boolean
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
        BiPredicate <String, Integer> predicate2 = (x, y) -> {
            return x.length() > y;
        };
        System.out.println(predicate2.test("asdfas", 10));
```

9. UnaryOperator
receive one parameter and return the same type value
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
        UnaryOperator <String> operator = (x) -> {
            return x.toUpperCase();
        };
        operator.apply("hi there");
```


10. BinaryOperator
receive two parameters and return the same type value
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
        BinaryOperator <String> operator2 = (x, y) -> {
            return x + y;
        };
        operator2.apply("daniel", "molina");
```

# operations with lambda functions
# lambda functions composition

### predicate
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
        predicate2.and(predicate3).or(predicate4).test("daniel", 10);
```
### functions
[file](file:b:/learning_linkedin_java_lambdas_streams/src/main/java/com/example/Main.java)
```java
        strCounter.andThen(strCounter2).compose(strCounter3).apply(10);
```

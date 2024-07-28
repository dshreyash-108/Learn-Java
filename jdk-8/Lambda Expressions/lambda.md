Lambda expressions, introduced in Java 8, provide a concise and expressive way to represent functional interfaces (interfaces with a single abstract method) in Java. They allow you to write more readable and maintainable code by enabling you to use anonymous functions in a functional style.

Here’s an overview of lambda expressions, including their syntax, usage, and common applications:

### Syntax of Lambda Expressions

The basic syntax of a lambda expression is:

```java
(parameters) -> expression
```

Or, if you have more complex logic:

```java
(parameters) -> { statements }
```

### Components of Lambda Expressions

1. **Parameters:** The input parameters to the lambda expression. If there is only one parameter, parentheses can be omitted. For example, `(x) -> x + 1` or `x -> x + 1`.

2. **Arrow Token (`->`):** Separates the parameters from the body of the lambda expression.

3. **Body:** The logic or expression to be executed. If the body contains multiple statements, it must be enclosed in curly braces `{}` and include a `return` statement if needed.

### Examples

#### 1. Simple Example

Suppose you have a `FunctionalInterface`:

```java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}
```

You can use a lambda expression to implement this interface:

```java
Greeting greeting = (name) -> System.out.println("Hello, " + name);
greeting.sayHello("Alice");
```

#### 2. Using Lambda with Collections

Lambda expressions are particularly useful with Java Streams and Collection API methods like `forEach`, `map`, `filter`, etc.

**Example with `forEach`:**

```java
import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using lambda expression with forEach
        names.forEach(name -> System.out.println(name));
    }
}
```

**Example with `map` and `filter` (Stream API):**

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaStreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Convert all names to uppercase and filter names that start with 'A'
        List<String> filteredNames = names.stream()
            .map(String::toUpperCase) // Convert to uppercase
            .filter(name -> name.startsWith("A")) // Filter names starting with 'A'
            .collect(Collectors.toList()); // Collect results into a List

        System.out.println(filteredNames); // Output: [ALICE]
    }
}
```

### Functional Interfaces

Lambda expressions can only be used with interfaces that have exactly one abstract method. These are known as functional interfaces. Common examples of functional interfaces in the Java Standard Library include:

- `Runnable` (with method `run()`)
- `Callable<V>` (with method `call()`)
- `Consumer<T>` (with method `accept(T t)`)
- `Function<T, R>` (with method `apply(T t)`)
- `Predicate<T>` (with method `test(T t)`)
- `Supplier<T>` (with method `get()`)

#### Example with `Function` and `Predicate`:

```java
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaFunctionalInterfaces {
    public static void main(String[] args) {
        // Using Function
        Function<String, Integer> lengthFunction = s -> s.length();
        System.out.println(lengthFunction.apply("Hello")); // Output: 5

        // Using Predicate
        Predicate<String> startsWithA = s -> s.startsWith("A");
        System.out.println(startsWithA.test("Apple")); // Output: true
        System.out.println(startsWithA.test("Banana")); // Output: false
    }
}
```

### Method References

Method references provide a way to refer to methods without executing them. They are a shorthand notation of a lambda expression. They can be used where a lambda expression is simply passing its arguments to a method.

**Syntax:**

- **Static Method Reference:** `ClassName::staticMethodName`
- **Instance Method Reference:** `instance::instanceMethodName`
- **Constructor Reference:** `ClassName::new`

**Examples:**

```java
import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using method reference to print names
        names.forEach(System.out::println);

        // Using method reference to convert to uppercase
        List<String> upperCaseNames = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println(upperCaseNames); // Output: [ALICE, BOB, CHARLIE]
    }
}
```

### Summary

Lambda expressions in Java streamline functional programming by allowing concise and readable code. They are most effective when used with functional interfaces, collections, and streams, enabling powerful data processing capabilities with less boilerplate code.

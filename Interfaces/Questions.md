
## What is an interface in Java (or any other language you're discussing)?

An interface in Java is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. It provides a contract for classes that implement it, specifying what methods they must implement without providing any implementation details itself.

## How does an interface differ from an abstract class?

Interfaces differ from abstract classes primarily in their purpose and structure:
Interfaces can only declare method signatures, constants, and default/static methods, whereas abstract classes can also have method implementations (concrete methods).
A class can implement multiple interfaces but can only inherit from one abstract class (Java doesn’t support multiple inheritance of classes).
Interfaces are used to define types and provide a form of multiple inheritance in terms of type, whereas abstract classes are used to define common behavior among related classes.

## Can you give an example of when you would use an interface over an abstract class?

Interfaces are preferred when you want to define a contract for a wide range of unrelated classes. For example, in Java, the Comparable interface is used to impose a natural ordering on instances of a class, allowing them to be sorted. Many classes such as String, Integer, etc., implement Comparable to enable natural ordering. This flexibility wouldn’t be possible with an abstract class, which binds its subclasses to a single parent class hierarchy.


## How do interfaces support multiple inheritance in Java?

Java interfaces support multiple inheritance of type, meaning a class can implement multiple interfaces. This allows a class to inherit methods from multiple unrelated interfaces, enabling diverse behaviors without the complexity of multiple inheritance of implementation (which can lead to issues like the diamond problem in languages that support multiple inheritance of classes).


## How can you achieve abstraction through interfaces?

Interfaces achieve abstraction by defining a contract that classes must follow without specifying the implementation details. This allows different classes to implement the same interface in different ways, as long as they adhere to the defined contract. Clients can then interact with these classes through their common interface, without needing to know about their specific implementations.


## What are default methods in interfaces? When would you use them?

Default methods were introduced in Java 8 to allow interfaces to have methods with default implementations. These methods are marked with the default keyword and can be overridden by classes that implement the interface. Default methods are used to provide backward compatibility with existing code when new methods are added to interfaces, allowing them to evolve without breaking existing implementations.

## How do you implement multiple interfaces in a class?

To implement multiple interfaces in a class, you list the interfaces in the implements clause of the class declaration, separated by commas. For example:

```java
public class MyClass implements Interface1, Interface2 {
    // Class implementation
}

```
## Can interfaces have fields? Why or why not?

Interfaces can declare constants, which are implicitly public, static, and final. These are typically used for defining constants that implementing classes can use. However, interfaces cannot have instance fields (fields that are not static and final) because interfaces are meant to define a contract rather than store state. Instances of fields are specific to each class that implements the interface, which contradicts the purpose of defining common behavior in an interface.


## New Features Added in Interfaces in JDK 8
There are certain features added to Interfaces in JDK 8 update mentioned below:

1. Prior to JDK 8, the interface could not define the implementation. We can now add default implementation for interface methods. This default implementation has a special use and does not affect the intention behind interfaces.

Suppose we need to add a new function to an existing interface. Obviously, the old code will not work as the classes have not implemented those new functions. So with the help of default implementation, we will give a default body for the newly added functions. Then the old codes will still work.


```java
// Java program to show that interfaces can
// have methods from JDK 1.8 onwards

interface In1
{
    final int a = 10;
    default void display()
    {
        System.out.println("hello");
    }
}

// A class that implements the interface.
class TestClass implements In1
{
    // Driver Code
    public static void main (String[] args)
    {
        TestClass t = new TestClass();
        t.display();
    }
}

```

2. Another feature that was added in JDK 8 is that we can now define static methods in interfaces that can be called independently without an object. 
```php

// Java Program to show that interfaces can
// have methods from JDK 1.8 onwards

interface In1
{
    final int a = 10;
    static void display()
    {
        System.out.println("hello");
    }
}

// A class that implements the interface.
class TestClass implements In1
{
    // Driver Code
    public static void main (String[] args)
    {
        In1.display();
    }
}

```
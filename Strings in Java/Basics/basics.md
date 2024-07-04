### 1. String

- **Immutable**: Once a `String` object is created, its value cannot be changed. Any operation that modifies the string (like concatenation, converting to uppercase, etc.) actually creates a new `String` object.
- **Thread-safe**: Because `String` objects are immutable, they are inherently thread-safe. Multiple threads can safely access and share `String` objects without the risk of data corruption.
- **Usage**:
  - Ideal for scenarios where the value of the string is not expected to change frequently.
  - Commonly used for representing constants and literals in Java programs.
  - Provides various utility methods like `substring()`, `toUpperCase()`, `toLowerCase()`, etc., which return new `String` objects with the modified content.

Example:

```java
String str = "Hello";
str = str.concat(" World");  // This creates a new String object "Hello World"
```

### IMP: NOTE THE OUTPUT DIFFERENCES HERE 📌🚨

```java
// Java Program to demonstrate Immutable String in Java
import java.io.*;

class GFG {
    public static void main(String[] args)
    {
        String s = "Sachin";

        // concat() method appends
        // the string at the end
        s.concat(" Tendulkar");

        // This will print Sachin
        // because strings are
        // immutable objects
        System.out.println(s);
    }
}

//output: Sachin
```

**BUT
**

```java
// Java Program to demonstrate Explicitly assigned strings
import java.io.*;

class GFG {
    public static void main(String[] args)
    {
        String name = "Sachin";
        name = name.concat(" Tendulkar");
        System.out.println(name);
    }
}

//OUTPUT : Sachin Tendulkar
```

### 2. StringBuffer

- **Mutable**: Unlike `String`, `StringBuffer` is mutable, meaning its contents can be modified after it is created. Operations like append, insert, delete, and replace modify the `StringBuffer` object directly.
- **Thread-safe**: `StringBuffer` is synchronized, which means it is safe to use in multithreaded environments where multiple threads may concurrently modify the same `StringBuffer` instance.
- **Usage**:
  - Suitable for scenarios where there is a need to modify strings frequently in a multithreaded environment.
  - Provides similar methods as `String` for manipulation (`append()`, `insert()`, `delete()`, `replace()`, etc.).

Example:

```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");  // Modifies sb directly to "Hello World"
```

### 3. StringBuilder

- **Mutable**: `StringBuilder` is similar to `StringBuffer` in that it also provides a mutable sequence of characters. However, `StringBuilder` is not synchronized, making it faster in single-threaded scenarios where thread safety is not a concern.
- **Not Thread-safe**: Unlike `StringBuffer`, `StringBuilder` is not synchronized, so it should not be used in multithreaded environments unless proper synchronization mechanisms are implemented externally.
- **Usage**:
  - Preferred choice for string manipulation in single-threaded environments or scenarios where synchronization overhead is not desired.
  - Provides methods like `append()`, `insert()`, `delete()`, `replace()`, etc., for modifying the contents of the `StringBuilder` object directly.

Example:

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");  // Modifies sb directly to "Hello World"
```

### Comparison:

- **Performance**: `StringBuilder` is generally faster than `StringBuffer` due to lack of synchronization overhead, but both are faster than `String` for operations that involve frequent modifications.

- **Thread Safety**: Use `StringBuffer` when thread safety is required (multithreaded environments). Use `StringBuilder` for better performance in single-threaded scenarios.

- **Mutability**: `StringBuffer` and `StringBuilder` are mutable and allow direct modification of the string content, while `String` does not.

In summary, the choice among `String`, `StringBuffer`, and `StringBuilder` depends on the specific requirements of your application:

- Use `String` for immutable, constant values.
- Use `StringBuffer` for mutable operations in multithreaded environments.
- Use `StringBuilder` for mutable operations in single-threaded environments where performance is critical.

## String functions :

important and commonly used functions and methods available for working with strings in Java:

### 1. `length()`

- **Description**: Returns the length (number of characters) of the string.
- **Usage**: `int length = str.length();`

### 2. `charAt(int index)`

- **Description**: Returns the character at the specified index in the string.
- **Usage**: `char ch = str.charAt(0);`

### 3. `substring(int beginIndex)`

- **Description**: Returns a substring of the string starting from `beginIndex` to the end of the string.
- **Usage**: `String substr = str.substring(3);`

### 4. `substring(int beginIndex, int endIndex)`

- **Description**: Returns a substring of the string starting from `beginIndex` to `endIndex-1`.
- **Usage**: `String substr = str.substring(2, 5);`

### 5. `indexOf(String str)`

- **Description**: Returns the index of the first occurrence of the specified substring within the string, or `-1` if not found.
- **Usage**: `int index = str.indexOf("lo");`

### 6. `lastIndexOf(String str)`

- **Description**: Returns the index of the last occurrence of the specified substring within the string, or `-1` if not found.
- **Usage**: `int lastIndex = str.lastIndexOf("lo");`

### 7. `startsWith(String prefix)`

- **Description**: Checks if the string starts with the specified prefix.
- **Usage**: `boolean startsWith = str.startsWith("He");`

### 8. `endsWith(String suffix)`

- **Description**: Checks if the string ends with the specified suffix.
- **Usage**: `boolean endsWith = str.endsWith("lo");`

### 9. `toUpperCase()`

- **Description**: Returns a new string with all characters converted to uppercase.
- **Usage**: `String upperCaseStr = str.toUpperCase();`

### 10. `toLowerCase()`

- **Description**: Returns a new string with all characters converted to lowercase.
- **Usage**: `String lowerCaseStr = str.toLowerCase();`

### 11. `trim()`

- **Description**: Returns a new string with leading and trailing whitespace removed.
- **Usage**: `String trimmedStr = str.trim();`

### 12. `replace(char oldChar, char newChar)`

- **Description**: Returns a new string where all occurrences of `oldChar` are replaced with `newChar`.
- **Usage**: `String replacedStr = str.replace('l', 'L');`

### 13. `replaceAll(String regex, String replacement)`

- **Description**: Returns a new string where all substrings that match the given regular expression `regex` are replaced with `replacement`.
- **Usage**: `String replacedStr = str.replaceAll("\\s+", "");`

### 14. `split(String regex)`

- **Description**: Splits the string into an array of substrings based on the delimiter specified by the regular expression `regex`.
- **Usage**: `String[] parts = str.split("\\s+");`

### 15. `concat(String str)`

- **Description**: Concatenates the specified string `str` to the end of the invoking string.
- **Usage**: `String concatenatedStr = str.concat(" World");`

### 16. `isEmpty()`

- **Description**: Checks if the string is empty (i.e., has a length of `0`).
- **Usage**: `boolean isEmpty = str.isEmpty();`

These are some of the most commonly used methods and functions for manipulating and working with strings in Java. They provide powerful capabilities for string handling, manipulation, searching, and extraction.

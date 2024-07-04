# IMP QUESTIONS OF STRINGS

### 1. What are strings in Java?

- Strings are the types of objects which can store characters as elements.

### 2. why strings are immutable in java?

#### GFG :

- Because java uses the concept of string literal. Suppose there are 5 reference variables, all refer to one object “Sachin”. If one reference variable changes the value of the object, it will be affected by all the reference variables. That is why string objects are immutable in Java.
- Answered only about concurrency aspect of it.

#### CHATGPT :

Strings are immutable in Java primarily for reasons related to efficiency, security, and concurrency.

1. **Efficiency**:

   - Immutable objects are more memory efficient because once a string object is created, it cannot be changed. This allows Java to optimize string storage, reuse existing objects, and perform certain optimizations like string interning (storing only one copy of each distinct string value), which saves memory.

2. **Thread Safety**:

   - Since strings are immutable, they are inherently thread-safe. Multiple threads can access and share strings without the risk of data corruption. This simplifies concurrent programming because developers don't need to synchronize access to strings.

3. **Security**:

   - Strings are widely used in Java for storing sensitive information like passwords or usernames. If strings were mutable, a malicious program could change the value of a string after it has been created, potentially compromising security. Immutability ensures that once a string is created, its value remains unchanged.

4. **Caching and Hashing**:

   - Immutable strings can be cached and their hash codes precomputed, which makes them suitable for use as keys in hash tables or for other caching mechanisms. This improves the performance of operations like string comparison and lookup.

5. **Design Considerations**:
   - Immutability encourages good programming practices. It promotes cleaner code by eliminating the need for defensive copying and reduces the likelihood of bugs related to inadvertent changes in shared data.

Overall, Java's decision to make strings immutable is a design choice that balances performance, security, and simplicity in concurrent programming. While it may require a different approach to handling string manipulations (such as using `StringBuilder` for mutable string operations), the benefits in terms of reliability and efficiency are significant.

### 3. Why Java uses the concept of string literal?

- To make Java more memory efficient (because no new objects are created if it exists already in the string constant pool).

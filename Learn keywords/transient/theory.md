# transient keyword

In Java, the `transient` keyword is used to indicate to the Java serialization mechanism that a particular field should not be serialized when an object is converted into a byte stream. This is useful in scenarios where you have fields that contain sensitive information or fields that are derived/calculated and don't need to be saved.

#### why we use it?
    transient keyword plays an important role to meet security constraints. There are various real-life examples where we don’t want to save private data in file. Another use of transient keyword is not to serialize the variable whose value can be calculated/derived using other serialized objects or system such as age of a person, current date, etc.

### Note: 
    serialization is Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. This mechanism is used to persist the object.

#### why we do serialization?
    Serialization in Java (and other programming languages) is done to convert the state of an object into a byte stream, which can be easily stored, transmitted over a network, or persisted to a file system. This allows objects to be reconstructed later, preserving their state across different sessions or platforms.

Let's analyze the example provided and understand how `transient` works:

```java
import java.io.*;

//this won't compile in online compiler

class Test implements Serializable {
    // Normal variables
    int i = 10, j = 20;

    // Transient variables
    transient int k = 30;

    // Use of transient has no impact here
    transient static int l = 40;
    transient final int m = 50;

    public static void main(String[] args) throws Exception {
        Test input = new Test();

        // Serialization
        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(input);
        oos.close();

        // Deserialization
        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Test output = (Test) ois.readObject();
        ois.close();

        // Output the values
        System.out.println("i = " + output.i);
        System.out.println("j = " + output.j);
        System.out.println("k = " + output.k);   // Note: transient field 'k' will print default value (0 for int)
        System.out.println("l = " + output.l);   // Note: transient static field 'l' retains its value (40)
        System.out.println("m = " + output.m);   // Note: transient final field 'm' retains its value (50)
    }
}
```

### Explanation of Output:

1. **Serialization and Deserialization**:
   - The `Test` class implements `Serializable`, which allows its objects to be serialized and deserialized.
   - When `input` of type `Test` is serialized using `ObjectOutputStream`, its fields are written to the file "abc.txt".
   - When `input` is deserialized using `ObjectInputStream`, a new `Test` object `output` is created from the byte stream.

2. **Field Values After Deserialization**:
   - `i = 10`: This is a normal instance variable and is serialized and deserialized as expected.
   - `j = 20`: Similarly, `j` is a normal instance variable and behaves as expected.
   - `k = 0`: `k` is marked as `transient`, so its value is not serialized. Upon deserialization, its default value (0 for `int`) is assigned.
   - `l = 40`: `l` is marked as `transient` and `static`. Transient fields are not serialized, but since it's `static`, its value is retained in the class definition itself and not with individual objects. Therefore, `l` retains its value of 40 after deserialization.
   - `m = 50`: `m` is marked as `transient` and `final`. Final variables are directly serialized by their values, so the `transient` keyword has no effect on `m`. Hence, `m` retains its value of 50 after deserialization.

### Key Points:
- **transient and static**: Transient fields are not serialized, but static fields are not serialized with individual objects anyway; their values are retained in the class definition.
- **transient and final**: Final variables are serialized directly by their values, so `transient` has no effect on them.
- **Purpose of transient**: Used primarily for security (to exclude sensitive information) or for optimization (excluding redundant or calculated fields).

In summary, `transient` is a powerful keyword in Java serialization that allows developers to control which fields are serialized based on their specific needs, ensuring security and efficiency in object serialization processes.
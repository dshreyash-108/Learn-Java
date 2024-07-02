# .join() method

In Java, the `.join()` method is used to pause the execution of the current thread until the thread on which `.join()` is called has finished executing. This method allows you to ensure that a thread completes its execution before the current thread continues its own execution. Here's a more detailed explanation:

### Usage and Syntax

The `.join()` method belongs to the `Thread` class in Java. Here's its basic syntax:

```java
public final void join() throws InterruptedException
```

When you call `.join()` on a thread object, it causes the current thread (usually the main thread or another thread that needs to wait) to pause its execution until the thread it's joining with (the thread on which `.join()` is called) terminates.

### Example Scenario

Let's say you have two threads: `thread1` and `thread2`. You want `thread1` to wait for `thread2` to complete before proceeding further. Here’s how you can use `.join()`:

```java
Thread thread1 = new Thread(() -> {
    System.out.println("Thread 1 is running...");
});

Thread thread2 = new Thread(() -> {
    try {
        Thread.sleep(2000); // Simulate some task that takes time
        System.out.println("Thread 2 is running...");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
});

thread1.start(); // Start thread 1
thread2.start(); // Start thread 2

try {
    thread2.join(); // Wait for thread 2 to complete
    System.out.println("Thread 2 has completed.");
} catch (InterruptedException e) {
    e.printStackTrace();
}

// After thread 2 completes, thread 1 can continue
System.out.println("Thread 1 can now continue.");
```

### Explanation

1. `thread1` and `thread2` are created and started.
2. `thread1` starts executing immediately.
3. `thread2` starts executing, but before it completes its task, `.join()` is called on `thread2` from the main thread (`thread1` is not waiting for `thread2`).
4. The main thread (in this case, `thread1`) is paused at the `.join()` call until `thread2` finishes its execution (after 2 seconds in this example).
5. Once `thread2` finishes, the main thread resumes execution after the `.join()` call and continues with its tasks.

### Handling Interruptions

The `.join()` method can throw an `InterruptedException`, which means that if the thread waiting for another thread to finish is interrupted (e.g., by another thread calling `.interrupt()` on it), it will throw this exception. It's generally good practice to catch and handle this exception appropriately.

### Summary

`.join()` is a powerful method in Java threading for synchronization purposes. It allows one thread to wait for the completion of another thread's execution before continuing its own tasks. This ensures orderly execution of threads and coordination between them when necessary.

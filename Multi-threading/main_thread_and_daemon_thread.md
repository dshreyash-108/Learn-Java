# Main Thread

In Java, the main thread is special because it is the thread that executes the `main()` method of your program when it starts. Here's a summary of key points about the main thread and its behavior:

1. **Main Thread Basics**:

   - **Creation**: The main thread is automatically created by the Java Virtual Machine (JVM) when your program starts.
   - **Purpose**: It executes the `main()` method, which is the entry point of a Java application.
   - **Control**: You can obtain a reference to the main thread using `Thread.currentThread()`.
   - **Naming**: By default, its name is "main", but you can change it using `setName()` method.
   - **Priority**: Initially, the main thread has a default priority of `Thread.NORM_PRIORITY` (5).

2. **Modifying Main Thread**:

   - **Changing Name**: You can change the name of the main thread using `setName()` method.
   - **Changing Priority**: The priority of the main thread can be adjusted using `setPriority()` method. In the example, `t.setPriority(MAX_PRIORITY);` sets it to the maximum priority level (`Thread.MAX_PRIORITY` which is 10).

3. **Execution and Multithreading**:

   - **Single Threaded Execution**: Initially, the main thread executes your `main()` method in a single-threaded manner.
   - **Creating Child Threads**: You can create new threads (child threads) from the main thread using the `Thread` class or its subclasses (`Runnable` or `Callable` implementations).

4. **Deadlocking Example**:

   - **Deadlock Explanation**: Deadlock occurs when a thread is waiting for another thread to release a resource that it holds, while that other thread is waiting for the first thread to release a different resource. In the example provided, `Thread.currentThread().join();` causes the main thread to wait for itself to finish, leading to deadlock because it will never complete.

5. **Key Considerations**:
   - **Responsibility**: The main thread is responsible for initializing your program and can perform cleanup tasks before the program exits.
   - **Concurrency**: It can manage and coordinate the execution of other threads that are created during its execution.
   - **Shutdown Actions**: Often, it needs to be the last thread to finish execution to ensure proper shutdown of the application.

Understanding the main thread in Java is crucial for managing the flow of execution in your program and for coordinating activities across multiple threads if your application involves concurrency. It serves as the primary execution context from which all other threads are spawned and managed.

# Daemon Threads

Daemon threads in Java are special types of threads that run in the background, providing support to user threads and performing tasks such as garbage collection, finalization, or other background activities. Here's a summary of key points regarding daemon threads in Java:

1. **Definition and Purpose**:

   - Daemon threads are low-priority threads that run in the background to perform tasks that support the main execution of a program.
   - They are typically used for tasks like garbage collection and finalization, where continuous maintenance is required without interrupting the main tasks of the program.

2. **Characteristics**:

   - **Automatic Termination**: If all user threads (non-daemon threads) complete their execution, the JVM terminates itself along with all daemon threads, regardless of whether they have finished their tasks.
   - **Low Priority**: Daemon threads have the lowest priority among all threads. They are designed not to interfere with the execution of user threads.
   - **Default Nature**: By default, threads inherit their daemon status from their parent thread. The main thread (and subsequently all user-created threads) is non-daemon unless explicitly set otherwise.

3. **Methods**:

   - `void setDaemon(boolean status)`: Marks the current thread as either a daemon or a user thread. This method must be called before starting the thread. An attempt to call this method after the thread has started results in `IllegalThreadStateException`.
   - `boolean isDaemon()`: Checks if the current thread is a daemon thread. Returns `true` if the thread is daemon, otherwise `false`.

4. **Usage Example**:

   ```java
   public class DaemonThreadExample extends Thread {
       public void run() {
           if (Thread.currentThread().isDaemon()) {
               System.out.println(getName() + " is a Daemon thread");
           } else {
               System.out.println(getName() + " is a User thread");
           }
       }

       public static void main(String[] args) {
           DaemonThreadExample t1 = new DaemonThreadExample();
           DaemonThreadExample t2 = new DaemonThreadExample();

           t1.setDaemon(true); // Setting t1 as daemon

           t1.start();
           t2.start();
       }
   }
   ```

   - **Output**:
     ```
     Thread-0 is a Daemon thread
     Thread-1 is a User thread
     ```
   - In this example, `t1` is explicitly set as a daemon thread using `setDaemon(true)`, while `t2` remains a user thread by default.

5. **Exception Handling**:
   - Attempting to set a thread as daemon after it has started results in `IllegalThreadStateException`, as shown in the example provided.

Daemon threads are essential for background tasks and managing resources in Java applications. They allow for efficient management of system resources and support the overall functionality of the Java Virtual Machine. Understanding daemon threads is crucial for Java developers to effectively optimize application performance and manage thread behavior.

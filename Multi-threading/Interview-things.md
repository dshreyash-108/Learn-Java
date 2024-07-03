# IMP QUESTIONS

Note: Taking these from Interview bit.

### 1. What is the start() and run() method of Thread class?

start(): In simple words, the start() method is used to start or begin the execution of a newly created thread. When the start() method is called, a new thread is created and this newly created thread executes the task that is kept in the run() method. One can call the start() method only once for a particular thread.

run(): In simple words, the run() method is used to start or begin the execution of the same thread. When the run() method is called, no new thread is created as in the case of the start() method. This method is executed by the current thread. One can call the run() method multiple times.

### 2. What is Thread in Java?

Threads are basically the lightweight and smallest unit of processing that can be managed independently by a scheduler. Threads are referred to as parts of a process that simply let a program execute efficiently with other parts or threads of the process at the same time. Using threads, one can perform complicated tasks in the easiest way. It is considered the simplest way to take advantage of multiple CPUs available in a machine. They share the common address space and are independent of each other.

### 3. What are the two ways of implementing thread in Java?

There are basically two ways of implementing thread in java as given below:

```java
Extending the Thread class
Example:

class MultithreadingDemo extends Thread{
    public void run(){
        System.out.println("My thread is in running state.");
    }
    public static void main(String args[]){
        MultithreadingDemo obj=new MultithreadingDemo();
        obj.start();
    }
}

```

Output:

My thread is in running state.

```java
Implementing Runnable interface in Java
Example:


class MultithreadingDemo implements Runnable{
    public void run(){
        System.out.println("My thread is in running state.");
    }
    public static void main(String args[]){
        MultithreadingDemo obj=new MultithreadingDemo();
        Threadtobj =new Thread(obj); tobj.start();
    }
}
```

Output:

My thread is in running state.

I'll be commiting more like these.

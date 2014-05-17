# Concurrency #

## Threads ##
In concurrent programming there are two units of execution:

* **Processes** - has a self-contained execution environment. It has a private set of run-time resources including its *own memory space*. Processes can communicate with each other via *pipes and sockets*. 
* **Threads** - Provides an execution environment, but requires fewer resources than creating a new process. Threads exist within a process and share the process's resources, including memory and open files. 

### Java implementation ###
In Java you have the option to implement the `Runnable` interface (which overrides the `run` method). You then pass this to a new `Thread` like so:

```
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }
}
```

Alternatively you can subclass `Thread` itself directly. 

```
public class HelloThread extends Thread {
	@Override
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
    }
}
```

It is more common to use the first approach because it is more flexible.

### Interrupt ###
An **interrupt** is an indication to a thread that it should stop what it is doing and do something else. A thread sends an interrupt by invoking `interrupt` on the Thread object. 
The interrupted thread in Java must support its own interruption often this is by catching an `InterruptException`. Alternatively it can invoke `Thread.interrupted()`.


### Join ###
The **join** method allows a thread to wait for the completion of another. 

## Synchronisation ##
Threads communicate by sharing access to fields but it can introduce a concept called **thread contention** which occurs when 2+ threads try to access the same resource simultaneously and cause the Java runtime to execute 1+ threads more slowly. 

### Interference ### 
Threads can interfere with eachother meaning that some writes can be lost etc. 

### Memory Consistency ###
Memory consistency errors occur when different threads have inconsistent views of what should be the same data. In order to avoid this Java provides two basic idioms:

* **Syncrhonised methods** simply add the word `synchronised` to the method. When a synchronised object has interactions for 2+ threads one thread executes it and all others block until the first is done with the object.

```
public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}
```
* **Synchronised statements** - these must specify the object that provides the intrinsic lock. 

``` 
public void addName(String name) {
    synchronized(this) {
        lastName = name;
        nameCount++;
    }
    nameList.add(name);
}
```
   Alternatively to provide access to the same object for editing different fields we can explicitly define the locks:

```
public class MsLunch {
    private long c1 = 0;
    private long c2 = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void inc1() {
        synchronized(lock1) {
            c1++;
        }
    }

    public void inc2() {
        synchronized(lock2) {
            c2++;
        }
    }
}
```


## Deadlock, Starvation, Livelock ##

* **Deadlock** is a situation where two or more threads are blocked forever waiting on each other. 
* **Starvation** is a situation where a thread is unable to gain regular access to shared resources so cannot make progress. 
* **Livelock** happens when threads are too busy responding to each other to resume useful work. Therefore they are still active but not making any progress.

### Guarded Blocks ###
Instead of looping until a value is set, guarded blocks make use of `Object.wait` to suspend the current thread until a condition/special event holds. It wakes up by another event calling `notifyAll` on the object. It's best to do this in a wait, since `notifyAll` wakes all threads waiting, which means that the condition may not be true in every thread. See the example below:

```
public synchronized void guardedJoy() {
    // This guard only loops once for each special event,
    // which may not be the event we're waiting for.
    while(!joy) {
        try {
            wait();
        } catch (InterruptedException e) {}
    }
    System.out.println("Joy and efficiency have been achieved!");
}
```

However the `java.util.concurrent.locks` package provides a `Lock` object that is far better for use.

## Executors ##
Executors are separate thread management objects and encapsulate the creation and management. You can replace:

```
(new Thread(r)).start();
```
with

```
e.execute();
```

The ```ExecutorService```  interface supplements `execute` with a similar but more versatile `submit` method. `Callable` objects are accepted by submit which allow the task to return a value. The submit method returns a `Future` object which is used to retrieve the return value and to manage the status of the tasks. 

These executor implementations make use of *thread pools* consisting of *worker threads*. This minimises the overhead due to thread creation. 

## Consistency ##

## Coherence ##
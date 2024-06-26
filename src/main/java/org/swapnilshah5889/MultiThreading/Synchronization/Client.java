package org.swapnilshah5889.MultiThreading.Synchronization;

import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubctratorSynchronizedMethods.AdderV4;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubctratorSynchronizedMethods.CounterV4;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubctratorSynchronizedMethods.SubtractorV4;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorAtomicInteger.AdderV5;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorAtomicInteger.CounterV5;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorAtomicInteger.SubtractorV5;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorMutexLocks.AdderV2;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorMutexLocks.CounterV2;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorMutexLocks.SubtractorV2;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorSynchronized.AdderV3;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorSynchronized.CounterV3;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorSynchronized.SubtractorV3;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorWithObject.Adder;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorWithObject.Counter;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorWithObject.Subtractor;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    /*
    * Adder subtractor problem with shared object but no synchronization
    * This shows why synchronization is important as threads enter a race
    * condition and the common object is not updated as intended
    * */
    public static void adderSubtractorWithObject() {
        Counter counter = new Counter(0);
        Adder adder = new Adder(counter);
        Subtractor subtractor = new Subtractor(counter);

        Thread adderThread = new Thread(adder);
        Thread subThread = new Thread(subtractor);

        adderThread.start();
        subThread.start();

        try {
            adderThread.join();
            subThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Value of N will never be 0 even though we are adding and subtracting for the same amount of times
        System.out.println(counter.getN());
    }

    /*
    * Solution to race conditions and synchronization problems
    * Uses Lock class to lock and unlock critical section
    * and solve the issue of race condition between threads
    * */
    public static void adderSubtractorWithMutexLocks() {
        Lock lock = new ReentrantLock();

        CounterV2 counter = new CounterV2(0);
        AdderV2 adder = new AdderV2(counter, lock);
        SubtractorV2 subtractor = new SubtractorV2(counter, lock);

        Thread adderThread = new Thread(adder);
        Thread subThread = new Thread(subtractor);

        adderThread.start();
        subThread.start();

        try {
            adderThread.join();
            subThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getN());
    }

    /*
    * Solution to race condition and synchronization problems
    * Use synchronized block for critical section
    * */
    public static void adderSubtractorSynchronized() {
        CounterV3 counter = new CounterV3(0);
        AdderV3 adder = new AdderV3(counter);
        SubtractorV3 subtractor = new SubtractorV3(counter);

        Thread adderThread = new Thread(adder);
        Thread subThread = new Thread(subtractor);

        adderThread.start();
        subThread.start();

        try {
            adderThread.join();
            subThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getN());
    }

    /*
    * This solution implements counter class as a thread safe class
    * by making it's methods synchronized instead of the adder and subtractor classes
    * */
    public static void synchronizedCounter() {

        CounterV4 counter = new CounterV4(0);
        AdderV4 adder = new AdderV4(counter);
        SubtractorV4 subtractor = new SubtractorV4(counter);

        Thread adderThread = new Thread(adder);
        Thread subThread = new Thread(subtractor);

        adderThread.start();
        subThread.start();

        try {
            adderThread.join();
            subThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getN());
    }

    /*
     * This solution implements AtomicInteger inside the counter class
     * AtomicInteger are by default thread safe as they implement locks internally
     * */
    public static void atomicIntegerCounter() {

        AtomicInteger n = new AtomicInteger(0);
        CounterV5 counter = new CounterV5(n);
        AdderV5 adder = new AdderV5(counter);
        SubtractorV5 subtractor = new SubtractorV5(counter);

        Thread adderThread = new Thread(adder);
        Thread subThread = new Thread(subtractor);

        adderThread.start();
        subThread.start();

        try {
            adderThread.join();
            subThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getN());
    }



    public static void main(String[] args) {

        // Without synchronization
        //adderSubtractorWithObject();

        // Mutex locks
        // adderSubtractorWithMutexLocks();

        // Synchronized Keyword
        //adderSubtractorSynchronized();

        // Synchronized Counter object
        // synchronizedCounter();

        // Atomic Integer Counter
        atomicIntegerCounter();
    }

}

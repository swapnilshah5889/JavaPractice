package org.swapnilshah5889.MultiThreading.Synchronization;

import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorWithObject.Adder;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorWithObject.Counter;
import org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorWithObject.Subtractor;

public class Client {

    public static void main(String[] args) {
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

}

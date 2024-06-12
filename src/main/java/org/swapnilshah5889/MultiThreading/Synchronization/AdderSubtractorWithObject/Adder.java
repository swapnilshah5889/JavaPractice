package org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorWithObject;

public class Adder implements Runnable{

    Counter counter;

    public Adder(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0; i<1000000; i++ ) counter.n++;
    }

}

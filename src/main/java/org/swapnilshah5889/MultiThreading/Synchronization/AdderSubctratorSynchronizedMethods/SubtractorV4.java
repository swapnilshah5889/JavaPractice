package org.swapnilshah5889.MultiThreading.Synchronization.AdderSubctratorSynchronizedMethods;

public class SubtractorV4 implements Runnable {

    CounterV4 counter;

    public SubtractorV4(CounterV4 counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0; i<1000000; i++ )  counter.updateN(-1);
    }

}

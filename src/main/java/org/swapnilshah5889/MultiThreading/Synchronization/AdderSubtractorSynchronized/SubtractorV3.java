package org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorSynchronized;

import java.util.concurrent.locks.Lock;

public class SubtractorV3 implements Runnable {

    CounterV3 counter;

    public SubtractorV3(CounterV3 counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        for(int i=0; i<1000000; i++ ) {
            synchronized (counter) {
                counter.n--;
            }
        }
    }

}

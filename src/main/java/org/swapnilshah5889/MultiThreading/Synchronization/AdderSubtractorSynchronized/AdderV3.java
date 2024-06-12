package org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorSynchronized;

import java.util.concurrent.locks.Lock;

public class AdderV3 implements Runnable{

    CounterV3 counter;

    public AdderV3(CounterV3 counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        for(int i=0; i<1000000; i++ ) {
            // Create synchronized block using locking and unlocking
            synchronized (counter) {
                counter.n++;
            }
        }
    }

}

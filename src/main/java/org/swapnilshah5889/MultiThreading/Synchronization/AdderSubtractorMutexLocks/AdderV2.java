package org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorMutexLocks;

import java.util.concurrent.locks.Lock;

public class AdderV2 implements Runnable{

    CounterV2 counter;
    Lock lock;

    public AdderV2(CounterV2 counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {

        for(int i=0; i<1000000; i++ ) {
            // Create synchronized block using locking and unlocking
            lock.lock();
            counter.n++;
            lock.unlock();
        }
    }

}

package org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorMutexLocks;

import java.util.concurrent.locks.Lock;

public class SubtractorV2 implements Runnable {

    CounterV2 counter;
    Lock lock;

    public SubtractorV2(CounterV2 counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {

        for(int i=0; i<1000000; i++ ) {
            lock.lock();
            counter.n--;
            lock.unlock();
        }
    }

}

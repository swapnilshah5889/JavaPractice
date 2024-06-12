package org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorAtomicInteger;

public class SubtractorV5 implements Runnable {

    CounterV5 counter;

    public SubtractorV5(CounterV5 counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0; i<1000000; i++ )  {
            counter.updateN(-1);
        }
    }

}

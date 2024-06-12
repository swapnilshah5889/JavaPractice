package org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorAtomicInteger;

public class AdderV5 implements Runnable{

    CounterV5 counter;

    public AdderV5(CounterV5 counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0; i<1000000; i++ )  {
            counter.updateN(1);
        }
    }

}

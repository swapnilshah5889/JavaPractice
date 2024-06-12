package org.swapnilshah5889.MultiThreading.Synchronization.AdderSubtractorAtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterV5 {

    private AtomicInteger n;

    public CounterV5(AtomicInteger n) {
        this.n = n;
    }

    public int getN() {
        return n.get();
    }

    public void updateN(int i) {
        n.getAndAdd(i);
    }
}

package org.swapnilshah5889.MultiThreading.Synchronization.AdderSubctratorSynchronizedMethods;

public class CounterV4 {

    private int n;

    public CounterV4(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    synchronized public void updateN(int i) {
        this.n += i;
    }

}

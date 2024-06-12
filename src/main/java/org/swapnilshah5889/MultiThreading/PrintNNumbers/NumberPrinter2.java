package org.swapnilshah5889.MultiThreading.PrintNNumbers;

public class NumberPrinter2 implements Runnable{

    private int n;

    NumberPrinter2(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Printing "+n+" from thread "+Thread.currentThread().getName());
        n++;
    }
}

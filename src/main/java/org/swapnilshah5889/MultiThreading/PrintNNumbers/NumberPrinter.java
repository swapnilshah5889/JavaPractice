package org.swapnilshah5889.MultiThreading.PrintNNumbers;

public class NumberPrinter implements Runnable{

    private int n;

    NumberPrinter(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Printing "+n+" from thread "+Thread.currentThread().getName());
    }
}

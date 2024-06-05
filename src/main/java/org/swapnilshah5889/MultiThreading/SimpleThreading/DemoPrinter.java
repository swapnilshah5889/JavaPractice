package org.swapnilshah5889.MultiThreading.SimpleThreading;

public class DemoPrinter implements Runnable {

    public void doSoemthing() {
        System.out.println("Printing from a doSomething method on thread "+Thread.currentThread().getName());
    }
    @Override
    public void run() {
        System.out.println("Printing from thread "+Thread.currentThread().getName());
        doSoemthing();
    }

}

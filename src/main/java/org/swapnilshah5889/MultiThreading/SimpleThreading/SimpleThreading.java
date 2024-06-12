package org.swapnilshah5889.MultiThreading.SimpleThreading;

public class SimpleThreading {

    public static void main(String[] args) {

        // Print from the main thread
        System.out.println("Currently in "+Thread.currentThread().getName()+" Thread");

        // Object of DemoPrinter
        DemoPrinter printer = new DemoPrinter();

        // If we call printer method directly from the main thread
        // it get's executed in the main thread and no new thread is created
        printer.run();

        // Create a new thread
        Thread t = new Thread(printer);
        // DemoPrinter now will run on different thread
        t.start();

        // Second print statement from the main thread to the print statements' order is not predictable
        System.out.println("Hello 2 from "+Thread.currentThread().getName()+" Thread");

    }

}

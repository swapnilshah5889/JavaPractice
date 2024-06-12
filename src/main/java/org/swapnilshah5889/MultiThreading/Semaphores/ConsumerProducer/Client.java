package org.swapnilshah5889.MultiThreading.Semaphores.ConsumerProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {

    public static void main(String[] args) {

        // Using synchronized queue to avoid race conditions
        Queue<Object>  queue = new ConcurrentLinkedQueue<>();

        // Creating producer semaphore with 5 locks
        Semaphore ps = new Semaphore(5);
        Semaphore cs = new Semaphore(0);

        // Add 10 producers
        List<Producer> producers = new ArrayList<>();
        for(int i=0; i<10; i++) {
            producers.add(new Producer(queue, ps, cs));
            Thread tp = new Thread(producers.get(producers.size()-1));
            tp.start();
        }

        // Add 10000 customers
        List<Consumer> customers = new ArrayList<>();
        for(int i=0; i<10000; i++) {
            customers.add(new Consumer(queue, ps, cs));
            Thread tc = new Thread(customers.get(customers.size()-1));
            tc.start();
        }



    }

}

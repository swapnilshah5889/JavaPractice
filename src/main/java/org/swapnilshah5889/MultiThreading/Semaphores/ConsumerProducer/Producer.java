package org.swapnilshah5889.MultiThreading.Semaphores.ConsumerProducer;

import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    Queue<Object> queue;
    Semaphore ps;
    Semaphore cs;
    int total;

    public Producer(Queue<Object> queue, Semaphore ps, Semaphore cs) {
        this.queue = queue;
        this.ps = ps;
        this.cs = cs;
        this.total = 0;
    }

    @Override
    public void run() {
        while(true) {
            try {
                ps.acquire();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            queue.add(new Object());
            total++;
            System.out.println("New TShirt added by "+Thread.currentThread().getName()+"! Now we have "+queue.size()
                    +" T-Shirt(s)\n"+"Total shirts produced by this producer: "+total+"\n");
            cs.release();

//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}

package org.swapnilshah5889.MultiThreading.Semaphores.ConsumerProducer;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    Queue<Object> queue;
    Semaphore ps;
    Semaphore cs;
    int total;

    public Consumer(Queue<Object> queue, Semaphore ps, Semaphore cs) {
        this.queue = queue;
        this.ps = ps;
        this.cs = cs;
        this.total = 0;
    }

    @Override
    public void run() {

        while(true) {
            try {
                cs.acquire();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            queue.remove();
            total++;
            System.out.println(Thread.currentThread().getName()+ " bought one T-Shirt! Now we have "+queue.size()+
                    " T-Shirt(s)\n"+"Total Tshirts bought by this consumer: "+total+"\n");
            ps.release();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }


    }
}

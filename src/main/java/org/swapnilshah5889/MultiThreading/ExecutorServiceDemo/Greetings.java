package org.swapnilshah5889.MultiThreading.ExecutorServiceDemo;

import java.util.Random;
import java.util.concurrent.Callable;

public class Greetings implements Callable<String> {

    private Random random;

    public Greetings(Random random) {
        this.random = random;
    }

    @Override
    public String call() throws Exception {
        int index = random.nextInt(10);

        switch (index) {
            case 1:
                return "Hello "+Thread.currentThread().getName();
            case 2:
                return "Namaste "+Thread.currentThread().getName();
            case 3:
                return "Kem Cho "+Thread.currentThread().getName();
            case 4:
                return "Hola "+Thread.currentThread().getName();
            case 5:
                return "Namaskar "+Thread.currentThread().getName();
            default:
                return "No Greeting "+Thread.currentThread().getName();

        }

    }
}

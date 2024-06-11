package org.swapnilshah5889.MultiThreading.ExecutorServiceDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {


    public static void ExecutorServiceDemo() {
        Random random = new Random();

        // Create Callable Task
        Greetings gg = new Greetings(random);

        // Create ExecutorService object with 10 fixed threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // List of Future objects with value string
        List<Future<String>> listOfPromises = new ArrayList<>();

        // Submit 100 tasks to the executor service
        for(int i=0; i<99; i++) {
            // Capture the return value of the callable task as a Future object
            Future<String> promiseOfGreeting = executorService.submit(gg);
            // Store the future object
            listOfPromises.add(promiseOfGreeting);
        }

        // Print the value of all the future objects
        for(Future<String> greetingPromise : listOfPromises) {
            try{
                String greeting = greetingPromise.get();
                System.out.println(greeting);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        // Demo to show how executor service class works along with Callable Interface and  Future Object
        ExecutorServiceDemo();
    }

}

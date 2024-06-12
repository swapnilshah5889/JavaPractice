package org.swapnilshah5889.MultiThreading.PrintNNumbers;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void version1() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            NumberPrinter printer = new NumberPrinter(i);
            Thread t = new Thread(printer);
            t.start();
        }

        System.out.println("Bye from main");
    }


    public static void version2() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();
        // Common object between all threads
        NumberPrinter2 printer = new NumberPrinter2(1);

        // Each thread prints the current value and then increments it in the run method
        for(int i=1; i<=n; i++) {
            Thread t = new Thread(printer);
            t.start();
        }

        System.out.println("Bye from main");


    }

    public static void version3() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        // Create executor service object to manage threading
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Assign the runnable class object to the executor service
        for(int i=1; i<=n; i++) {
            NumberPrinter2 printer = new NumberPrinter2(i);
            executorService.execute(printer);
        }

        System.out.println("Bye from main");

    }

    public static void main(String[] args) {

        // Print all N numbers using different threads
        // In un-synchronized manner
        // version1();

        // Sharing data between all threads
        // version2();

        // Using executor service
        version3();

    }
}

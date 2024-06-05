package org.swapnilshah5889.MultiThreading.PrintNNumbers;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
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
}

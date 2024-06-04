package org.swapnilshah5889.ExceptionHandling;

import java.util.Scanner;

public class SimpleExceptions {

    public void divide() {
        try {

            Scanner sc = new Scanner(System.in);
            // Will throw an exception if input is not integer
            int x = sc.nextInt();
            int y = sc.nextInt();

            // Will throw an error if value of y is 0
            int ans = x/y;

            // The finally block will not execute if we exit the system
            // System.exit(0);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        // Finally block will not execute if we explicitly exit the system
        finally {
            // This executes even if we catch the exception
            System.out.println("Inside finally");
        }

        System.out.println("After finally block");
    }
}

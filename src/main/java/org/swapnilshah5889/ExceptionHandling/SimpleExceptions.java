package org.swapnilshah5889.ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
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

    public void divideByZero() {
        try {
            int b = 0;
            int a = 5;
            int c = a/b;
        }
        catch (Exception e) {
            System.out.println("Caught exception in divideByZero Method");
        }
    }

    public void multipleExceptions() {
        System.out.println("Inside Multiple Exceptions");
        try {

            // Call to a function that throws an error
            // Rest of the code will continue as the error has been caught in this method itself
            divideByZero();

            Scanner sc = new Scanner(System.in);
            // Will throw an exception if input is not integer
            System.out.println("Enter value of x: ");
            int x = sc.nextInt();
            System.out.println("Enter 0 to get arithmetic exception, string to get input mismatch exception");
            System.out.println("Enter value of y:");
            int y = sc.nextInt();

            // Will throw an error if value of y is 0
            int ans = x/y;

        }
        catch (InputMismatchException e) {
            System.out.println("Caught input mismatch exception");
        }
        catch (NullPointerException e) {
            System.out.println("Caught null pointer exception");
        }
        catch (ArithmeticException e) {
            System.out.println("Caught arithmetic exception");
        }
        catch (Exception e) {
            // Any unhandled exception
            System.out.println("Caught unhandled exception");
            System.out.println(e);
        }
        // Finally block will not execute if we explicitly exit the system
        finally {
            System.out.println("Inside finally");
        }
    }

    public void fileReadMethod() throws FileNotFoundException, IOException {
        File file = new File("abc.txt");
        // throws FileNotFoundException
        FileReader reader = new FileReader(file);
        // throws IOException
        reader.read();
    }

    public void handlingThrowsMethod() {

        try {
            fileReadMethod();
        }
        catch (FileNotFoundException e) {
            System.out.println("Caught file not found exception");
        }
        catch (IOException e) {
            System.out.println("Caught IO Exception");
        }

    }
}

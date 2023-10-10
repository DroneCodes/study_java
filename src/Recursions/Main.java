package Recursions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
            Recursion:

            1. A function that calls itself.
            2. A function that calls itself directly or indirectly.

            Example:

            void message(int n) {
                if (n == 5) {
                    return; // go back to the previous method call
                } // this statement gives us a break point to stop the recursion.
                System.out.println(n);
                message(n + 1); // this is the part of the code where recursion occurs
            }

            // Why do we need Recursion?


         */

        message(1);
        printName();
    }

    static void message(int n) {

        if (n == 5) {
            return;
        }
        System.out.println(n);
        message(n + 1);
    }

    static void printName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Hello " + name);

        printName();
    }

}

package Recursions;

import java.util.Scanner;

public class Main {

     /*
            Recursion:

            1. A function that calls itself.
            2. A function that calls itself directly or indirectly.

            // How do you know when to use recursion

            1. When the problem can be broken down into smaller sub-problems.

            Example:

            void message(int n) {
                if (n == 5) {
                    return; // go back to the previous method call
                } // this statement gives us a break point to stop the recursion.
                System.out.println(n);
                message(n + 1); // this is the part of the code where recursion occurs
            }

            // Why do we need Recursion?

            1. Recursion provides a clean and simple way to write code.
            2. Recursion provides a way to break complicated problems down into simple problems which are easier to solve.
            3. Recursion is a concept that is used in many areas of computer science, not just in programming.
            4. You can convert a recursive solution to an iterative solution, and vice versa.
            5. Space complexity is not constant because of recursive calls.


            // Tail Recursion:

            1. A recursive function is tail recursive when the recursive call is the last thing executed by the function.


            // How to understand and approach a recursive problem

            1. Understand the problem
            2. Identify if you can break the problem into smaller sub-problems
            3. Write the recursive solution if needed
            4. Draw the recursion tree
            5. About the tree:
                - see the flow of functions, how they are getting in stack
                - Identify and focus on the left tree calls and the right tree calls
                - Draw the tree and pointers using pen and pepper
                - Use a debugger to see the flow of the program
                - See how the values and what type of values are returned at each step
                - See where the function call would come out of the stack


            // Variables in Recursion:

                a - variable that is passed as an argument to the function
                b - variable that is declared inside the function
                c - variable that is returned by the function


            // Example of Recursion:

            public static void main(String[] args) {
                message(1);
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
         */

    public static void main(String[] args) {
        message(0);
    }
    static void message ( int n){
        if (n == 5) {
            return;
        }
        System.out.println(n);
        message(n + 1);
    }

    static void printName () {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Hello " + name);

        printName();
    }
}

package Recursions.leetcodeQuestions;

import java.util.HashMap;
import java.util.Map;

public class FibonnaciNumber {

    // Create a map for memoization to store previously computed Fibonacci numbers
    private static Map<Integer, Integer> memoization = new HashMap<>();
    public static void main(String[] args) {

         /*
             // Question 1

             // Fibonacci Series using Recursion

             FibonacciNumbers = F(n-1) + F(n-2)

             F(n -1) can be broken into smaller bits, same as F(n - 2)

             F(n - 1) = F(n - 2) + F(n - 3)
             F(n - 2) = F(n - 3) + F(n - 4)

             similarly all these can be broken down into smaller bits until the value of n = 0:
             there we would specify a base case to stop the recursion.

             If any solution has been provided we use that as the base number, in our case here we use the f(0) term as the base case.

         */

        System.out.println(fibonacciNumbers(3));
        System.out.println(fibonacci(6));

    }

    static int fibonacciNumbers(int n) {
        // base case

        if (n < 2){
            return n;
        }
        return fibonacciNumbers(n - 1) + fibonacciNumbers(n - 2);
    }

    public static int fibonacci(int n) {
        // Calculating with memoization
        // Base cases: F(0) = 0 and F(1) = 1
        if (n < 2) {
            return n;
        }

        // Check if the result for 'n' has already been calculated and stored in memoization
        if (memoization.containsKey(n)) {
            // If so, return the stored result to avoid redundant calculation
            return memoization.get(n);
        }

        // Calculate the Fibonacci number for 'n' by recursively summing the two previous numbers
        int result = fibonacci(n - 1) + fibonacci(n - 2);

        // Store the result in the memoization map for future use
        memoization.put(n, result);

        // Return the calculated Fibonacci number
        return result;
    }
}



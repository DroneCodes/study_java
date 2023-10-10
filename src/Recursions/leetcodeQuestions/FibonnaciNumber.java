package Recursions.leetcodeQuestions;

public class FibonnaciNumber {

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

        System.out.println(fibonacciNumbers(3)
        );
    }

    static int fibonacciNumbers(int n) {
        // base case

        if (n < 2){
            return n;
        }
        return fibonacciNumbers(n - 1) + fibonacciNumbers(n - 2);
    }


}

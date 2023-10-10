package Recursions;

public class Main {

    public static void main(String[] args) {

        /*
            Recursion:

            1. A method that calls itself.
            2. A method that calls itself directly or indirectly.
         */

        message(1);
    }

    static  void message(int n) {
        System.out.println(n);
        message(n + 1);
    }

}

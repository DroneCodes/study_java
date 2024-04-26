package Recursions.leetcodeQuestions;

import java.util.Scanner;

import static java.lang.Math.ceil;

public class CoinBalance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of coins: ");
        int n = scanner.nextInt();
        int answer = weigh(n);
        System.out.println("The number of weighing required are: " + answer);

    }

    static int weigh(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return 1 + weigh((int) ceil(n/2));
        }
    }
}



package Stacks.questions;

import java.util.Stack;

public class IsPalindrome {
    public int isPalindrome(String inputStr) {
        int i = 0;
        int j = inputStr.length() - 1;
        while (i < j && inputStr.charAt(i) == inputStr.charAt(j)) {
            i++;
            j--;
        }
        if (i < j) {
            System.out.println("Not a palindrome");
            return 0;
        } else {
            System.out.println("Palindrome");
            return 1;
        }
    }

    public int isPalindromeUsingStack(String inputStr) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int j = inputStr.length() - 1;
        while (i < j) {
            stack.push(inputStr.charAt(i));
            i++;
        }
        i++;
        while (i < inputStr.length()) {
            if (inputStr.charAt(i) != stack.pop()) {
                System.out.println("Not a palindrome");
                return 0;
            }
            i++;
        }
        System.out.println("Palindrome");
        return 1;
    }
}

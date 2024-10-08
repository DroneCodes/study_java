package Strings.leetcodeQuestions;

public class MinimumNumberofSwapsToMakeBalanced {
    public int minSwaps(String s) {
        int balance = 0;
        int swaps = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                swaps++;
                balance = 1;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        MinimumNumberofSwapsToMakeBalanced solution = new MinimumNumberofSwapsToMakeBalanced();

        // Test case 1
        String s1 = "][][";
        System.out.println(solution.minSwaps(s1)); // Output: 1

        // Test case 2
        String s2 = "]]][[[";
        System.out.println(solution.minSwaps(s2)); // Output: 2

        // Test case 3
        String s3 = "[]";
        System.out.println(solution.minSwaps(s3)); // Output: 0
    }
}
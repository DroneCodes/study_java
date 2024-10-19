package Recursions.leetcodeQuestions;

public class FindKthBitInNthBinaryString {
    public char findKthBit(int n, int k) {
        // Base case
        if (n == 1) {
            return '0';
        }

        int length = (1 << n) - 1; // Length of Sn is 2^n - 1
        int mid = length / 2 + 1; // Middle point

        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            char bit = findKthBit(n - 1, length - k + 1);
            return bit == '0' ? '1' : '0';
        }
    }

    public static void main(String[] args) {
        FindKthBitInNthBinaryString solution = new FindKthBitInNthBinaryString();

        // Test case 1
        int n1 = 3, k1 = 1;
        System.out.println(solution.findKthBit(n1, k1)); // Output: "0"

        // Test case 2
        int n2 = 4, k2 = 11;
        System.out.println(solution.findKthBit(n2, k2)); // Output: "1"
    }
}
package DynamicProgramming;

public class NthTribonacciNumber {

    /**
     * Calculates the n-th Tribonacci number.
     *
     * The Tribonacci sequence is a generalization of the Fibonacci sequence where each term is the sum of the three preceding ones.
     * The sequence starts with 0, 1, 1.
     *
     * @param n The index of the Tribonacci number to calculate.
     * @return The n-th Tribonacci number.
     */
    public int tribonacci(int n) {
        int ans[] = new int[n + 3];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 1;
        int i = 3;
        while (i <= n) {
            ans[i] = ans[i - 1] + ans[i - 2] + ans[i - 3];
            i++;
        }
        return ans[n];
    }

    public static void main(String[] args) {
        NthTribonacciNumber obj = new NthTribonacciNumber();
        System.out.println(obj.tribonacci(25));
    }
}
package Array.leetcodeQuestions;

import java.util.Arrays;

public class MinimizedMaximumProductsDistributed {

    /**
     * Finds the minimum possible maximum number of products given to any store.
     *
     * @param n the number of stores
     * @param quantities an array where quantities[i] represents the number of products of the ith product type
     * @return the minimum possible maximum number of products given to any store
     */
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = Arrays.stream(quantities).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(quantities, n, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Checks if it is possible to distribute the products such that no store gets more than maxProducts.
     *
     * @param quantities an array where quantities[i] represents the number of products of the ith product type
     * @param n the number of stores
     * @param maxProducts the maximum number of products that can be given to any store
     * @return true if it is possible to distribute the products within the given constraints, false otherwise
     */
    private boolean canDistribute(int[] quantities, int n, int maxProducts) {
        int requiredStores = 0;
        for (int quantity : quantities) {
            requiredStores += (quantity + maxProducts - 1) / maxProducts;
        }
        return requiredStores <= n;
    }

    public static void main(String[] args) {
        MinimizedMaximumProductsDistributed solution = new MinimizedMaximumProductsDistributed();

        int n1 = 6;
        int[] quantities1 = {11, 6};
        System.out.println(solution.minimizedMaximum(n1, quantities1)); // Output: 3

        int n2 = 7;
        int[] quantities2 = {15, 10, 10};
        System.out.println(solution.minimizedMaximum(n2, quantities2)); // Output: 5

        int n3 = 1;
        int[] quantities3 = {100000};
        System.out.println(solution.minimizedMaximum(n3, quantities3)); // Output: 100000
    }
}
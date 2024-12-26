package Array.leetcodeQuestions;

public class TargetSum {

    /**
     * Solution: Brute Force
     * <p>
     * Intuition
     * <p>
     * Start by thinking about how we would manually solve this problem. We would consider each number and decide whether to add it or subtract it. This decision-making process can be modeled using recursion.
     * <p>
     * We start by defining a recursive function that takes the current index in the list, the current sum of the expression, and the target. For each number, we make two recursive calls: one where we add the number and one where we subtract it.
     * <p>
     * When we reach the end of the list (i.e., all numbers have been considered), we check if the current sum equals the target. If it does, we increment a counter that tracks the number of valid expressions for that route. We repeat this for every route and find the total number of ways.
     * <p>
     * While this works for small inputs, it becomes impractical for larger lists due to its exponential time complexity (2^n)
     * <p>
     * Algorithm
     * <p>
     * Initialize totalWays to 0 to track the number of ways to reach the target sum.
     * <p>
     * Call calculateWays with the initial parameters: nums, currentIndex = 0, currentSum = 0, target, to start the recursive process.
     * <p>
     * In the calculateWays function:
     * <p>
     * If currentIndex equals the length of nums:
     * <p>
     * Check if currentSum matches target:
     * <p>
     * If yes, increment totalWays by 1 (a valid way to reach the target sum).
     * <p>
     * Otherwise:
     * <p>
     * Include the number at currentIndex with a positive sign:
     * <p>
     * Recursively call calculateWays with currentIndex + 1 and currentSum + nums[currentIndex].
     * <p>
     * Include the current number at currentIndex with a negative sign:
     * <p>
     * Recursively call calculateWays with currentIndex + 1 and currentSum - nums[currentIndex].
     * <p>
     * Return totalWays after all recursive calls, representing the total number of ways to assign signs to reach the target sum.
     * <p>
     * <p>
     * Complexity Analysis
     * <p>
     * Let n be the size of the input array nums.
     * <p>
     * Time complexity: O(2^n)
     * <p>
     * The function calculateWays is a recursive function that branches out into two recursive calls at each step. This is because each element in the array can either be added or subtracted, leading to 2 choices for each of the n elements.
     * <p>
     * This results in a binary tree of recursive calls, where each level of the tree corresponds to a position in the array nums. Since there are n elements in the array, the maximum depth of the recursion tree is n. Therefore, the total number of recursive calls is 2^n
     * , leading to a time complexity of O(2^n).
     * <p>
     * Space complexity: O(n)
     * <p>
     * The space complexity is determined by the depth of the recursion stack. In the worst case, the recursion stack can go as deep as n levels (one level for each element in the array). Therefore, the space complexity is O(n).
     */

    int totalWays = 0;

    public int findTargetSumWays(int[] nums, int target) {
        calculateWays(nums, 0, 0, target);
        return totalWays;
    }

    private void calculateWays(int[] nums, int currentIndex, int currentSum, int target) {
        if (currentIndex == nums.length) {
            if (currentSum == target) {
                totalWays++;
            }
        } else {
            calculateWays(
                    nums,
                    currentIndex + 1,
                    currentSum + nums[currentIndex],
                    target
            );
            calculateWays(
                    nums,
                    currentIndex + 1,
                    currentSum - nums[currentIndex],
                    target
            );
        }
    }

}

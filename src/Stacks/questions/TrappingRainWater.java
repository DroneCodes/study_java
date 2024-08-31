package Stacks.questions;

/**
 * This class provides a method to calculate the amount of water that can be trapped
 * after raining given an elevation map.
 */
public class TrappingRainWater {

    /**
     * Computes the amount of water that can be trapped after raining.
     *
     * @param height an array representing the elevation map where the width of each bar is 1
     * @return the total amount of trapped water
     */
    public int trap(int[] height) {
        // If the height array is null or empty, no water can be trapped
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];  // Array to store the maximum height to the left of each bar
        int[] rightMax = new int[n]; // Array to store the maximum height to the right of each bar

        // Fill leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(solution.trap(height1)); // Output: 6
        System.out.println(solution.trap(height2)); // Output: 9
    }
}
package Array.leetcodeQuestions;

public class MinimumLimitOfBallsInABag {

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = getMax(nums);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private boolean canDivide(int[] nums, int maxOperations, int penalty) {
        int operations = 0;
        for (int num : nums) {
            if (num > penalty) {
                operations += (num - 1) / penalty;
            }
        }
        return operations <= maxOperations;
    }

    public static void main(String[] args) {
        MinimumLimitOfBallsInABag solution = new MinimumLimitOfBallsInABag();

        int[] nums1 = {9};
        int maxOperations1 = 2;
        System.out.println("Output (Test case 1): " + solution.minimumSize(nums1, maxOperations1)); // Expected output: 3

        int[] nums2 = {2, 4, 8, 2};
        int maxOperations2 = 4;
        System.out.println("Output (Test case 2): " + solution.minimumSize(nums2, maxOperations2)); // Expected output: 2
    }
}
package Arrays.leetcodeQuestions;

public class MonotonicArray {

    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] > nums[i+1]){
                isIncreasing = false;
            }
            if (nums[i] < nums[i+1]){
                isDecreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }
}

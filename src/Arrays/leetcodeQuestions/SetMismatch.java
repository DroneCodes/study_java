package Arrays.leetcodeQuestions;


/*
The findErrorNums method is designed to solve a problem where you're given an array nums containing n numbers from 1 to n inclusive, but one of the numbers in the range 1 to n is missing and another number appears twice. The method returns an array where the first element is the number that appears twice and the second element is the missing number.
Here's a step-by-step explanation:
An array arr of size nums.length + 1 is created. This array is used to count the occurrences of each number in nums. The size is nums.length + 1 because the numbers in nums start from 1, not 0.
An array res of size 2 is created. This array is used to store the result, where res[0] is the number that appears twice and res[1] is the missing number.
The first for loop iterates over the nums array. For each number nums[i], it increments the count in arr[nums[i]]. After this loop, arr[i] will contain the count of i in nums.
The second for loop iterates over the arr array starting from 1. If arr[i] is 2, it means the number i appears twice in nums, so i is assigned to res[0]. If arr[i] is 0, it means the number i is missing in nums, so i is assigned to res[1].
Finally, the method returns the res array.
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length + 1];
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 2)
                res[0] = i;
            if (arr[i] == 0)
                res[1] = i;
        }
        return res;
    }
}

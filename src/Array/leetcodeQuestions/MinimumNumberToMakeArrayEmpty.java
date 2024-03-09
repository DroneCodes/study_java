package Array.leetcodeQuestions;

import java.util.Arrays;

public class MinimumNumberToMakeArrayEmpty {

    /*
    To solve this problem, we can use a priority queue and a hash map. The hash map will store the frequency of each number in the array, and the priority queue will store the numbers in descending order of their frequencies.  Here are the steps in detail:

    Initialize a hash map to store the frequency of each number in the array.

    Iterate over the array and for each number, increment its frequency in the hash map.

    Initialize a priority queue to store the numbers in descending order of their frequencies.

    Iterate over the hash map and for each entry, add the frequency of the number to the priority queue.

    Initialize a variable operations to store the total number of operations.

    While the priority queue is not empty, remove the top element from the priority queue. If the top element is greater than or equal to 3, decrement it by 3 and add it back to the priority queue. Increment operations by 1. If the top element is equal to 2, increment operations by 1.

    If the priority queue is empty, return operations. Otherwise, return -1.
     */

    public int minOperations(int[] nums) {
        Arrays.sort(nums);

        int res = 0;
        int s = 0;

        while(s < nums.length) {
            int e = s;
            while(e < nums.length && nums[s] == nums[e]) {
                e++;
            }
            int count = e - s;
            if(count == 1) {
                return -1;
            }
            res += count/3;
            if(count % 3 != 0) {
                res++;
            }
            s = e;
        }
        return res;
    }
}

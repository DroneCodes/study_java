package Recursions.leetcodeQuestions;

public class BinarySearch {

    /*
        Binary Search With Recursion:

        F(n) = F(n/2) + O(1)


        - Draw the tree and pointers using pen and pepper
        - Add an array and a target integer to the argument of the function
        - [                         ]
                        |        - Divide the array into two halves and check if the target is the middle index

        - If the target is the middle index, return the index and close the stack

        - If the array is not the middle index, check if the target is greater than the middle index

        - If the target is greater than the middle index, call the function again with the right half of the array
           - Here Recursion is used, because the right half of the array would also be Divided into two halves and the function calls itself again


        - If the target is less than the middle index, call the function again with the left half of the array
            - Here Recursion is used, because the left half of the array would also be Divided into two halves and the function calls itself again


        - If the target is not found in the array, return -1


        - Types of Recurrence Relations:
            - Linear Recurrence Relation - (Fibonacci)
            - Divide and Conquer Recurrence Relation - (Binary Search): This id because the answer is divided by a factor
     */

    public static void main(String[] args) {

    }
}


class Solution {

    /**
     * Performs binary search on a sorted array to find the target value.
     *
     * @param nums the sorted array of integers
     * @param target the integer value to search for
     * @return the index of the target if found, otherwise -1
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            if (nums[mid] == target) {
                return mid; // Target found, return its index
            } else if (nums[mid] < target) {
                left = mid + 1; // Adjust the left bound to search the right subarray
            } else {
                right = mid - 1; // Adjust the right bound to search the left subarray
            }
        }

        return -1; // Target not found in the array
    }

}
package Array.leetcodeQuestions;

import java.util.Arrays;

/**
 * This class is used to find the majority element in an array.
 * The majority element is the element that appears more than n/2 times in the array,
 * where n is the size of the array.
 */
public class MajorityElement {

    /**
     * The main method which initiates the execution of the program.
     * @param args Unused.
     */
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 3, 4, 3, 5, 7};
        // Print the majority element of the array
        System.out.println(majorityElement(arr));
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.printMajority(arr);
    }

    /**
     * This method is used to find the majority element in an array.
     * It uses the Boyer-Moore Voting Algorithm.
     * @param nums This is the array in which the majority element is to be found.
     * @return int This returns the majority element in the array.
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }


    private int findMajority(int[] arr) {
        int count = 0;
        int major = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                major = arr[i];
                count = count + 1;
            } else if (arr[i] == major) {
                count = count + 1;
            } else {
                count = count - 1;
            }
        }
        return major;
    }

    // check if the number returned by findMajority is the majority element and greater than n/2

    private boolean isMajority(int[] arr, int major) {
        int count = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == major) {
                count = count + 1;
            }
        }
        return count > size / 2 ? true : false;
    }

    private void printMajority(int[] arr) {
        int major = findMajority(arr);
        if (isMajority(arr, major)) {
            System.out.println("The majority element is: " + major);
        } else {
            System.out.println("There is no majority element in the array.");
        }
    }
}
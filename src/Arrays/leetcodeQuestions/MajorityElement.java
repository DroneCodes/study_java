package Arrays.leetcodeQuestions;

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
        int[] arr = {3, 2, 3};
        // Print the majority element of the array
        System.out.println(majorityElement(arr));
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
}
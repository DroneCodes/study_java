package Array.leetcodeQuestions;

/**
 * This class provides a method to solve the problem of finding the product of all elements in an array except for the current element.
 * The method runs in O(n) time complexity and does not use the division operation.
 */
public class ProductOfArrayExceptSelf {

    /**
     * This method calculates the product of all elements in the array except for the current element.
     * It first calculates the product of all elements to the left of the current element, then calculates the product of all elements to the right of the current element, and multiplies the two.
     *
     * @param nums The input array of integers.
     * @return An array of integers where each element is the product of all elements in the input array except for the current element.
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        // Calculate left product for each element
        int leftProduct = 1;
        for (int i = 0; i < length; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Calculate right product for each element and multiply it with left product
        int rightProduct = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
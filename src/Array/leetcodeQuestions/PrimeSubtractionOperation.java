package Array.leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class PrimeSubtractionOperation {

    /**
     * Generates a list of prime numbers up to a given limit using the Sieve of Eratosthenes algorithm.
     *
     * @param limit the upper limit for generating prime numbers
     * @return a list of prime numbers up to the given limit
     */
    private static List<Integer> generatePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1]; // Array to mark prime numbers
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true; // Assume all numbers are prime initially
        }
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false; // Mark multiples of i as non-prime
                }
            }
        }
        List<Integer> primes = new ArrayList<>(); // List to store prime numbers
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i); // Add prime numbers to the list
            }
        }
        return primes; // Return the list of prime numbers
    }

    /**
     * Determines if the given array can be made strictly increasing by subtracting prime numbers.
     *
     * @param nums the input array of integers
     * @return true if the array can be made strictly increasing, false otherwise
     */
    public static boolean canBeMadeStrictlyIncreasing(int[] nums) {
        List<Integer> primes = generatePrimes(1000); // Generate prime numbers up to 1000
        int n = nums.length; // Length of the input array

        for (int i = n - 2; i >= 0; i--) { // Iterate from the second last element to the first
            if (nums[i] >= nums[i + 1]) { // Check if the current element is not less than the next element
                boolean found = false; // Flag to check if a valid prime is found
                for (int prime : primes) {
                    if (prime < nums[i] && nums[i] - prime < nums[i + 1]) { // Check if subtracting the prime makes the array strictly increasing
                        nums[i] -= prime; // Subtract the prime from the current element
                        found = true; // Set the flag to true
                        break; // Break the loop as we found a valid prime
                    }
                }
                if (!found) {
                    return false; // Return false if no valid prime is found
                }
            }
        }
        return true; // Return true if the array can be made strictly increasing
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 6, 10};
        int[] nums2 = {6, 8, 11, 12};
        int[] nums3 = {5, 8, 3};

        System.out.println(canBeMadeStrictlyIncreasing(nums1)); // Output: true
        System.out.println(canBeMadeStrictlyIncreasing(nums2)); // Output: true
        System.out.println(canBeMadeStrictlyIncreasing(nums3)); // Output: false
    }
}
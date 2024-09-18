package Array.leetcodeQuestions;

/**
 * The `RichestCustomerWealth` class provides a method to calculate the maximum wealth among all customers.
 * Each customer's wealth is represented by an array of integers, where each integer represents the wealth in a particular bank account.
 * The method iterates through each customer's accounts, sums the wealth, and keeps track of the maximum wealth encountered.
 */
public class RichestCustomerWealth {

    /**
     * Calculates the maximum wealth among all customers.
     *
     * The method works as follows:
     * 1. Initializes a variable `maxWealth` to store the maximum wealth found, starting with 0.
     * 2. Iterates through each customer's accounts (each row in the `accounts` matrix).
     * 3. For each customer, sums the wealth in all their accounts.
     * 4. Compares the current customer's total wealth with `maxWealth` and updates `maxWealth` if the current wealth is greater.
     * 5. Returns the maximum wealth found.
     *
     * @param accounts A 2D array where each row represents a customer's accounts and each element in the row represents the wealth in a particular account.
     * @return The maximum wealth among all customers.
     */
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0; // Initialize the maximum wealth to 0

        // Iterate through each customer's accounts
        for (int[] account : accounts) {
            int currentWealth = 0; // Initialize the current customer's wealth to 0

            // Sum the wealth in all accounts for the current customer
            for (int wealth : account) {
                currentWealth += wealth;
            }

            // Update maxWealth if the current customer's wealth is greater
            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }

        return maxWealth; // Return the maximum wealth found
    }
}
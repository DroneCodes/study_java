package leetcodeQuestions;


/*

     To solve this problem in Java, you can follow these steps:

        1. Start from the last digit of both binary strings (the rightmost digit).
        2. Add the corresponding digits from both strings along with the carry from the previous step.
        3. Calculate the sum, update the carry, and append the result to the output string.
        4. Move to the next digit, and repeat the process until you've processed all digits in both strings.
        5. After processing all digits, if there is still a carry, append it to the output string.
        6. Reverse the output string to get the final result.


        // Extensive explanation:


        - We start by initializing variables for carry and the result string. We also initialize two pointers i and j to the rightmost positions of strings a and b, respectively.
        - We enter a loop that processes the digits from right to left while i and j are greater than or equal to 0.
        - Inside the loop:
        - We initialize sum with the previous carry.
        - If there are digits left in string a (i >= 0), we add the current digit to sum and decrement i.
        - If there are digits left in string b (j >= 0), we add the current digit to sum and decrement j.
        - We append the least significant bit of sum (i.e., sum % 2) to the result string and calculate the carry for the next iteration (carry = sum / 2).
        - After processing all digits, if there is still a carry left, we append it to the result.
        - Finally, we reverse the result string to get the correct binary sum, and return it as a string.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        // Initialize variables to store the carry and the result
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Start from the rightmost digits of the input strings and move towards the left
        while (i >= 0 || j >= 0) {
            int sum = carry;  // Initialize the sum with the previous carry
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Add the current digit of 'a' to the sum
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Add the current digit of 'b' to the sum
                j--;
            }

            // Append the result of the current addition to the output string
            result.append(sum % 2); // Append the least significant bit of the sum
            carry = sum / 2;  // Calculate the carry for the next iteration
        }

        // If there is still a carry left after all digits have been processed, append it
        if (carry > 0) {
            result.append(carry);
        }

        // Reverse the result string to get the final binary sum
        return result.reverse().toString();
    }
}


class AddBinaryTest {
    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("11", "1"));
    }
}
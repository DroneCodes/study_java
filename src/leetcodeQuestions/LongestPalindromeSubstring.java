package leetcodeQuestions;

/*
    Create a 2D boolean array isPalindrome to store whether a substring from index i to j is a palindrome. Initialize all entries to false.

    Initialize variables longestPalindrome to an empty string and maxLength to 0. These will be used to keep track of the longest palindrome found so far.

    Handle the base cases:

    All substrings of length 1 are palindromes, so mark isPalindrome[i][i] as true for each character in the string and update longestPalindrome and maxLength accordingly.

    Check for substrings of length 2 and mark them as palindromes if they are the same character.

    Iterate through substrings of length 3 or more:

    For each substring of length length, starting from index start and ending at index end, check if the characters at the start and end are the same and if the substring inside is also a palindrome (i.e., isPalindrome[start + 1][end - 1] is true).

    If all these conditions are met, mark isPalindrome[start][end] as true and update longestPalindrome and maxLength if the current substring is longer.

    Finally, return longestPalindrome, which will contain the longest palindromic substring found in the input string s.

 */
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n]; // 2D table to store palindrome information

        String longestPalindrome = "";
        int maxLength = 0; // Length of the longest palindrome found so far

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
            longestPalindrome = s.substring(i, i + 1);
            maxLength = 1;
        }

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                longestPalindrome = s.substring(i, i + 2);
                maxLength = 2;
            }
        }

        // Check for longer substrings
        for (int length = 3; length <= n; length++) {
            for (int start = 0; start < n - length + 1; start++) {
                int end = start + length - 1;

                if (s.charAt(start) == s.charAt(end) && isPalindrome[start + 1][end - 1]) {
                    isPalindrome[start][end] = true;
                    if (length > maxLength) {
                        longestPalindrome = s.substring(start, end + 1);
                        maxLength = length;
                    }
                }
            }
        }

        return longestPalindrome;
    }
}


// Faster Solution
class FasterSolution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;  // Starting index of the longest palindrome found so far
        int end = 0;    // Ending index of the longest palindrome found so far

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);      // Check for odd-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);  // Check for even-length palindromes
            int len = Math.max(len1, len2);  // Length of the longest palindrome centered at i

            if (len > end - start) {
                // Update start and end if a longer palindrome is found
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1); // Extract the longest palindrome substring
    }

    // Helper function to expand around the center and find the length of a palindrome
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

/*
    We handle the base case first. If the input string s is null or empty, we return an empty string since there's no valid palindrome to find.

    We initialize two variables, start and end, to keep track of the indices of the longest palindrome found so far.

    We iterate through the characters in the string s. For each character or space between characters (this accounts for both odd and even-length palindromes), we use the expandAroundCenter function to find the length of the palindrome centered at the current character or between two characters.

    In each iteration, we compare the length of the found palindrome with the length of the longest palindrome found so far (stored in end - start). If the current palindrome is longer, we update start and end accordingly.

    After the loop, we extract the longest palindrome substring from the original string using s.substring(start, end + 1) and return it as the result.

    The expandAroundCenter function is a helper function that, given a string and left and right indices, expands around the center to find the length of the palindrome. It returns the length of the palindrome found.

    This algorithm has a time complexity of O(n^2), where "n" is the length of the input string s.
 */


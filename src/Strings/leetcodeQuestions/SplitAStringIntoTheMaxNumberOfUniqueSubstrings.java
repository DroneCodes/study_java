package Strings.leetcodeQuestions;

import java.util.HashSet;
import java.util.Set;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    public int maxUniqueSplit(String s) {
        return backtrack(s, new HashSet<>());
    }

    private int backtrack(String s, Set<String> seen) {
        int maxSplit = 0;
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            if (!seen.contains(substring)) {
                seen.add(substring);
                maxSplit = Math.max(maxSplit, 1 + backtrack(s.substring(i), seen));
                seen.remove(substring);
            }
        }
        return maxSplit;
    }

    public static void main(String[] args) {
        SplitAStringIntoTheMaxNumberOfUniqueSubstrings solution = new SplitAStringIntoTheMaxNumberOfUniqueSubstrings();

        // Test case 1
        String s1 = "ababccc";
        System.out.println(solution.maxUniqueSplit(s1)); // Output: 5

        // Test case 2
        String s2 = "aba";
        System.out.println(solution.maxUniqueSplit(s2)); // Output: 2

        // Test case 3
        String s3 = "aa";
        System.out.println(solution.maxUniqueSplit(s3)); // Output: 1
    }
}
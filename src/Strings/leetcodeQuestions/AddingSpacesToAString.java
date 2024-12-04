package Strings.leetcodeQuestions;

public class AddingSpacesToAString {

    /**
     * Adds spaces to the given string at the specified indices.
     *
     * @param s the input string
     * @param spaces an array of indices where spaces should be inserted
     * @return the modified string with spaces inserted at the specified indices
     */
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        for (int i = 0; i < spaces.length; i++) {
            sb.insert(spaces[i] + i, " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddingSpacesToAString solution = new AddingSpacesToAString();

        String s = "leetcode";
        int[] spaces = {4};
        System.out.println("Output: " + solution.addSpaces(s, spaces)); // Expected output: "leet code"


    }
}
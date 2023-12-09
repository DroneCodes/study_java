package leetcodeQuestions;

public class CheckIfTwoStringsAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Create two StringBuilder objects to store the strings
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // Append all strings in word1 to sb1
        for (String s : word1) {
            sb1.append(s);
        }

        // Append all strings in word2 to sb2
        for (String s : word2) {
            sb2.append(s);
        }

        // Compare the two strings and return the result
        return sb1.toString().equals(sb2.toString());
    }
}
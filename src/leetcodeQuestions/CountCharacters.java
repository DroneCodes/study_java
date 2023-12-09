package leetcodeQuestions;

public class CountCharacters {

    public int countCharacters(String[] words, String chars) {
        // Create an array to store the count of each character in 'chars'
        int[] charCount = new int[26];
        int count = 0;
        // Count the occurrence of each character in 'chars'
        for (int i = 0; i < chars.length(); i++) {
            charCount[chars.charAt(i) - 'a']++;
        }
        // Iterate over each word in 'words'
        for (String word : words) {
            // Clone the charCount array to a temporary array
            int[] temp = charCount.clone();
            int i = 0;
            // Check if each character in the word exists in 'chars'
            for (; i < word.length(); i++) {
                // If the character does not exist, break the loop
                if (temp[word.charAt(i) - 'a'] == 0) {
                    break;
                } else {
                    // If the character exists, decrease its count in the temporary array
                    temp[word.charAt(i) - 'a']--;
                }
            }
            // If all characters in the word exist in 'chars', add the length of the word to the count
            if (i == word.length()) {
                count += word.length();
            }
        }
        // Return the total count
        return count;
    }
}
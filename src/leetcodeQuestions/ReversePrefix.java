package leetcodeQuestions;

public class ReversePrefix {

    /**
     * This method returns the word after reversing the segment that starts at index 0 and ends at the index of the first occurrence of the character ch.
     *
     * @param word The input word.
     * @param ch The character to find in the word.
     * @return The word after reversing the segment that starts at index 0 and ends at the index of the first occurrence of the character ch.
     */
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        return new StringBuilder(word.substring(0, index + 1)).reverse().toString() + word.substring(index + 1);
    }

}

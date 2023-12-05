package leetcodeQuestions;

public class CountCharacters {

    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];
        int count = 0;
        for (int i = 0; i < chars.length(); i++) {
            charCount[chars.charAt(i) - 'a']++;
        }
        for (String word : words) {
            int[] temp = charCount.clone();
            int i = 0;
            for (; i < word.length(); i++) {
                if (temp[word.charAt(i) - 'a'] == 0) {
                    break;
                } else {
                    temp[word.charAt(i) - 'a']--;
                }
            }
            if (i == word.length()) {
                count += word.length();
            }
        }
        return count;
    }
}

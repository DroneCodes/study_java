package leetcodeQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowelsInAString {

    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> vowels = new ArrayList<>();

        // Iterate through the string to identify vowels and their positions
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowels.add(ch);
                sb.append(' '); // Placeholder for vowels, will be replaced later
            } else {
                sb.append(ch); // Consonants stay in their original places
            }
        }

        // Sort the vowels
        Collections.sort(vowels);

        // Replace placeholders with sorted vowels
        int vowelIndex = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(i, vowels.get(vowelIndex++));
            }
        }

        return sb.toString();
    }
}



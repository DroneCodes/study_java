package leetcodeQuestions;

public class SortVowelsInAString {

    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

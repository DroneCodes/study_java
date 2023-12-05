package leetcodeQuestions;

public class CheckIfTwoStringsAreEquivalent {

        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for (String s : word1) {
                sb1.append(s);
            }

            for (String s : word2) {
                sb2.append(s);
            }

            return sb1.toString().equals(sb2.toString());
        }

        public static void main(String[] args) {
            String[] word1 = new String[]{"ab", "c"};
            String[] word2 = new String[]{"a", "bc"};
            CheckIfTwoStringsAreEquivalent checkIfTwoStringsAreEquivalent = new CheckIfTwoStringsAreEquivalent();
            System.out.println(checkIfTwoStringsAreEquivalent.arrayStringsAreEqual(word1, word2));
        }
}

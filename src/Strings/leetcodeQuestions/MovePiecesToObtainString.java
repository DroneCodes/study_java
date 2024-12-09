package Strings.leetcodeQuestions;

public class MovePiecesToObtainString {

    /**
     * Checks if it is possible to obtain the target string by moving pieces in the start string.
     *
     * @param start the initial string
     * @param target the target string
     * @return true if the target string can be obtained, false otherwise
     */
    public boolean canChange(String start, String target) {
        // Remove all '_' characters and check if the remaining characters are the same
        String startWithoutBlanks = start.replace("_", "");
        String targetWithoutBlanks = target.replace("_", "");
        if (!startWithoutBlanks.equals(targetWithoutBlanks)) {
            return false;
        }

        // Check the positions of 'L' and 'R' characters
        int j = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                // Find the next 'L' in target
                while (target.charAt(j) != 'L') {
                    j++;
                }
                // 'L' can only move to the left
                if (i < j) {
                    return false;
                }
                j++;
            } else if (start.charAt(i) == 'R') {
                // Find the next 'R' in target
                while (target.charAt(j) != 'R') {
                    j++;
                }
                // 'R' can only move to the right
                if (i > j) {
                    return false;
                }
                j++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MovePiecesToObtainString solution = new MovePiecesToObtainString();

        String start1 = "_L__R__R_";
        String target1 = "L______RR";
        System.out.println("Output (Test case 1): " + solution.canChange(start1, target1)); // Expected output: true

        String start2 = "R_L_";
        String target2 = "__LR";
        System.out.println("Output (Test case 2): " + solution.canChange(start2, target2)); // Expected output: false

        String start3 = "_R";
        String target3 = "R_";
        System.out.println("Output (Test case 3): " + solution.canChange(start3, target3)); // Expected output: false
    }
}
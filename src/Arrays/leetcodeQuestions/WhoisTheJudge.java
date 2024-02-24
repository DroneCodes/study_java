package Arrays.leetcodeQuestions;

/**
 * This class provides a method to find the town judge.
 */
public class WhoisTheJudge {

    /**
     * This method returns the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
     *
     * @param n The number of people in the town.
     * @param trust An array of pairs where trust[i] = [ai, bi] represents that the person labeled ai trusts the person labeled bi.
     * @return The label of the town judge or -1 if the town judge does not exist or cannot be identified.
     */
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        for (int[] relation : trust) {
            trustCount[relation[0]]--;
            trustCount[relation[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}

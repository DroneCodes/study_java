package Array.leetcodeQuestions;

public class UniqueNumberofOccurence {

    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1000]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                continue;
            for (int j = i + 1; j < count.length; j++) {
                if (count[j] == 0)
                    continue;
                if (count[i] == count[j])
                    return false;
            }
        }
        return true;
    }
}

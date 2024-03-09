package Array.leetcodeQuestions;

public class ElementsAppearingMoreThan25 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
                if (count > n / 4)
                    return arr[i];
            } else
                count = 1;
        }
        return arr[n - 1];
    }
}

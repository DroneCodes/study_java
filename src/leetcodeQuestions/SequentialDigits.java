package leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int len = 2; len <= 10; len++) {
            for (int start = 1; start <= 10 - len; start++) {
                int num = 0;
                for (int i = start; i < start + len; i++) {
                    num = num * 10 + i;
                }
                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }
        return res;
    }
}

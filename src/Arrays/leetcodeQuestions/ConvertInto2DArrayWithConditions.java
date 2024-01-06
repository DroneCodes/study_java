package Arrays.leetcodeQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertInto2DArrayWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> freq  = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            int row = freq.get(num) - 1;

            if (row == res.size()) {
                res.add(new ArrayList<>());
            }

            res.get(row).add(num);
        }

        return res;
    }
}

/*
In this code, we first create a frequency map for the numbers in the array. Then, we iterate over the array and for each number, we get its frequency and use it as the row index in the 2D array. If the row does not exist, we create a new row. Finally, we add the number to the corresponding row. This ensures that each row contains distinct numbers and the number of rows is minimal.
 */

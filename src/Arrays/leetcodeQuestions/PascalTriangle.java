package Arrays.leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long previous = 1;
        result.add((int)previous);

        for (int i = 1; i<=rowIndex; i++) {
            long current = (previous * (rowIndex - i + 1)) / i;
            result.add((int)current);
            previous = current;
        }

        return result;
    }

}



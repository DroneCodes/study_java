package leetcodeQuestions;


/*

        - Base Case: When n is 1, there's only one row, and it consists of a single symbol, which is 0. So, if n is 1, the code returns 0 directly.

        - Recursive Case: For n greater than 1, we need to compute the k-th symbol in the n-th row.

        - First, calculate the midpoint of the previous row. The previous row (n-1) has 2^(n-1-1) symbols (the first row has 1 symbol, the second row has 2 symbols, the third row has 4 symbols, and so on). So, the midpoint is 2^(n-2).

        - Compare k with the midpoint:

        - If k is less than or equal to the midpoint, this means that the k-th symbol in the n-th row is the same as the k-th symbol in the previous (n-1) row. So, we recursively call kthGrammar(n - 1, k).

        - If k is greater than the midpoint, this means that the k-th symbol in the n-th row is the opposite of the k-midpoint symbol in the previous (n-1) row. In this case, we recursively call kthGrammar(n - 1, k - midpoint) and subtract the midpoint from k. Since the pattern alternates between 01 and 10, changing 0 to 1 or 1 to 0, this is equivalent to subtracting or adding 1 to the k-midpoint symbol in the previous row.

        - The recursion continues until we reach the base case (n = 1), and the function returns the appropriate symbol for the given n and k.
 */
public class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {
        // Base case: when n is 1, there's only one symbol, which is 0.
        if (n == 1) {
            return 0;
        }

        // Calculate the midpoint of the previous row, which is (2^(n-1-1)) = 2^(n-2).
        int midpoint = 1 << (n - 2);

        // If k is less than or equal to the midpoint, it is the same as the k-th symbol
        // in the previous row.
        if (k <= midpoint) {
            return kthGrammar(n - 1, k);
        } else {
            // If k is greater than the midpoint, it is the opposite of the k-midpoint symbol
            // in the previous row.
            return 1 - kthGrammar(n - 1, k - midpoint);
        }
    }
}


class KthSymbolInGrammarTest {
    public static void main(String[] args) {
        KthSymbolInGrammar kthSymbolInGrammar = new KthSymbolInGrammar();
        System.out.println(kthSymbolInGrammar.kthGrammar(4, 5));
    }
}
package Strings.leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * The `DifferentWayToAddParenthesis` class provides a method to compute all possible results
 * from different ways to group numbers and operators in a given expression.
 * The expression consists of digits and the operators '+', '-', and '*'.
 */
public class DifferentWayToAddParenthesis {

    /**
     * Computes all possible results from different ways to group numbers and operators in the given expression.
     *
     * The method works as follows:
     * 1. If the expression is a single number, return it as the only result.
     * 2. Iterate through each character in the expression.
     * 3. If the character is an operator, split the expression into left and right sub-expressions.
     * 4. Recursively compute the results for the left and right sub-expressions.
     * 5. Combine the results from the left and right sub-expressions using the current operator.
     * 6. Return the list of all possible results.
     *
     * @param expression The input expression consisting of digits and the operators '+', '-', and '*'.
     * @return A list of all possible results from different ways to group numbers and operators.
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        // Base case: if the expression is a single number, return it as the only result
        if (expression.matches("\\d+")) {
            result.add(Integer.parseInt(expression));
            return result;
        }

        // Iterate through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is an operator, split the expression
            if (c == '+' || c == '-' || c == '*') {
                // Recursively compute the results for the left and right sub-expressions
                List<Integer> leftResults = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(expression.substring(i + 1));

                // Combine the results from the left and right sub-expressions using the current operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        switch (c) {
                            case '+':
                                result.add(left + right);
                                break;
                            case '-':
                                result.add(left - right);
                                break;
                            case '*':
                                result.add(left * right);
                                break;
                        }
                    }
                }
            }
        }

        return result;
    }
}
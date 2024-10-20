package Recursions.leetcodeQuestions;

import java.util.Stack;

public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ')') {
                // Process the expression inside the parentheses
                Stack<Character> temp = new Stack<>();
                while (stack.peek() != '(') {
                    temp.push(stack.pop());
                }
                stack.pop(); // Remove the '('
                char operator = stack.pop(); // Get the operator

                boolean result = evaluate(temp, operator);
                stack.push(result ? 't' : 'f');
            } else if (ch != ',') {
                stack.push(ch);
            }
        }

        return stack.pop() == 't';
    }

    private boolean evaluate(Stack<Character> temp, char operator) {
        if (operator == '!') {
            return temp.pop() == 'f';
        } else if (operator == '&') {
            while (!temp.isEmpty()) {
                if (temp.pop() == 'f') {
                    return false;
                }
            }
            return true;
        } else { // operator == '|'
            while (!temp.isEmpty()) {

                if (temp.pop() == 't') {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ParsingABooleanExpression solution = new ParsingABooleanExpression();

        // Test case 1
        String expression1 = "&(|(f))";
        System.out.println(solution.parseBoolExpr(expression1)); // Output: false

        // Test case 2
        String expression2 = "|(f,f,f,t)";
        System.out.println(solution.parseBoolExpr(expression2)); // Output: true

        // Test case 3
        String expression3 = "!(&(f,t))";
        System.out.println(solution.parseBoolExpr(expression3)); // Output: true
    }
}
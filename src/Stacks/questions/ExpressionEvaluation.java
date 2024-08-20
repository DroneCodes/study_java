package Stacks.questions;

import java.util.Stack;

public class ExpressionEvaluation {
    public int evaluateExpression(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int res = operand1 + operand2;
                stack.push(res);
            } else if (token.equals("-")) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int res = operand2 - operand1;
                stack.push(res);
            } else if (token.equals("*")) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int res = operand1 * operand2;
                stack.push(res);
            } else if (token.equals("/")) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int res = operand2 / operand1;
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

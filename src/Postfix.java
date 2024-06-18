public class Postfix {

    public static String convertToPostfix(String infix) {
        ArrayStack operatorStack = new ArrayStack();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char item = infix.charAt(i);

            if (isVariable(item)) {
                postfix.append(item);
            } else if (item == '(') {
                operatorStack.push(item);
            } else if (item == ')') {
                while (!operatorStack.isEmpty() && (char) operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop(); // pop '(' from the stack
            } else if (isOperator(item)) {
                while (!operatorStack.isEmpty() && getPrecedence((char) operatorStack.peek()) >= getPrecedence(item)) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(item);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    public static double evaluatePostfix(String postfix) {
        ArrayStack valueStack = new ArrayStack();

        for (int i = 0; i < postfix.length(); i++) {
            char item = postfix.charAt(i);

            if (isVariable(item)) {
                valueStack.push(valueOf(item));
            } else if (isOperator(item)) {
                double operand2 = (double) valueStack.pop();
                double operand1 = (double) valueStack.pop();
                double result = 0.0;

                switch (item) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                }

                valueStack.push(result);
            }
        }

        return (double) valueStack.pop();
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    private static boolean isVariable(char ch) {
        return (ch == 'a') || (ch == 'b') || (ch == 'c') || (ch == 'd');
    }

    private static double valueOf(char variable) {
        switch (variable) {
            case 'a':
                return 2.0;
            case 'b':
                return 3.0;
            case 'c':
                return 4.0;
            case 'd':
                return 5.0;
        }
        return 0;
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static void main(String[] args) {
        System.out.println("Testing postfix expressions with\na = 2.0, b = 3.0, c = 4.0, d = 5.0\n");
        testPostfix("a+b");
        testPostfix("a-b+c*d");
        testPostfix("(a+b)*c-d");
        testPostfix("a+b*(c-d)");
        testPostfix("(a+b)/(c-d)");
        testPostfix("a*(b/(c-d))");
    }

    public static void testPostfix(String infixExpression) {
        String postfixExpression = convertToPostfix(infixExpression);
        System.out.println("Infix:   " + infixExpression);
        System.out.println("Postfix: " + postfixExpression);
        System.out.println("Value:   " + evaluatePostfix(postfixExpression));
        System.out.println();
    }

    public static class ArrayStack {
        private Object[] stack;
        private int topIndex;
        private static final int DEFAULT_MAX_SIZE = 100;

        public ArrayStack() {
            stack = new Object[DEFAULT_MAX_SIZE];
            topIndex = -1;
        }

        public ArrayStack(int maxSize) {
            stack = new Object[maxSize];
            topIndex = -1;
        }

        public void push(Object newEntry) {
            topIndex++;
            stack[topIndex] = newEntry;
        }

        public Object pop() {
            Object top = null;
            if (!isEmpty()) {
                top = stack[topIndex];
                stack[topIndex] = null;
                topIndex--;
            }
            return top;
        }

        public Object peek() {
            Object top = null;
            if (!isEmpty())
                top = stack[topIndex];
            return top;
        }

        public boolean isEmpty() {
            return topIndex < 0;
        }

        public void clear() {
            for (; topIndex > -1; topIndex--)
                stack[topIndex] = null;
        }
    }

}
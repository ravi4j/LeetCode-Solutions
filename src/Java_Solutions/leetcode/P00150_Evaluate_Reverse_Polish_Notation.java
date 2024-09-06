package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P00150_Evaluate_Reverse_Polish_Notation {

    public static void main(String[] args) {
        P00150_Evaluate_Reverse_Polish_Notation solution = new P00150_Evaluate_Reverse_Polish_Notation();
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        int result = solution.evalRPN(tokens);
        System.out.println(result);

        tokens = new String[]{"4", "13", "5", "/", "+"};
        result = solution.evalRPN(tokens);
        System.out.println(result);

        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        result = solution.evalRPN(tokens);
        System.out.println(result);

    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        String validOps = "+-/*";
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (validOps.indexOf(token) != -1) {
                int b = stack.pop();
                int a = stack.pop();
                int result = evaluate(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private int evaluate(int a, int b, String operation) {
        if ("+".equals(operation)) {
            return a + b;
        } else if ("-".equals(operation)) {
            return a - b;
        } else if ("*".equals(operation)) {
            return a * b;
        } else if ("/".equals(operation)) {
            return a / b;
        } else {
            throw new RuntimeException("Invalid Operations");
        }
    }

}

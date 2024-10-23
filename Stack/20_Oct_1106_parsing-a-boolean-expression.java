import java.util.*;

class Solution {
    // Using Two Stack
    // Helper function to evaluate a boolean expression based on an operator
    private boolean evaluate(Stack<Character> charSt, char op) {
        if (op == '&') {
            // AND want one F to be false
            while (!charSt.isEmpty()) {
                if (charSt.pop() == 'f') {
                    return false;
                }
            }
            return true;
        } else if (op == '|') {
            // OR wants one T to be true
            while (!charSt.isEmpty()) {
                if (charSt.pop() == 't') {
                    return true;
                }
            }
            return false;
        } else if (op == '!') {
            // NOT only flips T to F or F to T
            return charSt.pop() == 'f';
        }
        return false; // Fallback, should not reach here
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        int n = expression.length();

        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ',')
                continue;

            if (c == ')') {
                Stack<Character> values = new Stack<>();
                // Gather all values inside the parentheses
                while (stack.peek() != '(') {
                    values.push(stack.pop());
                }
                stack.pop(); // Remove '('
                char op = stack.pop(); // Get the operator
                boolean ans = (evaluate(values, op)); // Push the result back
                stack.push(ans == true ? 't' : 'f');
            } else {
                stack.push(c); // Push the character onto the stack
            }
        }
        return stack.peek() == 't';
    }
}

class Solution2 { // using Three Stack
    // Helper function to evaluate a boolean expression based on an operator
    private boolean evaluate(Stack<Character> charSt, char op) {
        if (op == '&') {
            // AND want one F to be false
            while (!charSt.isEmpty()) {
                if (charSt.pop() == 'f') {
                    return false;
                }
            }
            return true;
        } else if (op == '|') {
            // OR wants one T to be true
            while (!charSt.isEmpty()) {
                if (charSt.pop() == 't') {
                    return true;
                }
            }
            return false;
        } else if (op == '!') {
            // NOT only flips T to F or F to T
            return charSt.pop() == 'f';
        }
        return false; // Fallback, should not reach here
    }

    public boolean parseBoolExpr(String exp) {
        Stack<Character> charSt = new Stack<>(); // Stack for characters
        Stack<Character> opSt = new Stack<>(); // Stack for operators

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == ',' || ch == ' ') {
                continue; // Skip commas and spaces
            } else if (ch == '&' || ch == '|' || ch == '!') {
                opSt.push(ch); // Push operator to operator stack
            } else if (ch == '(') {
                // Start of a sub-expression
                charSt.push('('); // Use '(' as a marker
            } else if (ch == ')') {
                // When we hit a closing parenthesis, evaluate the expression
                Stack<Character> subExpr = new Stack<>();
                while (!charSt.isEmpty() && charSt.peek() != '(') {
                    subExpr.push(charSt.pop()); // Collect all characters inside parentheses
                }
                charSt.pop(); // Remove the '(' marker

                // Get the operator
                char op = opSt.pop();
                boolean result = evaluate(subExpr, op);

                // Push the result of the evaluation back onto the char stack as 't' or 'f'
                charSt.push(result ? 't' : 'f');
            } else {
                // Push the boolean characters 't' or 'f' to char stack
                charSt.push(ch);
            }
        }

        // The final result will be the only element left in the char stack
        return charSt.pop() == 't';
    }
}

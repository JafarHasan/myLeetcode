import java.util.*;

class Solution {
    // TC:O(N) SC:O(N)
    private boolean isValidPair(char o, char c) {
        if (o == '(' && c == ')') {
            return true;
        } else if (o == '{' && c == '}') {
            return true;
        } else if (o == '[' && c == ']') {
            return true;
        } else
            return false;
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (!st.isEmpty() && isValidPair(st.peek(), ch)) {
                st.pop();
            } else
                return false;
        }
        return st.isEmpty();
    }
}

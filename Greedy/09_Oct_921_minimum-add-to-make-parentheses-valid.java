package Greedy;

import java.util.*;

class Solution {
    /**
     * cnt open and close Greedy
     */
    // TC:O(N) SC:O(1) 0ms best beats 100%
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                open++;
            else {
                if (open > 0) {
                    open--;
                } else
                    close++;
            }
        }
        return (open + close);
    }
}

class Solution2 {
    // TC:O(N) SC:O(N) using Stack
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }

        }
        return st.size();
    }
}

class Solution3 {
    /**
     * cnt open and close failed here
     * s =
     * "()))(("
     * 44/115 passed
     */
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                open++;
            else
                close++;
        }
        return Math.abs(open - close);
    }
}
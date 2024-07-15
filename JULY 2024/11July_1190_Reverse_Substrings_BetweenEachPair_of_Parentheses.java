import java.util.*;
import java.util.Stack;

class Solution {
    // O(N^2) SC:O(N)
    public String reverseParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != ')') {
                st.push(ch);
            } else {
                StringBuilder sb = new StringBuilder();
                while (st.size() > 0 && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();// remove last ( also

                for (int i = 0; i < sb.length(); i++) {
                    st.push(sb.charAt(i));
                }
            }

        }
        while (st.size() > 0) {
            ans.insert(0, st.pop());
        }

        return ans.toString();

    }
}
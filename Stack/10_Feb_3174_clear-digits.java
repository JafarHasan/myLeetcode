
import java.util.*;

class Solution {

    // TC:O(N) SC:O(1)
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    // TC:O(N) SC:O(N)
    public String clearDigitsUsingStack(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            // if ch is a digit so pop last inserted char
            if (!st.isEmpty() && (ch >= '0' && ch <= '9')) {
                st.pop();
                // if char is not a digit i.e a char push it into the stack
            } else {
                st.push(ch);
            }
        }
        /// collect all the remaining char
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}


import java.util.*;

class Solution {

    ///TC:O(N) SC:O(N)
    public String smallestNumber(String pattern) {
        int cnt = 1;
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        st.push(cnt);

        for (char ch : pattern.toCharArray()) {
            if (ch == 'I') {
                while (st.size() > 0) {
                    sb.append(st.pop());
                }
                cnt++;
                st.push(cnt);
            } else {
                // if char is D
                cnt++;
                st.push(cnt);
            }
        }
        // remaining char from stack
        while (st.size() > 0) {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}


import java.util.*;

class Solution {

    private String removeSubstring(String s, String remove) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            sb.append(s.charAt(j));
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 2) == remove.charAt(0)
                    && sb.charAt(len - 1) == remove.charAt(1)) {
                sb.delete(sb.length() - 2, sb.length()); // remove the pair
            }
        }
        return sb.toString();
    }

    public int maximumGain(String s, int x, int y) {
        String maxStr = (x >= y) ? "ab" : "ba";
        String minStr = (x < y) ? "ab" : "ba";
        int len = s.length();

        int score = 0;
        //first pass
        String temp1 = removeSubstring(s, maxStr);
        int n = temp1.length();
        score += Math.max(x, y) * ((len - n) / 2);

        //secondPass
        String temp2 = removeSubstring(temp1, minStr);
        len = temp1.length();

        n = temp2.length();
        score += Math.min(x, y) * ((len - n) / 2);
        return score;
    }
}

class Solution_UsingStack {

    //TC:O(N+N) SC:O(N+N) O(N) ,O(N)
    private String removeSubstring(String s, String remove) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == remove.charAt(1) && !st.isEmpty() && st.peek() == remove.charAt(0)) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        //make String after removing remove "ab " or "ba"
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }

    public int maximumGain(String s, int x, int y) {
        String maxStr = (x >= y) ? "ab" : "ba";
        String minStr = (x < y) ? "ab" : "ba";
        int len = s.length();

        int score = 0;
        //first pass
        String temp1 = removeSubstring(s, maxStr);
        int n = temp1.length();
        score += Math.max(x, y) * ((len - n) / 2);

        //secondPass
        String temp2 = removeSubstring(temp1, minStr);
        len = temp1.length();
        n = temp2.length();
        score += Math.min(x, y) * ((len - n) / 2);
        return score;
    }
}


import java.util.*;

class Solution {

    // same with contains() self build
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String sub = words[i];
            for (int j = 0; j < n; j++) {
                if (i != j && isSubstring(words[j], sub)) {
                    ans.add(sub);
                    break;
                }
            }
        }
        return ans;
    }

    private boolean isSubstring(String s, String sub) {
        if (sub.length() > s.length()) {
            return false;
        }

        int n = s.length();
        int m = sub.length();

        for (int i = 0; i <= n - m; i++) { // Loop to slide the window over the main string
            int j;
            for (j = 0; j < m; j++) { // Check if substring matches
                if (s.charAt(i + j) != sub.charAt(j)) {
                    break; // Break on mismatch
                }
            }
            if (j == m) {
                return true; // Full match found
            }
        }

        return false; // No match found

    }

    // TC:O(N^2) SC:O(1)
    public List<String> stringMatching1(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String sub = words[i];
            for (int j = 0; j < n; j++) {
                if (i != j && words[j].contains(sub)) {
                    ans.add(sub);
                    break;
                }
            }
        }
        return ans;
    }
}

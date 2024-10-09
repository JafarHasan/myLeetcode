package Recursion;

import java.util.*;

class Solution {
    // now we will generate only valid patterns 1ms
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve(0, 0, new StringBuilder(), n);
        return ans;
    }

    private void solve(int open, int close, StringBuilder pattern, int n) {
        if (pattern.length() == 2 * n) {
            // now all valid Pattern will be generated using open<n ans close<open
            ans.add(pattern.toString());
            return;

        }
        // length is not =2n so more char needed
        if (open < n) {

            solve(open + 1, close, pattern.append("("), n);
            pattern.deleteCharAt(pattern.length() - 1);
        }
        if (close < open) {
            solve(open, close + 1, pattern.append(")"), n);
            pattern.deleteCharAt(pattern.length() - 1);
        }
    }
}

class Solution1 {
    // if n=1 pattern length 2 ()
    // if n=2 length 4 (()) or ()()..
    // if n=3 length 6 means 2*n
    // TC:O(2^n*2n); SC:O(N)
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve("", n);
        return ans;
    }

    private void solve(String pattern, int n) {
        if (pattern.length() == 2 * n) {
            if (isValid(pattern)) {
                ans.add(pattern);
            }
            return;
        }
        // length is not =2n so more char needed
        solve(pattern + "(", n);
        solve(pattern + ")", n);
    }

    private boolean isValid(String pattern) {
        int cnt = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else {
                cnt--;
                if (cnt < 0)
                    return false;// ())(
            }
        }
        return cnt == 0;
    }
}
import java.util.Arrays;

class Solution2 {
    // TLE 23/269
    public int numDecodings(String s) {
        int n = s.length();
        return solve(0, s, n);

    }

    private int solve(int i, String s, int n) {// idx,string ,legnth

        if (i == n) {
            return 1;// found 1 way as i reached=legnth
        }
        if (s.charAt(i) == '0') {
            return 0;// not possible if starting char is 0
        }
        int ithChar = solve(i + 1, s, n);
        int ithPlusOneChar = 0;
        if (i + 1 < n) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                ithPlusOneChar = solve(i + 2, s, n);
            }
        }
        return ithChar + ithPlusOneChar;
    }
}

// Memoization DP only one var i is changing so 1D array needed
/**
 * Constraints:
 * 1 <= s.length <= 100
 */
// TC:O(N) SC;O(N)
class Solution {
    int dp[];

    public int numDecodings(String s) {
        dp = new int[101];
        Arrays.fill(dp, -1);
        int n = s.length();
        return solve(0, s, n);

    }

    private int solve(int i, String s, int n) {// idx,string ,legnth
        if (dp[i] != -1)
            return dp[i];
        if (i == n) {
            return 1;// found 1 way as i reached=legnth
        }
        if (s.charAt(i) == '0') {
            return 0;// not possible if starting char is 0
        }
        int ithChar = solve(i + 1, s, n);
        int ithPlusOneChar = 0;
        if (i + 1 < n) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                ithPlusOneChar = solve(i + 2, s, n);
            }
        }
        return dp[i] = ithChar + ithPlusOneChar;
    }
}
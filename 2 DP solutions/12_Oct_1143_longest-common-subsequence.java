import java.util.*;

class Solution {
    int dp[][];

    // passed TC:O(n+1)(m+1)=O(nxmcc) SC:O(N)
    private int find(String t1, String t2, int i, int j) {
        if (i == t1.length() || j == t2.length()) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (t1.charAt(i) == t2.charAt(j)) {
            // match found move both pointer to next char
            return dp[i][j] = 1 + find(t1, t2, i + 1, j + 1);
        }
        // Characters do not match; explore both possibilities
        int skip1 = find(t1, t2, i + 1, j);
        int skip2 = find(t1, t2, i, j + 1);
        // longest so return Max
        return dp[i][j] = Math.max(skip1, skip2);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[1001][1001];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return find(text1, text2, 0, 0);
    }
}

class Solution1 {
    // TLE:17/47 passed O(2^n) SC:O(N)
    private int find(String t1, String t2, int i, int j) {
        if (i == t1.length() || j == t2.length()) {
            return 0;
        }
        if (t1.charAt(i) == t2.charAt(j)) {
            // match found move both pointer to next char
            return 1 + find(t1, t2, i + 1, j + 1);
        }
        // Characters do not match; explore both possibilities
        int skip1 = find(t1, t2, i + 1, j);
        int skip2 = find(t1, t2, i, j + 1);
        // longest so return Max
        return Math.max(skip1, skip2);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return find(text1, text2, 0, 0);
    }
}
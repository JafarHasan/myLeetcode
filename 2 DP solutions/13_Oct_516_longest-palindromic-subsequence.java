
import java.util.*;

class Solution {

    int dfs(char ch[], int dp[][], int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i == j) {
            return dp[i][j] = 1;
        }

        if (ch[i] == ch[j]) {
            dp[i][j] = 2 + dfs(ch, dp, i + 1, j - 1);
        } else {
            dp[i][j] = Math.max(dfs(ch, dp, i, j - 1), dfs(ch, dp, i + 1, j));
        }
        return dp[i][j];
    }

    public int longestPalindromeSubseq(String s) {
        char ch[] = s.toCharArray();
        int n = ch.length;
        int dp[][] = new int[n][n];
        dfs(ch, dp, 0, n - 1);
        return dp[0][n - 1];
    }
}

class Solution_Rec {

    int dp[][] = new int[1001][1001];

    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        // System.out.println(s2);
        int n = s.length();
        return longestCommonSubsequence(s, s2, n, n);
    }

    private int longestCommonSubsequence(String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = 1 + longestCommonSubsequence(s1, s2, i - 1, j - 1);
        }
        return dp[i][j] = Math.max(longestCommonSubsequence(s1, s2, i - 1, j),
                longestCommonSubsequence(s1, s2, i, j - 1));
    }
}

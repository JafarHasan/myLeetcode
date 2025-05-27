
class Solution {

    static int minDeletions(String s) {
        // code here
        return s.length() - longestPalindromeSubseq(s);

    }

    static int dfs(char ch[], int dp[][], int i, int j) {
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

    static public int longestPalindromeSubseq(String s) {

        char ch[] = s.toCharArray();
        int n = ch.length;
        int dp[][] = new int[n][n];
        dfs(ch, dp, 0, n - 1);
        return dp[0][n - 1];
    }
}

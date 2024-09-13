import java.util.Arrays;

class Solution {
    // Recursive way TLE
    public int climbStairs1(int n) {
        return solve1(n, 0);
    }

    private int solve1(int n, int i) {
        // one way possible
        if (i == n) {
            return 1;
        }
        // no way possible
        if (i > n) {
            return 0;
        }
        return solve1(n, i + 1) + solve1(n, i + 2);
    }

    // Memoization DP 0Ms
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, 0, dp);
    }

    private int solve(int n, int i, int[] dp) {
        if (i == n)
            return 1;
        if (i > n)
            return 0;
        // allready saved ans for this step so return this no need to calll again
        if (dp[i] != -1)
            return dp[i];
        dp[i] = solve(n, i + 1, dp) + solve(n, i + 2, dp);
        return dp[i];
    }
}
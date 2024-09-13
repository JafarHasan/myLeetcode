import java.util.Arrays;

class Solution2 {
    // TLE 259/284 TC:O(2^n) exponential
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int Index0Ans = solve(cost, 0, n);
        int Index1Ans = solve(cost, 1, n);
        return Math.min(Index0Ans, Index1Ans);
    }

    private int solve(int[] cost, int i, int n) {
        if (i >= n)
            return 0;// out of index so no need to jump return 0
        // one jump
        int ans1 = cost[i] + solve(cost, i + 1, n);
        // 2 jump
        int ans2 = cost[i] + solve(cost, i + 2, n);
        return Math.min(ans1, ans2);
    }
}

// Passed 1ms
// we will visit maximum n states
// TC:O(n) sc:O(n) Stack+dp[]
class Solution1 {
    int dp[];

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int Index0Ans = solve(cost, 0, n);
        int Index1Ans = solve(cost, 1, n);
        return Math.min(Index0Ans, Index1Ans);
    }

    private int solve(int[] cost, int i, int n) {

        if (i >= n)
            return 0;// out of index so no need to jump return 0
        if (dp[i] != -1)
            return dp[i];
        // one jump
        int ans1 = cost[i] + solve(cost, i + 1, n);
        // 2 jump
        int ans2 = cost[i] + solve(cost, i + 2, n);
        return dp[i] = Math.min(ans1, ans2);
    }
}

// Passed 1ms Bottom-UP
// we will visit maximum n states
// TC:O(n) sc:O(1)
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 2)
            return Math.min(cost[0], cost[1]);

        for (int i = 2; i < n; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[n - 1], cost[n - 2]);
    }

}
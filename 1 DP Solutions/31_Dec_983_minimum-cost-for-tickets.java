
import java.util.Arrays;

class Solution {
    // TC:o(3^n) but DP makes it linear TC
    // SC:(N)
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[365];
        Arrays.fill(dp, -1);
        int n = days.length;
        return solve(days, costs, n, 0, dp);
    }

    private int solve(int[] days, int[] cost, int n, int idx, int[] dp) {
        if (idx >= n)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        // 1day pass
        int cost1 = cost[0] + solve(days, cost, n, idx + 1, dp);

        // 2 day pass
        int j = idx;
        int maxDay = days[idx] + 7;
        while (j < n && days[j] < maxDay) {
            j++;
        }
        int cost7 = cost[1] + solve(days, cost, n, j, dp);

        j = idx;
        maxDay = days[idx] + 30;
        while (j < n && days[j] < maxDay) {
            j++;
        }
        int cost30 = cost[2] + solve(days, cost, n, j, dp);
        return dp[idx] = Math.min(cost1, Math.min(cost7, cost30));

    }
}
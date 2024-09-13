import java.util.Arrays;

class Solution1 {
    // Recursive TLE 55/70 TC:O(2^n)
    public int rob(int[] nums) {
        // pick steal
        // not pick skip
        int n = nums.length;
        return solve(nums, 0, n);// arr,idx,length of nums
    }

    private int solve(int[] nums, int i, int n) {
        if (i >= n)
            return 0;

        // pick (if pick get the curr money and goto next->next house)
        int steal = nums[i] + solve(nums, i + 2, n);
        // not pick (if not robbery this house goto next house)
        int skip = solve(nums, i + 1, n);
        return Math.max(steal, skip);
    }
}

// Memoization DP
class Solution {
    // Recursive TLE 55/70
    public int rob(int[] nums) {
        // pick steal
        // not pick skip
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(nums, 0, n, dp);// arr,idx,length of nums
    }

    private int solve(int[] nums, int i, int n, int[] dp) {
        if (i >= n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        // pick
        int steal = nums[i] + solve(nums, i + 2, n, dp);
        // not pick
        int skip = solve(nums, i + 1, n, dp);
        return dp[i] = Math.max(steal, skip);
    }
}

// Most Optimal TC:O(n) SC:O(1)
class Solution3 {
    public int rob(int[] num) {
        int rob = 0; // max monney can get if rob current house
        int notrob = 0; // max money can get if not rob current house
        for (int i = 0; i < num.length; i++) {
            int currob = notrob + num[i]; // if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); // if not rob ith house, take the max value of robbed (i-1)th house and not
                                            // rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
}
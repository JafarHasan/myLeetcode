
import java.util.*;

class Solution {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums, nums.length, dp);
    }

    public int solve(int idx, int[] nums, int n, int[] dp) {
        if (idx >= n - 1) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int step = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[idx]; i++) {
            if (idx + i < n) {
                int result = solve(idx + i, nums, n, dp);
                if (result != Integer.MAX_VALUE) {
                    step = Math.min(step, 1 + result);
                }
            }
        }
        return dp[idx] = step;
    }
}

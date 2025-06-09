
class Solution {

    Boolean[] dp;

    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length + 1];
        return solve(nums, 0, nums.length);
    }

    private boolean solve(int[] nums, int idx, int n) {
        if (idx >= n) {
            return false;
        }
        if (idx == n - 1) {
            return true;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        for (int i = 1; i <= nums[idx]; i++) {
            if (solve(nums, idx + i, n)) {
                return dp[idx] = true;
            }
        }
        ;
        return dp[idx] = false;
    }

    public boolean canJump_Greedy(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(reach, nums[i] + i);
        }
        return true;
    }
}

import java.util.*;
class Solution {
    // recursion
    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0, n = nums.length;
        return solve1(nums, n, 0, 0, target);// nums,n,currSum,idx,target
    }

    private int solve1(int[] nums, int n, int currSum, int idx, int target) {
        if (idx >= n) {
            // find one way
            if (currSum == target) {
                return 1;
            }
            return 0;
        }

        // two possibilities on each element + and - so TC:O(2^n)
        // SC:O(N)
        int plus = solve1(nums, n, currSum + nums[idx], idx + 1, target);
        int minus = solve1(nums, n, currSum - nums[idx], idx + 1, target);

        return plus + minus;

    }

    // dp
    // int[][] dp=new int[1001][1001];//will not work bcz currSUm is in minus as
    // well
    // so - idx will be out of bound to avoid this use currSum+sum(overall sum of
    // array)
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int n = nums.length;
        int[][] dp = new int[2 * sum + 1][n+1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, n, 0, 0, target, dp, sum);// nums,n,currSum,idx,target
    }

    private int solve(int[] nums, int n, int currSum, int idx, int target, int[][] dp, int sum) {
        if (idx >= n) {
            // find one way
            if (currSum == target) {
                return 1;
            }
            return 0;
        }
        if (dp[currSum + sum][idx] != -1)
            return dp[currSum + sum][idx];
        // two possibilities on each element + and - so TC:O(2^n)
        // SC:O(N)
        int plus = solve(nums, n, currSum + nums[idx], idx + 1, target, dp, sum);
        int minus = solve(nums, n, currSum - nums[idx], idx + 1, target, dp, sum);

        return dp[currSum + sum][idx] = plus + minus;

    }

}
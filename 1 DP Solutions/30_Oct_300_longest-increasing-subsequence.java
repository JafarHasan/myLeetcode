import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        int LIS[] = new int[n];
        Arrays.fill(LIS, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                    // finding max len subseq in LIS
                    maxLen = Math.max(maxLen, LIS[i]);
                }
            }
        }
        return maxLen;
    }
}

class Solution2 {
    int dp[][];

    public int lengthOfLIS(int[] nums) {
        dp = new int[2501][2501];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return solve(nums, 0, -1);// starting idx,previous idx

    }

    private int solve(int[] nums, int si, int pi) {
        if (si >= nums.length)
            return 0;
        if (pi != -1 && dp[si][pi] != -1)
            return dp[si][pi];
        int pick = 0;
        if (pi == -1 || nums[pi] < nums[si]) {
            // pick
            pick = 1 + solve(nums, si + 1, si);
        }
        // not pick
        int notPick = solve(nums, si + 1, pi);
        if (pi != -1)
            dp[si][pi] = Math.max(pick, notPick);
        return Math.max(pick, notPick);
    }
}

import java.util.*;
class Solution {

    // TC:O(log(max)*n) SC:O(1) Binary Search
    private boolean isPossible(int[] nums, int mid, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                cnt++;
                i++;// skip i+1th house
                if (cnt >= k) {
                    return true;
                }
            }
        }
        return cnt >= k;
    }

    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int ele : nums) {
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }
        int lo = min;
        int hi = max;
        int pans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(nums, mid, k)) {
                pans = mid;
                hi = mid - 1;

            } else {
                lo = mid + 1;
            }
        }
        return pans;

    }
}

class Solution_Using_DP {

    // Brute Force Recursion+memoziation
    // TLE:28/64 passed using rec
    // TLE: 52/64 passed using DP
    // TC:O(n+k) SC:O(N+K)
    private int solve(int[] nums, int i, int k, int[][] dp) {
        if (k == 0) {
            return 0;
        }
        if (i >= nums.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][k] != -1) {
            return dp[i][k];
        }
        int pick = Math.max(nums[i], solve(nums, i + 2, k - 1, dp));
        int not = solve(nums, i + 1, k, dp);

        return dp[i][k] = Math.min(pick, not);
    }

    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int r[] : dp) {
            Arrays.fill(r, -1);
        }
        return solve(nums, 0, k, dp);

    }
}

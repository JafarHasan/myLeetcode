import java.util.*;

class Solution {
    // TC:O(N^2) SC:O(2N)
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int LIS[] = new int[n];
        int LDS[] = new int[n];
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);
        LIS[0] = 1;// first elemnt is a subsequence of length 1
        // find LIS of each idx
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
        // find LDS of each idx
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }
        // find min removals
        int minRemove = n;
        for (int i = 1; i < n; i++) {
            if (LIS[i] > 1 && LDS[i] > 1)// we can find min length >=3 only when
                // treat each ele as peak and find removal
                minRemove = Math.min(minRemove, n - LIS[i] - LDS[i] + 1);
        }
        return minRemove;

    }
}
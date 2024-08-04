import java.util.*;

class Solution {
    // Brute Force Approach
    // TC:O(nlogn)+O(n^2)
    // SC:O(n*(n+1)/2)
    public int rangeSum(int[] nums, int n, int left, int right) {
        int len = n * (n + 1) / 2;
        int sumArr[] = new int[len]; // SC:O(n*(n+1)/2)
        int idx = 0;
        // O(N^2)
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sumArr[idx++] = sum;
            }
        }
        // TC:O(nlogn)
        Arrays.sort(sumArr);
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum = (sum + sumArr[i - 1]) % 1000000007;
        }

        return sum % 1000000007;

    }
}

// TC:O(N^3) Approach
/*
 * for (int i = 0; i < n; i++) {
 * 
 * for (int j = i; j < n; j++) {
 * int sum = 0;
 * for (int k = i; k <= j; k++)
 * sum += nums[k];
 * sumArr[idx++] = sum;
 * }
 * 
 * }
 */
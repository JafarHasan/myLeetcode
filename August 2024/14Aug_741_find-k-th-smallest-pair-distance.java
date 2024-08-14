import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    // Brute Force TC;O(N^2) SC:O(N) 16/19 cases passed
    public int smallestDistancePair2(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> dis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dis.add(Math.abs(nums[j] - nums[i]));
            }
        }
        Collections.sort(dis);
        return dis.get(k - 1);
    }

    // Optimal->Sorting+Binary Search+Sliding Window
    // TC:O(nlogn) SC:O(1)
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[n - 1] - nums[0];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;// avoid overflow
            // counting pairs with diffeence<=mid
            int cnt = countPairWithDifferenceLessThanMid(nums, mid);
            if (cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;// or hi
    }

    private int countPairWithDifferenceLessThanMid(int[] arr, int mid) {
        int cnt = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
            while (j < arr.length && arr[j] - arr[i] <= mid) {
                j++;
                cnt += j - i - 1;
            }
        }
        return cnt;
    }
}
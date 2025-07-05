
import java.util.*;

class Solution {

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0, hi = nums[n - 1] - nums[0];//diff between smallest and greatest element
        int ans = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(nums, mid, p)) {
                ans = Math.min(ans, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int mid, int p) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= mid) {
                cnt++;
                i++;
                ///skipping the curr idx element bcz its already used
                if (cnt >= p) {
                    return true;
                }
            }

        }
        return cnt >= p;
    }
}

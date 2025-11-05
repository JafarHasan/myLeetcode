
import java.util.*;

class Solution {

    //TC:O(NxK ) SC:O(1)
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i + 2 * k <= n; i++) {
            //check start ---> lass than start+k and start+k -----> < start+2k
            if (isIncreasing(nums, i, i + k) && isIncreasing(nums, i + k, i + k + k)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIncreasing(List<Integer> nums, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}


import java.util.*;

class Solution {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int low = nums[0];
        int group = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - low <= k) {
                continue;
            }
            low = nums[i];
            group++;
        }
        return group;
    }
}

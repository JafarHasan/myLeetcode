import java.util.*;
class Solution {
    // it will work for both sorted and unsorted array
    // TC;O(N) SC:O(N)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
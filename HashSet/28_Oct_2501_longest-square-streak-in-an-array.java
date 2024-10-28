package HashSet;

import java.util.*;

class Solution {
    // TC:O(nlogN) SC:O(N)
    public int longestSquareStreak(int[] nums) {
        HashSet<Long> set = new HashSet<>();
        for (int ele : nums) {
            set.add((long) ele);
        }
        Arrays.sort(nums);
        int len = 1;
        for (int i = 0; i < nums.length; i++) {
            long base = (long) nums[i];
            int cnt = 1;
            while (set.contains(base * base)) {
                cnt++;
                len = Math.max(len, cnt);
                base = base * base;
            }

        }
        return len >= 2 ? len : -1;
    }
}
package HashSet;

import java.util.*;

class Solution {
    // TC:O(n) SC:O(N)
    public int longestSquareStreak(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int streak = 0;
        for (int num : nums) {
            int currStreak = 0;
            long curr = num;
            while (set.contains((int) curr)) {
                currStreak++;
                if (curr * curr > 1e5)
                    break;
                curr = curr * curr;
            }
            streak = Math.max(streak, currStreak);
        }
        return streak < 2 ? -1 : streak;
    }
}

class Solution2 {
    /// 53% beats 51ms TC:O(NlogN) SC:O(N)
    public int longestSquareStreak(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int ans = -1;
        for (int num : nums) {
            int root = (int) Math.sqrt(num);
            if (root * root == num && map.containsKey(root)) {
                map.put(num, map.get(root) + 1);
                ans = Math.max(ans, map.get(num));
            } else {
                map.put(num, 1);// streak is 1 of a new No
            }

        }
        return ans;
    }
}

class Solution3 {
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
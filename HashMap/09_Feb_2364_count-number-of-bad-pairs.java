
import java.util.*;

class Solution {

    /**
     * j - i != nums[j] - nums[i]. can be written as nums[i]-i!=nums[j]-j;
     */
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        // find nums[i]-i and stored in nums[]
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - i;
        }
        long cnt = 0l;
        // stored the freq of each nums[i]-i in a map
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        for (int j = 1; j < n; j++) {
            // get the past freq
            int freq = (map.containsKey(nums[j])) ? map.get(nums[j]) : 0;
            int totalNum = j;
            int badPairs = totalNum - freq;
            cnt += badPairs;
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

        }

        return cnt;
    }

    // tc:O(n^2) SC:(1) TLE:59/65 passed
    public long countBadPairs1(int[] nums) {
        int n = nums.length;
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((j - i) != (nums[j] - nums[i])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}


import java.util.*;

class Solution {

    //O(N) SC:O(N+N+N)
    public int specialTriplets(int[] nums) {
        final int mod = 1000000007;
        long cnt = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int prefix[] = new int[n];
        for (int i = 0; i < n; i++) {
            int ele = nums[i];
            if (map.containsKey(ele * 2)) {
                prefix[i] = map.get(ele * 2);
            }
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        map = new HashMap<>();
        int suffix[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int ele = nums[i];
            if (map.containsKey(ele * 2)) {
                suffix[i] = map.get(ele * 2);
            }
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            cnt = (cnt + (long) prefix[i] * suffix[i]) % mod;
        }
        return (int) cnt % mod;

    }
}

class Solution_BF {

    //O(N^3) TLE 936/1121
    public int specialTriplets(int[] nums) {
        final int mod = 1000000007;
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] == nums[j] * 2 && nums[k] == nums[j] * 2) {
                        cnt++;
                    }
                }
            }
        }
        return cnt % mod;
    }
}

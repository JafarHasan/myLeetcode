
import java.util.*;

class Solution {

    //TC:O(N) SC:O(N)
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//we hv seen 0 sum 1 time
        int res = 0;
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

}

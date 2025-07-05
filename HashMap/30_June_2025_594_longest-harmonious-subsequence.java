
import java.util.*;

class Solution {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            //cnt freq of each element
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        //take ans
        int length = 0;
        for (int ele : nums) {
            if (map.containsKey(ele + 1)) {
                length = Math.max(map.get(ele) + map.get(ele + 1), length);
            }
        }
        return length;
    }
}


import java.util.*;

class Solution {

    //TC:O(n^2) SC:O(N)
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                idx.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int ele : idx) {
                if (Math.abs(i - ele) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}

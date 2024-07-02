
import java.util.*;

class Solution {

    // TC:O(N) SC:O(N)
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int ele : nums1) {
            set1.add(ele);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int ele : nums2) {
            if (set1.contains(ele)) {
                set2.add(ele);
            }
        }
        int i = 0;
        int ans[] = new int[set2.size()];
        for (int ele : set2) {
            ans[i++] = ele;
        }
        return ans;

    }
}
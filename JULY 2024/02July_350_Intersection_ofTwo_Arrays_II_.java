import java.util.*;

class Solution {
    // TC:O(N) SC:O(N)
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] f1 = new int[1001];
        int[] f2 = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            int ele = nums1[i];
            f1[ele]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            int ele = nums2[i];
            f2[ele]++;
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int ele = 0; ele < 1001; ele++) {
            if (f1[ele] != 0 && f2[ele] != 0) {
                int freq = Math.min(f1[ele], f2[ele]);
                while (freq-- > 0) {
                    al.add(ele);
                }
            }
        }
        // Convert ArrayList to array
        int i = 0;
        int[] array = new int[al.size()];
        for (int ele : al) {
            array[i++] = ele;
        }
        return array;

    }
}

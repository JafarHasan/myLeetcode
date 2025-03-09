
import java.util.*;
class Solution {
    // TC:O(N) SC:O(N+M)
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            int id1 = nums1[i][0], val1 = nums1[i][1];
            int id2 = nums2[j][0], val2 = nums2[j][1];
            if (id1 == id2) {
                list.add(new int[] { id1, val1 + val2 });
                i++;
                j++;
            } else if (id1 < id2) {
                list.add(new int[] { id1, val1 });
                i++;
            } else {
                list.add(new int[] { id2, val2 });
                j++;
            }
        }
        while (i < n) {
            list.add(nums1[i]);
            i++;
        }
        while (j < m) {
            list.add(nums2[j]);
            j++;
        }
        n = list.size();
        int ans[][] = new int[n][2];
        for (int k = 0; k < n; k++) {
            ans[k][0] = list.get(k)[0];
            ans[k][1] = list.get(k)[1];
        }
        return ans;
    }

    // TC:O(NlogN) SC:O(N) Using TreeMap Time taken to solve 9:55sec
    public int[][] mergeArrays_TreeMap(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int e[] : nums1) {
            map.put(e[0], e[1]);
        }
        for (int e[] : nums2) {
            if (map.containsKey(e[0])) {
                map.put(e[0], map.get(e[0]) + e[1]);
            } else {
                map.put(e[0], e[1]);
            }
        }
        int n = map.size();
        int ans[][] = new int[n][2];
        // System.out.println(map);
        int idx = 0;
        for (int key : map.keySet()) {
            ans[idx][0] = key;
            ans[idx][1] = map.get(key);
            idx++;
        }
        return ans;
    }
}
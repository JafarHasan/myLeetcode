
import java.util.*;

class Solution {

    // TC:O(N) SC:O(1)
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int ans[] = new int[n];
        int idx = 0;
        // find all smaller
        for (int ele : nums) {
            if (ele < pivot) {
                ans[idx++] = ele;
            }
        }
        // all equals
        for (int ele : nums) {
            if (ele == pivot) {
                ans[idx++] = ele;
            }
        }
        // all greater
        for (int ele : nums) {
            if (ele > pivot) {
                ans[idx++] = ele;
            }
        }
        return ans;
    }

    // TC:O(N) SC:O(N)
    public int[] pivotArray_usingExtraSpace(int[] nums, int pivot) {
        int n = nums.length;

        int ans[] = new int[n];
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int ele : nums) {
            if (ele < pivot) {
                smaller.add(ele);
            } else if (ele >= pivot) {
                greater.add(ele);
            }
        }
        int idx = 0;
        for (int ele : smaller) {
            ans[idx++] = ele;
        }
        for (int ele : greater) {
            if (ele == pivot) {
                ans[idx++] = pivot;
            }
        }
        for (int ele : greater) {
            if (ele > pivot) {
                ans[idx++] = ele;
            }
        }
        return ans;

    }
}

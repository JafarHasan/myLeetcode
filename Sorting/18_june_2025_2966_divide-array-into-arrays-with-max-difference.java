
import java.util.*;

class Solution {
//TC:O(NlogN) SC:O(1)
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int size = (int) n / 3;
        int ans[][] = new int[size][3];

        int row = 0;
        for (int i = 0; i < n; i += 3) {
            int a = nums[i], b = nums[i + 1], c = nums[i + 2];
            if (c - a > k) {
                return new int[0][0];//not possible

            }
            ans[row++] = new int[]{a, b, c};
        }
        return ans;
    }
}

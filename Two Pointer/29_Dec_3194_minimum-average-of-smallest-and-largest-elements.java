
import java.util.Arrays;

class Solution {
    // beats 97%
    /// Sorting and Two-pointer approach TC:O(nlogn) SC:O(1)
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = n - 1;
        double minAvg = Double.MAX_VALUE;
        while (i < j) {
            minAvg = Math.min(minAvg, (nums[i] + nums[j]) / 2.0);
            i++;
            j--;
        }
        return minAvg;
    }
}
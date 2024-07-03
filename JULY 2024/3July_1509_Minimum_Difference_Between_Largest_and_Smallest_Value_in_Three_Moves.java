import java.util.Arrays;

class Solution {

    // TC:O(NlogN) SC:O(1) with sorting
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        if (n <= 4)
            return 0;

        // for last three vales
        min = Math.min(min, nums[n - 4] - nums[0]);

        // for last two values one starting value
        min = Math.min(min, nums[n - 3] - nums[1]);

        // for last one value 2 starting values
        min = Math.min(min, nums[n - 2] - nums[2]);

        // for starting values
        min = Math.min(min, nums[n - 1] - nums[3]);

        return min;

    }

    // without sorting TC;O(N) SC:O(1)
    public int minDifference2(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return 0;
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min4 = min3;
                min3 = min2;
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min4 = min3;
                min3 = min2;
                min2 = num;
            } else if (num < min3) {
                min4 = min3;
                min3 = num;
            } else if (num < min4) {
                min4 = num;
            }

            if (num > max1) {
                max4 = max3;
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max4 = max3;
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max4 = max3;
                max3 = num;
            } else if (num > max4) {
                max4 = num;
            }
        }
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, max1 - min4);
        ans = Math.min(ans, max2 - min3);
        ans = Math.min(ans, max3 - min2);
        ans = Math.min(ans, max4 - min1);
        return ans;
    }
}
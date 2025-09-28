
import java.util.*;

class Solution {

    //O(NlogN) SC:O(1) passed
    private boolean isFormATraingle(int a, int b, int c) {
        return a + b > c && b + c > a && a + c > b;
    }

    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        int maxPer = 0;
        Arrays.sort(nums);
        for (int i = n - 3; i >= 0; i--) {
            if (isFormATraingle(nums[i], nums[i + 1], nums[i + 2])) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }

        }
        return maxPer;
    }
}

class Solution_BF {

    //O(N^3) SC:O(1) TLE 63/84 passed
    private boolean isFormATraingle(int a, int b, int c) {
        return a + b > c && b + c > a && a + c > b;
    }

    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        int maxPer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isFormATraingle(nums[i], nums[j], nums[k])) {
                        maxPer = Math.max(maxPer, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return maxPer;
    }
}

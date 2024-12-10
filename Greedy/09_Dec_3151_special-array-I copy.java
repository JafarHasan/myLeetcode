package Greedy;

class Solution {
    // TC:O(N) SC:O(1)
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            // if ((nums[i] % 2 == 0 && nums[i + 1] % 2 == 0) || (nums[i] % 2 == 1 &&
            // nums[i + 1] % 2 == 1)) {
            // return false;
            // }
            if (nums[i] % 2 == nums[i + 1] % 2)
                return false;

        }
        return true;
    }
}
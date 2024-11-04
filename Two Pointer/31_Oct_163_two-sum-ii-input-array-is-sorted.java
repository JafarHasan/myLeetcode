class Solution {
    // TC:O(N) SC:O(1)
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int n1 = nums[i];
            int n2 = nums[j];
            if (n1 + n2 == target) {
                return new int[] { i + 1, j + 1 };
            } else if (n1 + n2 > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[] { -1, -1 };
    }
}
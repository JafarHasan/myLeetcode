class Solution {
    // TC:O(N) SC:O(1) 100% beats
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int idx = n - 1;
        int ans[] = new int[n];
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                ans[idx--] = nums[right] * nums[right];
                right--;
            } else {
                ans[idx--] = nums[left] * nums[left];
                left++;
            }
        }
        return ans;
    }
}

class Solution {

    //TC:O(N) SC:O(1)
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int maxSum = 0;
        maxSum = Math.max(maxSum, sum);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];

            } else {
                sum = nums[i];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}

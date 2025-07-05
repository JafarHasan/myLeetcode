
// BUY AND SELL STOCK PROBLEM
class Solution {

    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int maxDiff = 0;
        for (int val : nums) {
            if (val > min) {
                int diff = val - min;
                maxDiff = Math.max(maxDiff, diff);
            }
            min = Math.min(min, val);
        }
        return maxDiff == 0 ? -1 : maxDiff;
    }
}

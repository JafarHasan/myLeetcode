
class Solution {

    //TC:O(2N)=O(N) SC:O(1)
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 1;
        int length = 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                length = 1;
            }
        }
        length = 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                length = 1;
            }
        }
        return maxLength;

    }
}

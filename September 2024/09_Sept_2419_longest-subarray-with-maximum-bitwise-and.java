class Solution {
    // TC:O(N) SC:O(1)
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int ele : nums) {
            max = Math.max(max, ele);
        }
        int len = 0;
        int ansLen = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                len++;
            } else {
                ansLen = Math.max(ansLen, len);
                len = 0;
            }
        }
        // if last element is max ansLen will not be updated so need to upudate here
        ansLen = Math.max(len, ansLen);
        return ansLen;
    }
}
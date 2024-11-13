class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0; // Initialize the left pointer
        int right = 0; // Initialize the right pointer
        int zerosAllowed = 1; // Initialize the number of zeros allowed to flip to ones

        // Loop through the array using the right pointer
        while (right < nums.length) {
            // If the current element is 0, decrement the number of zeros allowed
            if (nums[right++] == 0) {
                zerosAllowed--;
            }
            // If no zeros are allowed and the left element is 0, increment the left pointer
            // and the number of zeros allowed
            if (zerosAllowed < 0 && nums[left++] == 0) {
                zerosAllowed++;
            }
        }
        // Compute the length of the longest sequence of 1s (with at most one 0 flipped to 1)
        return right - left;
    }
}

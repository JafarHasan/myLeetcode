
class Solution {

    public int longestSubarray(int[] nums) {
        int i = 0, j = 0, k = 0, len = 0, zero = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                zero++;
                j = i;
                k = i;
                //slide window left utill get 0
                while (j > 0 && nums[j - 1] == 1) {
                    j--;
                }
                //slide window right utill get 0
                while (k < nums.length - 1 && nums[k + 1] == 1) {
                    k++;
                }
                len = Math.max(len, k - j);
            }
            i++;

        }
        if (zero == 0) {
            return nums.length - 1;
        }
        return len;
    }
}

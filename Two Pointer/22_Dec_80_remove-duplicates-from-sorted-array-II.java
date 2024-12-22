
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (j == 1 || nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n;
        int i = 1, idx = 1;
        int dup = 1;
        while (i < n) {
            if (nums[i] == nums[i - 1]) {
                dup++;
            } else {
                dup = 1;
            }
            if (dup < 3) {
                nums[idx++] = nums[i];
            }
            i++;
        }
        return idx;

    }
}
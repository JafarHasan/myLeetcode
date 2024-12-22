class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        int n = nums.length;
        int i = 1;
        while (i < n) {
            while (i < n && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i < n)
                nums[idx++] = nums[i];
            i++;
        }

        return idx;
    }

    public int removeDuplicates1(int[] nums) {
        int idx = 1;
        int n = nums.length;
        int i = 1;
        while (i < n) {
            while (i < n && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i < n)
                nums[idx++] = nums[i];
            i++;
        }
        return idx;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
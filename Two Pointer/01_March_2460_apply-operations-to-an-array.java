
class Solution {

    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int idx = 0;
        int ans[] = new int[n];
        for (int ele : nums) {
            if (ele != 0) {
                ans[idx++] = ele;
            }
        }
        return ans;
    }

    // TC:O(2*n)=O(N) SC:O(1)
    public int[] applyOperations_approch_one(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        // shift all zero to end
        int idx = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else {
                nums[idx++] = nums[i];
            }
        }
        while (cnt-- > 0) {
            nums[idx++] = 0;
        }
        return nums;

    }
}

class Solution {
    // TC:O(NxK) SC:O(1)
    private int getMinIdx(int[] arr) {// TC:O(N)
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                idx = i;
                min = arr[i];
            }
        }
        return idx;
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while (k-- > 0) {
            int idx = getMinIdx(nums);
            nums[idx] = nums[idx] * multiplier;
        }
        return nums;
    }
}

class Solution {
    // TC:O(N^2) Bubble sort SC:O(1)
    private boolean setBitsSame(int x, int y) {
        return Integer.bitCount(x) == Integer.bitCount(y);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean canSortArray(int[] nums) {
        // Bubble sort swap if(nums[j]>nums[j+1])
        // plus no of set bits should be equals
        int n = nums.length;
        boolean isSwap = true;
        for (int i = 0; i < n; i++) {
            isSwap = false;
            // in every pass the max element bubbles up to its curr pos
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] <= nums[j + 1]) {
                    // no swap
                    continue;
                } else {
                    // need swap so check is noOFSetbits are same then only we can swap
                    if (setBitsSame(nums[j], nums[j + 1])) {
                        swap(nums, j, j + 1);
                        isSwap = true;
                    } else {
                        return false;
                    }
                }
            }
            if (!isSwap) {
                // no swap hence array is sorted
                break;
            }
        }
        return true;

    }
}

class Solution2 {

    // TC:O(N^2) SC:O(1)
    private boolean isSorted(int[] nums, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void rotateLeft(int[] nums, int n) {
        int temp = nums[0];
        for (int i = 1; i < n; i++) {
            nums[i - 1] = nums[i];
        }
        nums[n - 1] = temp;
    }

    public boolean check(int[] nums) {
        int n = nums.length;
        // if array is already sorted
        if (isSorted(nums, n)) {
            return true;// 0 times

                }for (int i = 0; i < n; i++) {
            // roatate array by 1 pos left
            rotateLeft(nums, n);
            // if sorted return true
            if (isSorted(nums, n)) {
                return true;
            }
        }
        return false;

    }
}

class Solution {

    // TC:O(N) SC:O(1)
    public boolean check(int[] nums) {
        int n = nums.length;
        int rotate = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                rotate++;
            }
        }
        if (nums[n - 1] > nums[0]) {
            rotate++;
        }
        return rotate <= 1;
    }
}

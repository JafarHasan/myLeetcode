
class Solution {
    //TC:O(N) SC:O(N)

    public int pivotIndex2(int[] nums) {
        int n = nums.length;
        int right[] = new int[n];
        int left[] = new int[n];
        right[0] = nums[0];
        for (int i = 1; i < n; i++) {
            right[i] = right[i - 1] + nums[i];
        }
        left[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            left[i] = left[i + 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (right[i] == left[i]) {
                return i;
            }
        }
        return -1;

    }

    //TC:O(N) SC:O(N)
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        //find total sum
        int total = 0;
        for (int ele : nums) {
            total += ele;
        }

        //find the left sum and check total-leftSum-nums[i]==leftSum
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSum == (total - leftSum - nums[i])) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;

    }

}

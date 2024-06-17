class Solution {
    //TC:O(N) SC:O(1) greedy
    public int minPatches(int[] nums, int n) {
        long sum = 0; // sum may be out of range for int
        int cnt = 0;
        int i = 0;

        while (sum < n) {
            if (i < nums.length && nums[i] <= sum + 1) {
                sum += nums[i];
                i++;
            } else {
                sum += sum + 1; // Add sum + 1 to `sum`, and now we need one patch
                cnt++;
            }
        }
        return cnt;
    }
}
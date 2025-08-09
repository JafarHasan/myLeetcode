
class Solution {

    //TC:O(N) SC:O(1)
    public int countHillValley(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        int j = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[j] && nums[i] > nums[i + 1] || nums[i] < nums[j] && nums[i] < nums[i + 1]) {
                cnt++;
                j = i;

            }

        }
        return cnt;
    }
}

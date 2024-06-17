
class Solution {
    // TC;O(NlogN) SC:O(1) //Greedy
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int cnt = nums[0];
        int move = 0;
        for (int i = 1; i < nums.length; i++) {
            cnt++;
            if (nums[i] < cnt) {
                move += Math.abs(nums[i] - cnt);
            } else {
                cnt = nums[i];
            }
        }
        return move;

    }
}
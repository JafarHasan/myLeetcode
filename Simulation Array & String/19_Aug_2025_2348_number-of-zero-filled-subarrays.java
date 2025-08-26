
class Solution {

    //TC:O(N) SC:O(1)
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long cnt = 0;
        int n = nums.length, i = 0;
        while (i < n) {
            cnt = 0;
            if (nums[i] == 0) {

                while (i < n && nums[i] == 0) {
                    i++;
                    cnt++;
                }
            } else {
                i++;
            }
            ans += cnt * (cnt + 1) / 2;
        }
        return ans;
    }
}

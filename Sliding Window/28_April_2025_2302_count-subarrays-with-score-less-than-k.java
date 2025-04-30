
class Solution {

    ///TC:O(N) SC:O(1) Sliding Window
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long cnt = 0;
        int i = 0, j = 0;
        long sum = 0;
        while (i < n) {
            sum += nums[i];
            while (j <= i && sum * (i - j + 1) >= k) {
                sum -= nums[j];
                j++;
            }
            cnt += (i - j + 1);
            i++;
        }
        return cnt;
    }
}


class Solution {

    // TC:O(N) SC:O(1)beats 100% 2ms
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long total = 0;
        // get total sum
        for (int ele : nums) {
            total += ele;
        }
        int split = 0;
        long sum = 0;// running sum
        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];
            // if runnung sum>=next suffix sum i e total-sum;
            if (sum >= total - sum) {
                split++;
            }

        }
        return split;
    }

    // TC:O(N) SC:O(N)
    public int waysToSplitArray1(int[] nums) {
        int n = nums.length;

        long suffix[] = new long[n];
        suffix[n - 1] = nums[n - 1];
        // store suffix sum
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        int split = 0;
        long sum = 0;// running sum
        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];
            // if runnung sum>=i+1-n-1 sum its a valid split
            if (sum >= suffix[i + 1]) {
                split++;
            }
        }
        return split;
    }
}

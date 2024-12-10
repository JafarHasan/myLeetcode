class Solution {

    // TC:O(M) SC:O(N)
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        boolean[] ans = new boolean[m]; // All will be false by default
        // find comulative sum (total invalid indices cnt till any i idx)
        int[] cSum = new int[n];
        cSum[0] = 0;// 0 invalid element till 0 idx
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                cSum[i] = cSum[i - 1] + 1;
            } else {
                cSum[i] = cSum[i - 1];
            }
        }
        int idx = 0;
        for (int row[] : queries) {
            int start = row[0];
            int end = row[1];
            // if(cSum[start]-cSum[end]==0){
            // ans[idx]=true;
            // }
            ans[idx] = (cSum[end] - cSum[start]) == 0;
            idx++;
        }
        return ans;

    }
}

class Solution2 {
    // This is a BT approach
    // TC:O(NxM) SC:O(1) TLE 535/536 passed
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int m = queries.length;
        boolean[] ans = new boolean[m]; // All will be false by default

        for (int idx = 0; idx < m; idx++) {
            int start = queries[idx][0];
            int end = queries[idx][1];

            // Check if the subarray is special
            ans[idx] = isSpecial(start, end, nums);
        }
        return ans;
    }

    private boolean isSpecial(int start, int end, int[] nums) {
        // We need to check up to end - 1 as per the non-inclusive end
        for (int i = start; i < end; i++) {
            // Check if the current and next number have different parities
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false;
            }
        }
        return true;
    }

}
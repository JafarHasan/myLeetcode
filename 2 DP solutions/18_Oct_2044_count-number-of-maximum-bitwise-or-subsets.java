class Solution {
    // 8ms TC:O(n+1*maxOR+1)=>O(n*maxOR) SC;O(n*maxOR)
    // Memoization
    public int countMaxOrSubsets(int[] nums) {

        // find max OR
        // take OR of all elements
        int maxOR = 0;
        for (int ele : nums) {
            maxOR |= ele;
        }
        int dp[][] = new int[nums.length + 1][maxOR + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int currOR = 0;
        return cntSubset(0, currOR, nums, maxOR, dp);

    }

    private int cntSubset(int idx, int currOR, int[] nums, int maxOR, int[][] dp) {
        if (idx == nums.length) {
            if (currOR == maxOR) {
                return 1;// found one subset
            }
            return 0;
        }
        if (dp[idx][currOR] != -1)
            return dp[idx][currOR];
        // pick nums[idx]
        int takeCnt = cntSubset(idx + 1, currOR | nums[idx], nums, maxOR, dp);
        // not pick
        int notTake = cntSubset(idx + 1, currOR, nums, maxOR, dp);

        return dp[idx][currOR] = takeCnt + notTake;
    }
}



class Solution2 {
    // 8ms TC:O(2^n) SC;O(n)
    public int countMaxOrSubsets(int[] nums) {
        // find max OR
        // take OR of all elements
        int maxOR = 0;
        for (int ele : nums) {
            maxOR |= ele;
        }
        int currOR = 0;
        return cntSubset(0, currOR, nums, maxOR);

    }

    private int cntSubset(int idx, int currOR, int[] nums, int maxOR) {
        if (idx == nums.length) {
            if (currOR == maxOR) {
                return 1;// found one subset
            }
            return 0;
        }
        // pick nums[idx]
        int takeCnt = cntSubset(idx + 1, currOR | nums[idx], nums, maxOR);
        // not pick
        int notTake = cntSubset(idx + 1, currOR, nums, maxOR);

        return takeCnt + notTake;
    }
}
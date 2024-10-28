package Greedy;

class Solution {
    // TC:O(N) SC:O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalEarn = 0;
        int totalSpend = 0;
        for (int i = 0; i < n; i++) {
            totalEarn += gas[i];
            totalSpend += cost[i];
        }
        if (totalSpend > totalEarn)
            return -1;

        int currGas = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            currGas += gas[i] - cost[i];
            // if my total curr gas <=0 means cant move further
            // start from next idx and reset currGas=0;
            if (currGas < 0) {

                idx = i + 1;// next idx may be my ans
                currGas = 0;
            }
        }
        return idx;
    }
}
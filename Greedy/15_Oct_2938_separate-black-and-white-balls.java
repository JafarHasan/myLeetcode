package Greedy;

class Solution {
    // TC:O(N) SC:O(1) 7ms best 100% beats
    public long minimumSteps(String s) {
        long cnt0 = 0;
        long steps = 0;
        // itrarte right->left and cnt0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                cnt0++;
            }
            // if we got 1 means all its left 0 hv to be shifted right so add cnt0 in ans
            else {
                steps += cnt0;
            }
        }
        return steps;
    }
}
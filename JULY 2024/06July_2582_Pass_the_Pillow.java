class Solution {
    // TC:O(1) SC:O(1)
    public int passThePillow(int n, int time) {
        int round = time / (n - 1);
        int mod = time % (n - 1);
        int ans = 0;
        if (round % 2 == 0) {
            ans = 1 + mod;
        } else {
            ans = n - mod;
        }
        return ans;
    }
}
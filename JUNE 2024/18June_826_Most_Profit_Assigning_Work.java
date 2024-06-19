class Solution {
    // BruteFore TC:O(NxM) SC:O(1)
    public int maxProfitAssignment(int[] diff, int[] pro, int[] wkr) {
        int max = 0;
        int n = diff.length;
        int maxPro = 0;
        int sum = 0;
        for (int i = 0; i < wkr.length; i++) {
            int difi = wkr[i];
            maxPro = 0;
            for (int j = 0; j < n; j++) {
                if (difi >= diff[j]) {
                    maxPro = Math.max(maxPro, pro[j]);
                }
            }
            sum += maxPro;
        }
        return sum;
    }
}

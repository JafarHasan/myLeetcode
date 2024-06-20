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

    // Optimization
    // TC:O(N+M+maxwrkr+1)=>O(N) SC:O(jobs.length())
    public int maxProfitAssignment(int[] diff, int[] profit, int[] wkr) {
        int max = 0;
        int n = diff.length;
        int m = wkr.length;

        // find the maximum workr (maximum difficulty level)
        int maxwrkr = Integer.MIN_VALUE;
        for (int ele : wkr) {
            maxwrkr = Math.max(maxwrkr, ele);
        }

        int jobs[] = new int[maxwrkr + 1];
        // fill the jobs array with difficulty profit
        for (int i = 0; i < n; i++) {
            int ele = diff[i];
            if (ele <= maxwrkr) // avoiding greater difficulty than maxwrkr
                jobs[ele] = Math.max(jobs[ele], profit[i]);
        }

        // fill the remaining space (currently 0)with max(jobs[i],jobs[i-1])
        for (int i = 1; i < jobs.length; i++) {
            jobs[i] = Math.max(jobs[i], jobs[i - 1]);
        }

        // itearte over wrkr array and check difficulty in jobs and calculate sum
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int idx = wkr[i];
            sum += jobs[idx];
        }
        return sum;
    }
}

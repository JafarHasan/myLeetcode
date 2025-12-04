
class Solution {

    public long maxRunTime(int n, int[] batt) {
        long lo = Long.MAX_VALUE;
        long sum = 0;
        for (int ele : batt) {
            lo = Math.min(lo, ele);
            sum += ele;
        }
        long hi = sum / n;
        long pans = -1;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (isPossible(n, batt, mid)) {
                pans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return pans;
    }

    private boolean isPossible(int n, int[] batt, long mid) {
        long target = n * mid;
        long sum = 0;
        for (int i = 0; i < batt.length; i++) {
            sum += Math.min(batt[i], mid);
            if (sum >= target) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public long minimumTime(int[] time, int totalTrips) {

        long lo = Long.MAX_VALUE, hi = 0;
        for (int ele : time) {
            lo = Math.min(lo, ele);

        }
        hi = lo * totalTrips;

        //BS
        long pans = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (isPossible(time, mid, totalTrips)) {
                pans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return pans;
    }

    private boolean isPossible(int[] time, long mid, int trip) {
        long total = 0;
        for (int ele : time) {
            total += mid / ele;
        }
        return total >= trip;
    }
}
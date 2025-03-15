class Solution {
    // TC:O(log(max)*n)
    // SC:O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int hi = Integer.MIN_VALUE;
        for (int ele : piles) {
            hi = Math.max(hi, ele);
        }
        int lo = 1;
        int pans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossibleToEat(piles, mid, h)) {
                pans=mid;
                hi = mid - 1;// finding more min ans
            } else {
                lo = mid + 1;
            }
        }
        return pans;
    }

    private boolean isPossibleToEat(int[] piles, int mid, int h) {
        int cnt = 0;
        for (int i = 0; i < piles.length; i++) {
            cnt += (piles[i] / mid);
            if (piles[i] % mid != 0) {
                cnt++;
            }
            if (cnt > h) {
                return false;
            }
        }
        return cnt <= h;
    }
}
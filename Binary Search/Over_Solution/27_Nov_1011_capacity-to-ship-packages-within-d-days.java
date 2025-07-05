
class Solution {

    //TC:O(NlogN) SC:O(1)
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int hi = 0;
        for (int ele : weights) {
            hi += ele;
        }
        // range 0->when we cant ship
        // sum of all->when we can ship all in one day
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            if (isPossible(mid, weights, days)) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isPossible(int mid, int[] wt, int days) {
        int sum = 0, dayCnt = 1;
        for (int i = 0; i < wt.length; i++) {
            //if we can take curr weight than 
            if (sum + wt[i] <= mid) //add it in cutt total
            {
                sum += wt[i]; 
            }//if curr weight is greater than valid weight we cant ship that
            else if (wt[i] > mid) {
                return false;
                //if we cant take curr weight so
            } else {
                //new day will start
                dayCnt++;
                //add new day weight to our curr total as new 
                sum = wt[i];
            }

        }
        return dayCnt <= days;
    }
}

class Solution_Myself {

    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;
        for (int ele : weights) {
            lo = Math.max(lo, ele);
            hi += ele;
        }

        //BS
        int pans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossibleToShip(weights, mid, days)) {
                pans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return pans;
    }

    private boolean isPossibleToShip(int[] wt, int mid, int d) {
        int cntWt = 0;
        int day = 1;
        for (int ele : wt) {
            if (cntWt + ele <= mid) {
                cntWt += ele;
            } else {
                day++;
                cntWt = ele;
            }

        }
        return day <= d;
    }
}

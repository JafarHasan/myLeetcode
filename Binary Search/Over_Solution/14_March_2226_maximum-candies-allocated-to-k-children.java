
class Solution {

    // TC:O(log(MaxCandy)*N)
    private boolean isPossibleToDistribute(int[] candies, int mid, long k) {

        for (int i = 0; i < candies.length; i++) {
            k -= candies[i] / mid;
            if (k <= 0) {
                return true;
            }
        }
        return k <= 0;
    }

    private boolean isPossibleToDistribute_Can_Also_Be_written_as(int[] cand, int mid, long k) {
        long cnt = 0;
        for (int i = 0; i < cand.length; i++) {
            cnt += cand[i] / mid;
            if (cnt >= k) {
                return true;
            }
        }
        return cnt >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int maxC = 0;
        long sum = 0;
        for (int i : candies) {
            sum += i;
            maxC = Math.max(maxC, i);
        }
        if (sum < k) {
            return 0;
        }

        // maxCandy=maXEle;
        // minCandy=k;
        // range maxCandy-------minCandy
        int lo = 1, hi = maxC;
        // binary Search
        int pans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossibleToDistribute(candies, mid, k)) {
                pans = mid;
                // want max Ans so go left (array is in decreasing order)
                lo = mid + 1;

            } else {
                hi = mid - 1;
            }
        }
        return pans;
    }

    // Brute Force TC:O(N^2) SC:O(1) 36/100 passed
    public int maximumCandies_BF(int[] candies, long k) {
        int n = candies.length;
        int maxC = 0;
        long sum = 0;
        for (int i : candies) {
            sum += i;
            maxC = Math.max(maxC, i);
        }
        // if candies is less than no of children not possible than
        if (sum < k) {
            return 0;
        }
        // start giving the maxCandy and check for all less no of candies 1 by 1
        for (int i = maxC; i >= 1; i--) {
            int cnt = 0;
            // check for all
            for (int j = 0; j < n; j++) {
                // no of children can get the maxCandy from this pile
                cnt += (int) candies[j] / i;
            }
            // if no of students (who can get the candy) is more than required(k)return this
            // maxCandy
            if (cnt >= k) {
                return i;
            }
        }
        // not possible
        return 0;

    }
}

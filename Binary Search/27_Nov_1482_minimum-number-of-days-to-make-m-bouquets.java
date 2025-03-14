class Solution {
    public int minDays(int[] bloom, int m, int k) {
        int n = bloom.length;
        if (m > n / k)
            return -1;
        int low = -1;
        int hi = 0;
        for (int ele : bloom) {
            hi = Math.max(ele, hi);
        }
        //rangr 0->when no flower will be blooming
        //max ele=when all flower will be blomming
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            if (isPossible(mid, bloom, m, k)) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    private boolean isPossible(int mid, int[] bloom, int m, int k) {
        int flower = 0, bouquet = 0;
        for (int i = 0; i < bloom.length; i++) {
            //if flower bloomed means available 
            if (bloom[i] <= mid) {
                //then take it
                flower++;
                //if we hv k flower
                if (flower == k) {
                    //we can make a bouquet 
                    bouquet++;
                    //now we used all flowers so we have 0 flower
                    flower = 0;
                }
                //if flower didnt bloom means we cant take that
            } else {
                //so we hv 0 flower
                flower = 0;
            }
        }
        return bouquet >= m;
    }
}

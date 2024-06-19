class Solution {
    // Binary Search
    // TC:O(Nlog(maxDay))
    // SC:O(1)
    public int minDays(int[] bloomDay, int m, int k) {

        if (m > bloomDay.length / k) {
            return -1;
        }
        int low = -1;
        int max = Integer.MIN_VALUE;
        for (int ele : bloomDay)
            max = Math.max(max, ele);
        int high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isPossible(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0, flowers = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
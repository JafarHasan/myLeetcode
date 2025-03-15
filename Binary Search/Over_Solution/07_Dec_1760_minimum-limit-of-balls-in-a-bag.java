
class Solution {
    // TC:O(Nlog(max(nums))) SC:O(1) n=length of nums
    public int minimumSize(int[] nums, int maxOp) {
        // range
        // 1 as a bag can contains at least 1 balls
        // max in nums as a bag can contains at max no of balls
        int lo = 1;
        int hi = Integer.MIN_VALUE;
        for (int ele : nums) {
            hi = Math.max(ele, hi);
        }
        // Binary Search
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(nums, mid, maxOp)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;

    }

    private boolean isPossible(int[] nums, int mid, int maxOp) {
        int operations = 0;

        // Calculate the number of operations needed to ensure all bags are ≤ mid
        for (int num : nums) {
            if (num > mid) {
                operations += (num - 1) / mid; // This gives how many full bags of size mid we can fit.
            }
            // If at any point we exceed the maximum allowed operations, return false
            if (operations > maxOp) {
                return false;
            }
        }
        return true;
    }
}
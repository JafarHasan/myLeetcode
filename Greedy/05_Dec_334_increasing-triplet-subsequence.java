package Greedy;

class Solution {
    // Failed 67/84 test passed
    // it is only checking continuous triplet
    public boolean increasingTriplet1(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return false;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] < nums[i + 1] && nums[i + 1] < nums[i + 2]) {
                return true;
            }
        }
        return false;

    }

    /*
     * SOLUTION 2:
     * T.C. O(n)
     * S.C. O(n)
     */

    // <---left min | nums[i] | right max---->
    public boolean increasingTriplet2(int[] nums) {
        int n = nums.length;
        int[] lMin = new int[n];
        int[] rMax = new int[n];

        // left minimum
        lMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            lMin[i] = Math.min(lMin[i - 1], nums[i]);
        }

        // right max
        rMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (lMin[i] < nums[i] && nums[i] < rMax[i])
                return true;
        }
        return false;

    }

    /**
     * SOLUTION 3:
     * T.C. O(n)
     * S.C. O(1)
     */
    public boolean increasingTriplet(int[] nums) {
        int first, second;
        first = second = Integer.MAX_VALUE;
        for (int ele : nums) {
            if (ele <= first) {
                first = ele;
            } else if (ele <= second) {
                second = ele;
            } else {
                return true;
            }
        }
        return false;
    }
}
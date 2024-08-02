
class Solution {
    // TC:O(N) SC:O(2*N)
    public int minSwaps(int[] nums) {
        int noOfOne = 0;
        // counting the no of ones
        for (int ele : nums) {
            if (ele == 1) {
                noOfOne++;
            }
        }
        int n = nums.length;
        // for circular property
        int temp[] = new int[n * 2];
        for (int i = 0; i < 2 * n; i++) {
            temp[i] = nums[i % n];
        }
        int currOne = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < 2 * n; i++) {
            if (i >= noOfOne && temp[i - noOfOne] == 1) {
                currOne--;
            }
            if (temp[i] == 1) {
                currOne++;
            }
            ans = Math.max(ans, currOne);

        }
        return noOfOne - ans;

    }
}
/*
 * Explanation:
 * 
 * Count number of ones in nums, let the number of ones be stored in the
 * variable ones
 * Append nums to nums because we have to look at it as a circular array
 * Find the maximum number of ones in a window of size ones in the new array
 * Number of swaps = ones - maximum number of ones in a window of size ones
 */
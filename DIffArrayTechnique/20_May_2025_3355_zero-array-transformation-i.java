
class Solution {

    //difference ARRAY TECHNIQUE
    //TC:O(N) SC:O(2N)=O(N)
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        for (int q[] : queries) {
            int s = q[0];
            int e = q[1];
            int x = 1;//which value we can to increase or decrease(here 1)
            differenceArray[s] += x;
            if (e + 1 < n) {
                differenceArray[e + 1] -= x;
            }
        }
        int cummulativeSum[] = new int[n];
        int cSum = 0;
        for (int i = 0; i < n; i++) {
            cSum += differenceArray[i];
            cummulativeSum[i] = cSum;
        }
        for (int i = 0; i < n; i++) {
            if (cummulativeSum[i] < nums[i]) {
                return false;
            }
        }
        return true;

    }
}

class Solution_BruteForce {

    // TLE:665/668 passed
    // TC:O(N*N) when range is 0->n-1 so decrement() will take N as well
    /// SC:O(1)
    private boolean check(int[] arr) {
        for (int ele : arr) {
            if (ele > 0) {
                return false;
            }
        }
        return true;
    }

    private void decrement(int[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (arr[i] == 0) {
                continue;
            } else if (arr[i] < 1) {
                arr[i] = 0;
            } else {
                arr[i] -= 1;
            }
        }
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        if (check(nums)) {
            return true;
        }
        int step = 0;
        for (int row[] : queries) {
            int l = row[0];
            int r = row[1];

            decrement(nums, l, r);
            if (check(nums)) {
                return true;
            }

        }
        if (check(nums)) {
            return true;
        }

        return false;
    }
}

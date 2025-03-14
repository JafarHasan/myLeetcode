
import java.util.*;
import java.util.function.IntPredicate;

class Solution {

    // O(NlogN) SC:O(1) Binary Search
    private int lowerBound(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int res = arr.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                res = mid;
                hi = mid - 1;
            }
        }
        // {0,0,0,0} so pos=N means result =N
        return res;
    }

    public int maximumCount(int[] nums) {
        int negativeCnt = lowerBound(nums, 0); // first number >=0
        int positiveCnt = lowerBound(nums, 1);// first number >=1;

        return Math.max(nums.length - positiveCnt, negativeCnt);
    }

    // TC:O(N) SC:O(1) slow
    public int maximumCount_UsingStream(int[] nums) {
        IntPredicate lembdaP = num -> num > 0;
        IntPredicate lembdaN = num -> num < 0;

        int pos = (int) Arrays.stream(nums).filter(lembdaP).count();
        int neg = (int) Arrays.stream(nums).filter(lembdaN).count();
        return Math.max(pos, neg);

    }

    // TC:O(N) SC:O(1)
    public int maximumCount_LinearSearch(int[] nums) {
        int negativeCnt = 0, positiveCnt = 0;
        for (int ele : nums) {
            if (ele > 0) {
                positiveCnt++;
            } else if (ele < 0) {
                negativeCnt++;
            }
        }
        return Math.max(positiveCnt, negativeCnt);
    }
}

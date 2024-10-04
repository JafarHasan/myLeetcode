import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {

        long sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % p == 0)
            return 0;

        int requiredRem = (int) (sum % p);
        // if any sub array contains this remainder then by removing that sub array
        // we get the remaining array divisible by p

        // Now we traverse the array and for each index i, we search if
        // we could find any sub array [prev, i] such that remainder of sum
        // of the sub array [prev, i] is the required remainder

        // stores the rem of sub array idx : [0, i]
        HashMap<Integer, Integer> rem = new HashMap<>();
        rem.put(0, -1);

        sum = 0;
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int curRem = (int) (sum % p);

            // find if any sub array had the required remainder
            int searchFor = curRem - requiredRem;
            if (searchFor < 0)
                searchFor += p;
            if (rem.containsKey(searchFor))
                res = Math.min(res, i - rem.get(searchFor));

            // if remainder repeats then override it with latest sub array
            rem.put(curRem, i);
        }
        return (res == nums.length) ? -1 : res;
    }
}
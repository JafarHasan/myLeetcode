
import java.util.*;

class Solution {
    //TC:O(nlogn) SC:O(1)

    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[nums.length - 1];
        int sum = prev;
        for (int i = nums.length - 2; i >= 0; i--) {
            int n = nums[i];
            if (n <= 0) {
                return sum;
            } else if (n != prev) {
                sum = sum + n;
            }
            prev = n;
        }
        return sum;
    }
}

class Solution_2nd {

    //TC:O(n) SC:O(N)
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = -101;
        for (int ele : nums) {
            max = Math.max(max, ele);
            if (ele > 0) {
                set.add(ele);
            }
        }
        if (max < 0) {
            return max;
        }
        int sum = 0;
        for (int ele : set) {
            sum += ele;
        }
        return sum;
    }
}

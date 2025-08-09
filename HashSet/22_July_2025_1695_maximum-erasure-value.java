
import java.util.*;

class Solution {

    //TC:O(N) SC:O(N)
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0, j = 0;
        int sum = 0, max = 0;
        HashSet<Integer> set = new HashSet<>();
        while (i < nums.length) {
            //if set contains curr ele already
            //remove all elements untill curr ele is removed from the set
            //and decrease sum as well bcz we are not taking that subsarray
            if (set.contains(nums[i])) {
                while (j < i && set.contains(nums[i])) {
                    sum -= nums[j];
                    set.remove(nums[j]);
                    j++;
                }
            }
            //if its a new ele add it to sum
            //add it to set
            //update max
            sum += nums[i];
            set.add(nums[i]);
            max = Math.max(max, sum);
            //move to next ele
            i++;
        }
        return max;
    }
}

class Solution_Again {

    public int maximumUniqueSubarray(int[] nums) {
        int i = 0, j = 0;
        int sum = 0, max = 0;
        HashSet<Integer> set = new HashSet<>();
        while (i < nums.length) {
            if (!set.contains(nums[i])) {
                sum += nums[i];
                set.add(nums[i]);
                max = Math.max(max, sum);
            } else {
                while (j < i && set.contains(nums[i])) {
                    sum -= nums[j];
                    set.remove(nums[j]);
                    j++;
                }
                sum += nums[i];
                set.add(nums[i]);
                max = Math.max(max, sum);
            }
            i++;
        }
        return max;
    }
}

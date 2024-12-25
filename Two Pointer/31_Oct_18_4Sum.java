
import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates for the first element
            }

            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue; // Skip duplicates for the second element
                }

                int k = j + 1, l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; // Use long to prevent overflow

                    if (sum > target) {
                        l--; // Reduce sum by moving the right pointer
                    } else if (sum < target) {
                        k++; // Increase sum by moving the left pointer
                    } else {
                        // Found a valid quadruplet
                        List<Integer> sub = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(sub);

                        // Move pointers to avoid duplicates
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }

        return ans;
    }
}

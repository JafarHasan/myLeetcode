import java.util.*;

class Solution {
    // TC:O(N^2) SC:O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the array
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;// avoiding repeating elemets
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) { // if sum<0 so i want bigger no to be my sum=0 hence go right bca array is
                               // sorted
                    j++;
                } else if (sum > 0) {// if sum>0 so i want smaller no to be my sum=0 hence go left bca array is
                                     // sorted
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    Collections.addAll(list, nums[i], nums[j], nums[k]);
                    result.add(list);
                    j++;
                    k--;
                    

                    //avoiding duplicate
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    //avoiding duplicate
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return result;
    }
}
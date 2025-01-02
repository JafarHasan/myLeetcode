import java.util.*;
class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        HashSet<Double> set=new HashSet<>();
        int i=0,j=n-1;
        while(i<j){
            set.add((nums[i]+nums[j])/2.0);
            i++;
            j--;

        }
        return set.size();

    }
}
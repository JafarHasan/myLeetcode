
import java.util.*;

class FindSumPairs {

    Map<Integer, Integer> map2;
    int[] nums1;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map2 = new HashMap<>();
        for (int ele : nums2) {
            map2.put(ele, map2.getOrDefault(ele, 0) + 1);
        }

    }

    public void add(int index, int val) {
        //decrese the freq of val in nums2=>map2
        int actual = nums2[index];
        map2.put(actual, map2.get(actual) - 1);
        if (map2.get(actual) == 0) {
            map2.remove(actual);
        }
        //update nums2 as well add this val
        nums2[index] += val;
        //increase the fre in mp2
        map2.put(nums2[index], map2.getOrDefault(nums2[index], 0) + 1);
    }

    //we need to traverse the nums2 again and again and nums2.length=10^5
    //instead use nums1 to traverse bcz nums1.length=1000 only
    //its better to traverse 1000 again and again for cnt than traverse 10^5
    public int count(int tot) {
        int cnt = 0;
        for (int ele : nums1) {
            if (map2.containsKey(tot - ele)) {
                cnt += map2.get(tot - ele);
            }
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2); obj.add(index,val); int
 * param_2 = obj.count(tot);
 */

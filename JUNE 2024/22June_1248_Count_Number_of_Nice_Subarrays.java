
class Solution {
    // TC:O(N) SC:O(N) HashMap Sliding Window Solution
    public int numberOfSubarrays(int[] nums, int k) {
        int cntNice = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);// we hv seen 0 sum 1 time
        int no = 0;
        for (int ele : nums) {
            // considering every odd no as 1 and even no as 0
            // and trying to find cnt of subarray whose sum equals to k
            if (ele % 2 == 1) {
                no = 1;
            } else {
                no = 0;
            }
            sum += no;
            if (map.containsKey(sum - k)) {
                cntNice += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cntNice;
    }
}

// Count Subarray whose Sum is Equal to K
// 560. Subarray Sum Equals K
/*
 * class Solution {
 * public int subarraySum(int[] nums, int k) {
 * HashMap<Integer,Integer> map=new HashMap<>();
 * map.put(0,1);//we hv seen 0 sum 1 time
 * int res=0;
 * int sum=0;
 * for(int ele:nums){
 * sum+=ele;
 * if(map.containsKey(sum-k)){
 * res+=map.get(sum-k);
 * }
 * map.put(sum,map.getOrDefault(sum,0)+1);
 * }
 * return res;
 * }
 * 
 * }
 */
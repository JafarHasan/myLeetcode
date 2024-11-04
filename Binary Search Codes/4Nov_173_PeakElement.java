class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        int lo=0,hi=n-1;
        
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            if(mid<n-1 && nums[mid]<nums[mid+1]){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return lo;
    }
}
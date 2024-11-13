class Solution {
    //TC:O(N) SC:O(1)
    public int longestOnes(int[] nums, int k) {
        int cnt=0,len=0,maxLen=0,j=0;
        for(int i=0;i<nums.length;i++){
            //count zeroes
            if(nums[i]==0){
                cnt++;
            }
            //move pointer until no of zeroes=k
            while(cnt>k){
                if(nums[j]==0){
                    cnt--;
                }
                j++;
            }
            //find len of window
            len=i-j+1;
            //update max Len
            maxLen=Math.max(maxLen,len);

        }
        return maxLen;
    }
}
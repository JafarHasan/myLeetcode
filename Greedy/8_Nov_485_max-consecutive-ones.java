
class Solution {
    public int findMaxConsecutiveOnes2(int[] nums) {
        int cnt=0;
        int max=0;
        for(int ele:nums){
            if(ele==1){
                cnt++;
                max=Math.max(max,cnt);
            }
            else{
                cnt=0;
            }
        }
        return max;
    }

     public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int cnt=0;
        int max=0;
        for(int ele:nums){
            if(ele==1){
                cnt++;
                
            }
            else {
                max=Math.max(max,cnt);
                cnt=0;
            }
        }
        max=Math.max(max,cnt);
        return max;
     }
}
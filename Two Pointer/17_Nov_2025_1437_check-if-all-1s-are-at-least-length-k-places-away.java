class Solution {
    public boolean kLengthApart(int[] nums, int k) 
    {
        int prev=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                if(prev!=-1 && (i-prev-1)<k)
                {
                    return false;
                }
                prev=i;
            }
        }
        return true;
    }
}
class Solution_Bf {
    public boolean kLengthApart(int[] nums, int k) {
        int prev=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){prev=i;break;}
        }
        for(int i=prev+1;i<nums.length;i++){
            if(nums[i]==1){
                if(Math.abs(i-prev-1)<k)return false;
                prev=i;
            }

        }
        return true;
    }
}
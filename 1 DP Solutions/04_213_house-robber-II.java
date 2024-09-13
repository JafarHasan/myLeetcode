import java.util.Arrays;

class Solution1 {
    //TLE 62/75
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int first=solve(nums,0,n-2); //if robbery in 0th idx house goto till n-2 house
        int second=solve(nums,1,n-1);//if not robbery in first house ,robber 1 till n-1 house
        return Math.max(first,second);


    }
    private int solve(int nums[],int i,int n){
        if(i==n) return nums[i];
        if(i>n) return 0;

         //pick (if pick get the curr money and goto next->next house)
        int steal=nums[i]+solve(nums,i+2,n);
        //not pick (if not robbery this house goto next house)
        int skip=solve(nums,i+1,n);
        return Math.max(steal,skip);

    }

}
class Solution{
    
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int first=solve(nums,0,n-2,dp); //if robbery in 0th idx house goto till n-2 house
         Arrays.fill(dp,-1);
        int second=solve(nums,1,n-1,dp);//if not robbery in first house ,robber 1 till n-1 house
        return Math.max(first,second);


    }
    private int solve(int nums[],int i,int n,int[] dp){
        if(i==n) return nums[i];
        if(i>n) return 0;
        if(dp[i]!=-1) return dp[i];
         //pick (if pick get the curr money and goto next->next house)
        int steal=nums[i]+solve(nums,i+2,n,dp);
        //not pick (if not robbery this house goto next house)
        int skip=solve(nums,i+1,n,dp);
        return dp[i]=Math.max(steal,skip);

    }

}
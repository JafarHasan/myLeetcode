class Solution {
    //TC:O(NlogN) N=quantities.legnth;
    //SC:O(1)
    public int minimizedMaximum(int n, int[] quan) {
        int max=0;
        for(int ele:quan){
            max=Math.max(max,ele);
        }
        int lo=1,hi=max;
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossibleToDistribute(mid,quan,n)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;

    }
    private boolean isPossibleToDistribute(int mid,int[] quan,int n){
        for(int product:quan){
            n-=(product+mid-1)/mid;///Math.ceil(product/mid)
            if(n<0)return false;
        }
        return true;
    }
}
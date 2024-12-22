
import java.util.*;
class Solution {
    //beats 100% TC:O(N) SC:O(1)
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int cnt=0;
        int max=0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                cnt++;
        }
        return cnt;

    }
}
class Solution2 {
    //beats 100% TC:O(NlogN) SC:O(N)
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int sum[]=new int[n];
        sum[0]=arr[0];
        //running sum of current array
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+arr[i];
        }
        
        Arrays.sort(arr);
        int prefix[]=new int[n];
        prefix[0]=arr[0];
        ///running sum of sorted array
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
       
        //check how many times running sum is found exact as sorted running sum
        int cnt=0;
        for(int i=0;i<n;i++){
            if(sum[i]==prefix[i]){
                cnt++;
            }
        }
        return cnt;

    }
}
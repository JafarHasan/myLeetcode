class Solution {
    // TC:O(NlogN+NxNlogN) SC:o(1)
    public int[] maximumBeauty(int[][] items, int[] que) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int n = items.length;
        int m = que.length;
        int profit[]=new int[n];
        profit[0]=items[0][1];
        for(int i=1;i<n;i++){
            profit[i]=Math.max(profit[i-1],items[i][1]);
        }
        int ans[] = new int[m];
        for(int i=0;i<m;i++){
            int q=que[i];
            int left=0,right=n-1;
            //Binary Search
            while(left<=right){
                int mid=(left+right)/2;
                if(items[mid][0]<=q)
                left=mid+1;
                else
                right=mid-1;
            }
            ans[i]=right>=0?profit[right]:0;
        }
        return ans;

    }
}

class Solution2 {
    // TLE 33/35 passed
    // TC:O(NlogN+NxM)=>O(NxM) SC:o(1)
    public int[] maximumBeauty(int[][] items, int[] que) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int n = items.length;
        int m = que.length;
        int ans[] = new int[m];
        // for(int i=0;i<items.length;i++){
        // System.out.println(items[i][0]+","+items[i][1]);
        // }
        for (int i = 0; i < m; i++) {
            int maxPrice = 0;
            for (int j = 0; j < n; j++) {
                if (items[j][0] <= que[i]) {
                    maxPrice = Math.max(maxPrice, items[j][1]);
                } else {
                    break;
                }
            }
            ans[i] = maxPrice;
        }
        return ans;
    }
}
class Solution {
    // TC:O(N) SC:O(1)
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int ele : arr) {
            if (ele % 2 == 1) {// counting odd
                cnt++; // increasing cnt by 1
                if (cnt == 3) { // if cnt=3 then yes return true
                    return true;
                }
            } else {
                cnt = 0;// reset cnt =0 and count again with remaining elements
            }
        }
        return false;
    }
}

/*
 * 
 * 
 * //another approach
 * public boolean threeConsecutiveOdds(int[] arr) {
 * for(int i=1;i<arr.length-1;i++){
 * if(arr[i-1]%2==1 && arr[i]%2==1 && arr[i+1]%2==1) return true;
 * }
 * return false;
 * }
 * 
 * 
 */
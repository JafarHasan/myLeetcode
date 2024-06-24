class Solution {
    // TC:O(N*k) TLE 101passed out of 113
    // public int minKBitFlips(int[] nums, int k) {
    // int cnt=0;
    // for(int i=0;i<nums.length;i++){
    // if(nums[i]==0){
    // if(i + k > nums.length) {
    // return -1;
    // }
    // for(int j=i;j<i+k;j++){
    // if(nums[j]==0) nums[j]=1;
    // else nums[j]=0;
    // }
    // cnt++;
    // }
    // }
    // return cnt;
    // }

    // OPTIMIZATION

    // flip cnt->odd &&nums[i]=1 flip
    // nums[i]=0 noflip

    // flip cnt->even && nums[i]=1 NoFlip
    // nums[i]=0 Flip

    // ---------------------------------------------

    // Conclusion
    // flip(flipCnt%2==nums[i]) flip

    // TC:O(N) SC:O(N)
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        boolean isFlip[] = new boolean[n];
        int flip = 0;
        int flipCntForI = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k && isFlip[i - k] == true) {
                flipCntForI--;
            }

            if (flipCntForI % 2 == nums[i]) {
                // fliped at idx i
                if (i + k > n) {
                    return -1;
                }
                flipCntForI++;
                flip++;
                isFlip[i] = true;

            }
        }
        return flip;

    }
}
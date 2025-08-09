
class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int lmax = Integer.MIN_VALUE;
        int rmax = Integer.MIN_VALUE;
        int i = 0, j = n - 1;
        int water = 0;
        while (i < j) {
            lmax = Math.max(lmax, height[i]);
            rmax = Math.max(rmax, height[j]);
            water += (lmax < rmax) ? (lmax - height[i++]) : (rmax - height[j--]);
        }
        return water;

    }

    ///TC:O(3N)=O(N)
    //SC:O(2N) =O(N)
    public int trap_BF(int[] height) {
        int n = height.length;
        int[] lm = new int[n];
        lm[0] = height[0];
        for (int i = 1; i < n; i++) {
            lm[i] = Math.max(lm[i - 1], height[i]);
        }

        int[] rm = new int[n];
        rm[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rm[i] = Math.max(rm[i + 1], height[i]);
        }

        //contains
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(lm[i], rm[i]) - height[i];
        }

        return water;
    }

}

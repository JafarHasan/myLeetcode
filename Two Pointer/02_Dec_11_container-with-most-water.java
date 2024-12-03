class Solution {
    //TC:O(N) SC:O(1)
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            // width of container
            int width = j - i;
            // height of container that will contains water
            int len = Math.min(height[i], height[j]);
            // new Area and Max area
            maxArea = Math.max(maxArea, len * width);
            // find next length> than curr len
            while (i < j && height[i] <= len) {
                i++;
            }
            while (i < j && height[j] <= len) {
                j--;
            }
        }
        return maxArea;
    }
}
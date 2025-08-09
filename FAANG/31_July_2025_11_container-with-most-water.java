
class Solution {

    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int water = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int w = (j - i);
            water = Math.max(water, h * w);

            while (i < j && height[i] <= h) {
                i++;
            }
            while (i < j && height[j] <= h) {
                j--;
            }

        }
        return water;
    }
}

class Solution {
    // TC:O(NxN) SC:O(1)
    public int[][] generateMatrix(int n) {
        int ele = 1;
        int[][] ans = new int[n][n];

        int left = 0, right = n - 1, top = 0, down = n - 1;
        while (left <= right && top <= down) {
            // filling first row 0->n-1
            for (int i = left; i <= right; i++) {
                ans[top][i] = ele++;
            }
            // move to the next row
            top++;
            // filling last col
            for (int i = top; i <= down; i++) {
                ans[i][right] = ele++;
            }
            // move to the 2nd last col
            right--;

            if (top <= down) {
                // filling last row reverse right->left
                for (int i = right; i >= left; i--) {
                    ans[down][i] = ele++;
                }
                // move to up 2nd last row
                down--;
            }
            if (left <= right) {
                // filling first col reverse order down->top
                for (int i = down; i >= top; i--) {
                    ans[i][left] = ele++;
                }
                // move to the 2nd col
                left++;
            }

        }
        return ans;
    }
}
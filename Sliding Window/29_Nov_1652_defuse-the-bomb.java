class Solution {
    //TC:O(NxK) SC:O(1)
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];
        if (k == 0)
            return ans;
        else if (k > 0) {
            for (int i = 0; i < n; i++) {
                int temp = k;
                int sum = 0;
                int j = i + 1;
                while (temp-- > 0) {
                    sum += code[(j) % n];
                    j++;
                }
                ans[i] = sum;
            }
        } else if (k < 0) {
            for (int i = n - 1; i >= 0; i--) {
                int temp = Math.abs(k);
                int sum = 0;
                int j = (i - 1) % n;
                if (j == -1) {
                    j = n - 1;
                }
                while (temp-- > 0) {
                    if (j == -1) {
                        j = n - 1;
                    }
                    sum += code[(j) % n];
                    j--;
                }
                ans[i] = sum;
            }
        }
        return ans;
    }
}

class Solution {

    public int[] sumZero(int n) {
        int ans[] = new int[n];
        int val = n;
        int i = 0;
        int sum = 0;
        while (i < n) {
            ans[i++] = -val;
            sum -= val;
            if (i < n) {
                ans[i++] = val;
                sum += val;
            }

            val--;
        }
        if (sum == 0) {
            return ans;
        }

        ans[n - 1] = 0;
        return ans;
    }
}

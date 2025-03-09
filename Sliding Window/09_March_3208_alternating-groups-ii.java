
class Solution {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int ans = 0;
        int n = colors.length;
        int temp[] = new int[n + k - 1];
        for (int i = 0; i < n + k - 1; i++) {
            temp[i] = colors[i % n];
        }

        int i = 0, j = 1;
        int N = n + k - 1;
        while (j < N) {
            // if both same invalid window
            if (temp[j] == temp[j - 1]) {
                i = j;
                j++;
                continue;
            }
            if (j - i + 1 == k) {
                ans++;
                i++;
            }
            j++;
        }
        return ans;

    }

    // TLE: 532/625 passed TC:O(N^2) SC:O(2*N)
    // check its a valid window of size k
    private boolean check(int s, int e, int[] arr) {
        for (int i = s; i < e; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int numberOfAlternatingGroups_BF(int[] colors, int k) {
        int cnt = 0;
        int n = colors.length;
        int temp[] = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            temp[i] = colors[i % n];
        }

        for (int i = 0; i < n; i++) {
            if (check(i, i + k - 1, temp)) {
                cnt++;
            }
        }
        return cnt;
    }
}

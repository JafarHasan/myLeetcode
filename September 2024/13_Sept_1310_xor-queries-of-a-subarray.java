class Solution1 {
    // TC:O(N*M) N=queries.length; M=arr.length when s=0 and e=N-1 wrost case
    // SC:O(1)
    private int findXOR(int[] arr, int s, int e) {
        int ans = 0;
        ans = ans ^ arr[s];
        for (int i = s + 1; i <= e; i++) {
            ans ^= arr[i];
        }
        return ans;
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int ans[] = new int[n];
        int idx = 0;
        for (int row[] : queries) {
            // System.out.println(arr[row[0]]+"^"+arr[row[1]]);
            int s = row[0];
            int e = row[1];
            ans[idx] = findXOR(arr, s, e);
            idx++;
        }
        return ans;
    }
}

// Optimized Approch 2ms 100%beats
class Solution {
    // TC:O(N) N=queries.length; M=arr.length when s=0 and e=N-1 wrost case
    // SC:O(M)

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int xor[] = new int[arr.length];
        xor[0] = arr[0];
        int ans[] = new int[n];
        int idx = 0;
        // Xor of all
        for (int i = 1; i < arr.length; i++) {
            xor[i] = xor[i - 1] ^ arr[i];
        }

        for (int row[] : queries) {
            int l = row[0];
            int r = row[1];
            ans[idx++] = (l == 0 ? 0 : xor[l - 1]) ^ xor[r];
        }
        return ans;
    }
}
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        // TC:O(N^2) SC:O(N)
        int maxLen = 0;
        int cnt = 0;
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(arr[i], i);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int n1 = arr[i];
                int n2 = arr[j];
                int len = 2;
                while (map.containsKey(n1 + n2)) {
                    int n3 = n1 + n2;
                    n1 = n2;
                    n2 = n3;
                    len++;
                }
                maxLen = Math.max(len, maxLen);
            }

        }
        return maxLen >= 3 ? maxLen : 0;
    }
}
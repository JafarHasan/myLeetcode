class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        int n = arr.length;
        // longest sorted prefix
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // if whole array is sorted
        if (left == n - 1)
            return 0;

        // longest sorted suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        int minLen = Math.min(n - left - 1, right);
        // Try removing the subarray by checking the combination of sorted left and
        // sorted right
        for (int i = 0; i <= left; i++) {
            while (right < n && arr[i] > arr[right]) {
                right++;
            }
            minLen = Math.min(minLen, right - i - 1);
        }
        return minLen;
    }
}
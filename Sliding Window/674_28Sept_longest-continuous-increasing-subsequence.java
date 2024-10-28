class Solution {
    public int findLengthOfLCIS(int[] arr) {
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (i < arr.length && arr[i - 1] < arr[i]) {
                i++;
                max = Math.max(max, i - j);
            }
        }
        return max;
    }

}
package Greedy;

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here

        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for (int ele : arr) {
            if (ele > max) {
                smax = max;
                max = ele;
            } else if (ele < max && ele > smax) {
                smax = ele;
            }
        }
        return smax == Integer.MIN_VALUE ? -1 : smax;
    }
}

class Solution {

    //USing Space O(N+M) SC:O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = (n + m - 1);
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[idx--] = nums2[j--];
        }
    }
}

class Solution_Using_Extra_Space {

    //USing Space O(N+M) SC:O(N+M)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[n + m];
        int i = 0, j = 0;
        int idx = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[idx++] = nums1[i++];
            } else {
                temp[idx++] = nums2[j++];
            }
        }
        while (i < m) {
            temp[idx++] = nums1[i++];
        }
        while (j < n) {
            temp[idx++] = nums2[j++];
        }
        idx = 0;
        for (int ele : temp) {
            // System.out.print(ele+" ");
            nums1[idx++] = ele;
        }
    }
}

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long nums1_Sum = 0;
        long nums2_Sum = 0;
        int nums1_zero_cnt = 0, nums2_zero_cnt = 0;
        for (int ele : nums1) {
            //treating 0 as 1
            if (ele == 0) {
                nums1_zero_cnt++;
                nums1_Sum += 1;
            } else {

                nums1_Sum += ele;
            }
        }
        for (int ele : nums2) {
            //treating 0 as 1
            if (ele == 0) {
                nums2_zero_cnt++;
                nums2_Sum += 1;
            } else {
                nums2_Sum += ele;
            }
        }
        ///not possible
        if (nums1_Sum < nums2_Sum && nums1_zero_cnt == 0)
            return -1;
        if (nums2_Sum < nums1_Sum && nums2_zero_cnt == 0)
            return -1;
        return Math.max(nums1_Sum, nums2_Sum);
    }
}

class Solution {

    public int findTarget(int arr[], int target) {
        // code here
        if (arr[0] == target) {
            return 0;
        }
        if (arr[arr.length - 1] == target) {
            return arr.length - 1;
        }
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            //check mid-1
            if (mid > lo && arr[mid - 1] == target) {
                return mid - 1;
            }
            if (mid < hi && arr[mid + 1] == target) {
                return mid + 1;
            }

            if (arr[mid] > target) {
                hi = mid - 2;//skip mid-1 and mid
             }else {
                lo = mid + 2;//skip mid+1 and mid
            }
        }
        return -1;

    }
}

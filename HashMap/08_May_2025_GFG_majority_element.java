
class Solution {

    static int majorityElement(int arr[]) {
        // code here
        int ele = arr[0];
        int cnt = 1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (ele == arr[i]) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                ele = arr[i];
                cnt = 1;
            }
        }
        cnt = 0;
        for (int key : arr) {
            if (key == ele) {
                cnt++;
            }
        }
        return cnt > n / 2 ? ele : -1;

    }
}


class Solution {

    public int findMissing(int[] arr) {
        int d = arr[1] - arr[0];
        int sum = arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == d) {
                sum = arr[i];
            } else {
                return sum + d;
            }
        }
        return sum + d;
    }
}

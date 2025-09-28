
class Solution {

    //TC:O(n*5);maxNoOfDigits=10000=5;
    private boolean nonZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (nonZero(i) && nonZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[]{-1, -1};
    }
    // public int[] getNoZeroIntegers(int n) {
    //     if((n-1)%10!=0)
    //     return new int[]{1,n-1};
    //     return new  int[]{2,n-2};
    // }
}


class Solution {
    // REcursive Approach
    public boolean isUgly(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        if (n % 2 == 0) {
            return isUgly(n / 2);
        }
        if (n % 3 == 0) {
            return isUgly(n / 3);
        }
        if (n % 5 == 0) {
            return isUgly(n / 5);
        }

        return false;
    }

    // TC:O(N) SC:O(1)
    public boolean isUgly2(int n) {
        if (n <= 0)
            return false; // ugly no are not -ve
        if (n == 1)
            return true;

        // Continuously divide n by 2, 3, and 5 as long as it's divisible by them
        while (n % 2 == 0)
            n = n / 2;
        while (n % 3 == 0)
            n = n / 3;
        while (n % 5 == 0)
            n = n / 5;

        return n == 1;
    }
}
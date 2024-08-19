class Solution {
    // TC O(N) SC:O(1)
    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n;) {
            if (n % i == 0) {
                ans += i;
                n /= i;
            } else {
                i++;
            }
        }
        if (n != 1) {
            ans += n;
        }
        return ans;
    }

    public int minSteps2(int n) {
        if (n == 1)
            return 0;

        int steps = 0;
        int factor = 2;

        while (n > 1) {
            // divide n until it is divisible by any factor
            while (n % factor == 0) {
                steps += factor;
                n /= factor;
            }
            // else goto next no and check again if its factor or not
            factor++;
        }

        return steps;
    }
}

class Solution {
    boolean isPrime[];

    public boolean primeSubOperation(int[] nums) {
        isPrime = new boolean[1000];
             Arrays.fill(isPrime, true);
        int n = nums.length;
        sieve();// populate my isPrime array
        // prime[i]=true mean i is a prime no

        for (int i = n - 2; i >= 0; i--) {// TC:O(n)
            if (nums[i] < nums[i + 1]) {
                continue;
            }
            // nums[i]>=nums[i+1] decrese nusm[i] atleast less than nums[i+1]
            // check Prime no less than nums[i]

            for (int p = 2; p < nums[i]; p++) {// TC:max of nums
                if (!isPrime[p]) {
                    continue;
                }
                if (nums[i] - p < nums[i + 1]) {
                    nums[i] -= p;
                    break;
                }
            }

            if (nums[i] >= nums[i + 1]) {
                return false;

            }
        }
        return true;

    }

    // TC:O(1000)=TC:O(1)
    private void sieve() {
   
        // 0 and 1 are not a Prime no
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < 1000; i++) {
            if (isPrime[i] == true) {
                /// mark all multiple of curr Prime no false
                for (int j = i * i; j < 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}

class Solution {
    // TC:(K*N) SC:O(1) Brute Froce 6/72 test passed
    public int chalkReplacer1(int[] chalk, int k) {
        int n = chalk.length;
        while (k > 0) {
            for (int i = 0; i < n; i++) {
                System.out.print(k + " ");
                if (k < chalk[i]) {
                    return i;
                } else if (k == chalk[i]) {
                    return (i == n - 1) ? 0 : i + 1;
                }

                k -= chalk[i];
            }
        }
        return -1;
    }

    //// TC:(K) SC:O(1) 71/72 test passed
    public int chalkReplacer2(int[] chalk, int k) {
        int n = chalk.length;
        int sum = 0;
        int i = 0;
        
        while (sum < k) {
            sum += chalk[i % n];
            if (sum > k) {
                return i % n;
            } else if (sum == k) {
                return (i + 1) % n;
            }
            i++;
        }
        return -1;

    }
    //Best Solution using prefix Sum
    // TC:O(N)
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long totalChalk = 0;
        for (int usedChalk : chalk) {
            totalChalk += usedChalk;
        }
        int remaining = (int) (k % totalChalk);
        for (int i = 0; i < n; i++) {
            if (remaining < chalk[i]) {
                return i;
            }
            remaining -= chalk[i];
        }
        return 0;
    }

}
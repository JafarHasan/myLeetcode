class Solution {
    // TC;O(N) SC:O(1)
    public int maxSatisfied(int[] cust, int[] grum, int mints) {
        int n = cust.length;

        int currUnsatisfied = 0;
        // O(N)
        for (int i = 0; i < mints; i++) {
            // also use if else
            // if(grumpy[i]==1)
            // currUnsatisfied+=cust[i];

            // this is also fine
            currUnsatisfied += cust[i] * grum[i];

        }
        int maxUnsatisfyCustomres = currUnsatisfied;
        int i = 0, j = mints;
        while (j < n) { // O(N)
            currUnsatisfied += cust[j] * grum[j];// new element in the window
            currUnsatisfied -= cust[i] * grum[i];// removing element from window

            maxUnsatisfyCustomres = Math.max(maxUnsatisfyCustomres, currUnsatisfied);
            i++;
            j++;
        }

        int totalSat = maxUnsatisfyCustomres;
        for (i = 0; i < n; i++) { // O(N)
            totalSat += cust[i] * (1 - grum[i]); // (1-0)=1 AND 1-1=0
        }

        return totalSat;
    }
}
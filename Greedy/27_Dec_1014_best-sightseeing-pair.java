class Solution {
    // TC:O(N) SC:O(1)
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxScore = 0;
        // values[i] + values[j] + i - j
        // can be written as=(values[i] +i)+(values[j] - j)
        // precompute the max value till ith idx of(values[i]+i)
        int currMax = values[0] + 0;
        for (int j = 1; j < n; j++) {
            int jThMax = values[j] - j;
            maxScore = Math.max(maxScore, currMax + jThMax);
            /// update currMax previous ith for next Iteration
            currMax = Math.max(currMax, values[j] + j);
        }
        return maxScore;
    }

    // TC:O(N) SC:O(N)
    public int maxScoreSightseeingPair2(int[] values) {
        int n = values.length;
        int maxScore = 0;
        int temp[] = new int[n];
        // values[i] + values[j] + i - j
        // can be written as=(values[i] +i)+(values[j] - j)
        // store the max value till ith idx of(values[i]+i)
        temp[0] = values[0] + 0;

        for (int i = 1; i < n; i++) {
            temp[i] = Math.max(temp[i - 1], (values[i] + i));
        }
        for (int j = 1; j < n; j++) {
            int ithMax = temp[j - 1];
            int jThMax = values[j] - j;
            maxScore = Math.max(maxScore, ithMax + jThMax);
        }
        return maxScore;
    }

    // TC:O(N^2) SC:O(1) BF
    public int maxScoreSightseeingPairBruteForce(int[] values) {
        int n = values.length;
        int maxScore = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int currScore = values[i] + values[j] + (i - j);
                maxScore = Math.max(maxScore, currScore);
            }
        }
        return maxScore;
    }
}
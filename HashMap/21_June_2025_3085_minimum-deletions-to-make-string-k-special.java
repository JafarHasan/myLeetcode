
class Solution {

    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;

        // Count frequencies
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'a']);
        }

        int minDeletions = Integer.MAX_VALUE;

        // Try each possible starting frequency
        for (int f = 1; f <= maxFreq; f++) {
            int deletions = 0;
            int sr = f;
            int er = f + k;

            for (int i = 0; i < 26; i++) {
                int curr = freq[i];
                if (curr == 0) {
                    continue;
                }

                if (curr < sr || curr > er) {
                    // delete the extra or whole frequency
                    if (curr < sr) {
                        deletions += curr; // delete all
                    } else {
                        deletions += curr - er; // bring down to max allowed
                    }
                }
            }

            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }

}

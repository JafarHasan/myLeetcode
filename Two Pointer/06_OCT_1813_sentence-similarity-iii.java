class Solution {
    // TC:O(N) SC:O(N)
    public boolean areSentencesSimilar(String sent1, String sent2) {
        int n = sent1.length();
        int m = sent2.length();

        if (n < m) {
            String t = sent1;
            sent1 = sent2;
            sent2 = t;
        }
        // s1 always contains max len string
        String s1[] = sent1.split(" ");
        String s2[] = sent2.split(" ");
        n = s1.length;
        m = s2.length;
        
        int minLen = m;
        // find common prefix
        int i = 0;
        while (i < minLen && (s1[i].equals(s2[i]))) {
            i++;
        }

        // Find common suffix
        int j = 0;
        while (j < (n - i) && j < (m - i) && s1[n - 1 - j].equals(s2[m - 1 - j])) {
            j++;
        }

        // Check if the total number of matching words is equal to the shorter sentence
        return (i + j == m);

    }
}

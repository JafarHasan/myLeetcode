class Solution {
    // Greedy Approach TC:O(N) SC:O(1)
    public int minimumDeletions(String s) {
        int n = s.length();
        int cntB = 0;
        int deletion = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                cntB++;
            } else if (ch == 'a') {
                deletion = Math.min(deletion + 1, cntB);
            }
        }
        return deletion;
    }
}
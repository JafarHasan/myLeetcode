
class Solution {

    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int cntW = 0;
        int minChnages = 0;
        // cnt W in first k size window
        int i = 0;
        for (; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                cntW++;
            }
            minChnages = cntW;
            while (i < n) {
                // delete the last/first chars from window
                if (blocks.charAt(i - k) == 'W') {
                    cntW--;
                }
                if (blocks.charAt(i) == 'W') {
                    cntW++;
                }
                minChnages = Math.min(minChnages, cntW);
                i++;
            }
            return minChnages;
        }

    }
}

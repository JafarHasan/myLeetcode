class Solution {
    //TC:O(N) SC:O(1)
    public int maxScore(String s) {
        int one = 0;
        // cnt all one
        for (char ch : s.toCharArray()) {
            if (ch == '1')
                one++;
        }

        int res = 0;
        int zero = 0;
        if (s.charAt(0) == '0')
            zero++;
        else
            one = one > 0 ? one - 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            res = Math.max(res, one + zero);
            if (s.charAt(i) == '0')
                zero++;
            else
                one = one > 0 ? one - 1 : 0;
        }
        return res;
    }

    // TC:O(N) SC:O(N)
    public int maxScore2(String s) {
        int n = s.length();
        // cnt the preSum of one's from right to left
        int prefix[] = new int[n];
        int idx = n - 1;
        int noOfOne = 0;
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '1') {
                noOfOne++;
            }
            prefix[idx--] = noOfOne;
        }
        // for (int i : prefix)
        // System.out.print(i + ",");
        int maxScore = 0;
        int cnt0 = 0;
        for (int i = 0; i < n - 1; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                cnt0++;
            }
            maxScore = Math.max(maxScore, (prefix[i + 1] + cnt0));
        }
        return maxScore;
    }
}
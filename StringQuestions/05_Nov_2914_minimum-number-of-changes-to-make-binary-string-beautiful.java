class Solution {
    // TC:O(N) SC:O(1) beats 97%
    public int minChanges(String s) {
        // find each substring of size 2 as a block
        /// check if both chars are same 0,0, OR 1 1 no need to chnage
        // both chars are different 0,1 OR 1 0 so one need to chnage in each block
        int n = s.length();
        int changes = 0;
        for (int i = 0; i < n - 1; i += 2) {
            char charAt0 = s.charAt(i);
            char charAt1 = s.charAt(i + 1);
            if (charAt0 != charAt1) {
                changes++;
            }
            // else if both are equals do nothing check next block of size 2(i+=2)
        }
        return changes;
    }
}

class Solution2 {
    public int minChanges(String s) {
        int cnt0 = 0, cnt1 = 0;
        int n = s.length();
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                cnt0++;
            } else {
                cnt1++;
            }

        }
        if (cnt0 == cnt1)
            return n / 2;
        else if (cnt0 == n || cnt1 == n)
            return 0;
        else if (cnt0 > cnt1)
            return cnt1;
        else
            return cnt0;
    }
}
// Failed at 248/577
/**
 * "11000111"
 * output=3
 * expected=1
 */
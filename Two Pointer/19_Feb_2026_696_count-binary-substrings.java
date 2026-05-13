
class Solution {

    public int countBinarySubstrings(String s) {
        int n = s.length();
        int curr = 1, prev = 0;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++; 
            }else {
                res += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        return res + Math.min(prev, curr);
    }
}

class Solution_BF {

    //TLE 38/91 passed
    private boolean isValid(String s) {
        int m = s.length();
        if (m % 2 == 1) {
            return false;
        }
        //if(s.charAt(0)==s.charAt(m-1))return false;
        char first = s.charAt(0);
        int cnt1 = 0;
        int i = 0;
        while (i < m && s.charAt(i) == first) {
            cnt1++;
            i++;
        }
        if (i == m) {
            return false;
        }
        int cnt2 = 0;
        char second = s.charAt(i);
        while (i < m && s.charAt(i) == second) {
            cnt2++;
            i++;
        }
        if (i != m) {
            return false;
        }
        return cnt1 == cnt2;

    }

    public int countBinarySubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isValid(s.substring(i, j))) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

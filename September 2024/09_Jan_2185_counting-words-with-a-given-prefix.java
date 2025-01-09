
class Solution {

    // Without startsWith method TC:O(N*M) SC:O(1)
    // N=words.length M=length of pref
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for (String w : words) {
            if (startsWithPrefix(w, pref)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean startsWithPrefix(String s, String pref) {
        int n = s.length();
        int m = pref.length();
        if (m > n) {
            return false;
        }
        int i = 0;
        for (int j = 0; j < m; j++) {
            if (s.charAt(i) == pref.charAt(j)) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

    public int prefixCount1(String[] words, String pref) {
        int cnt = 0;
        for (String w : words) {
            if (w.startsWith(pref)) {
                cnt++;
            }
        }
        return cnt;
    }
}


class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int cnt = 0;
        int first = 0, second = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
                if (cnt > 2) {
                    return false;
                }  /// store the first diff
                else if (cnt == 1) {
                    first = i;
                } else {
                    second = i;
                }
            }
        }
        return (s1.charAt(first) == s2.charAt(second)
                && s1.charAt(second) == s2.charAt(first));
    }
}

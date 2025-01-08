
class Solution {

    //TC:O(n^2*M) M =to find suffix and prefix SC:O(1)
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String str1 = words[i];
            for (int j = i + 1; j < n; j++) {
                String str2 = words[j];
                if (ifPrefixAndSuffix(str1, str2)) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    private boolean ifPrefixAndSuffix(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        // Check if s1 is a prefix of s2
        boolean isPrefix = s2.startsWith(s1);
        // Check if s1 is a suffix of s2
        boolean isSuffix = s2.endsWith(s1);

        return isPrefix && isSuffix;
    }
}

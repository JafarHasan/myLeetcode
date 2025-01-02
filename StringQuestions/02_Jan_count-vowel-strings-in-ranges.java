
class Solution {

    ///TC:O(N) SC:O(M)
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        int m = words.length;
        int prefix[] = new int[m];
        // compute the prefix sum of string with start and end vowels
        // check is first string is vowel string
        if (isVowel(words[0].charAt(0)) && isVowel(words[0].charAt(words[0].length() - 1))) {
            prefix[0] = 1;
        }
        for (int i = 1; i < m; i++) {
            String s = words[i];
            if (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1))) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }
        int idx = 0;
        for (int row[] : queries) {
            int start = row[0];
            int end = row[1];
            if (start == 0) {
                ans[idx++] = prefix[end];
            } else {
                ans[idx++] = prefix[end] - prefix[start - 1];
            }
        }
        return ans;
    }

    // BF Brute Force
    // TC:O(N^maxRangeLength),SC:O(1)
    public int[] vowelStrings1(String[] words, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int idx = 0;
        for (int row[] : queries) {
            int s = row[0];
            int end = row[1];
            ans[idx++] = countString(s, end, words);
        }
        return ans;
    }

    private int countString(int s, int e, String[] words) {
        int cnt = 0;
        for (int i = s; i <= e; i++) {
            char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length() - 1);
            if (isVowel(first) && isVowel(last)) {
                cnt++;
            }
        }
        return cnt;
    }
}

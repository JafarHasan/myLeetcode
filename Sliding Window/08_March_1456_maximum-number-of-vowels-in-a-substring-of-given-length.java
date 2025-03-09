
class Solution {

    // TC:O(n) SC:O(1)
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int maxVowels(String s, int k) {

        // count vowel in first window of length k
        int cnt = 0, maxCnt = 0;
        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                cnt++;
            }

        }
        maxCnt = Math.max(maxCnt, cnt);
        int j = 0;
        for (int i = k; i < s.length(); i++) {
            char chI = s.charAt(i);
            char chJ = s.charAt(j);
            // leaving the first char from the window
            if (isVowel(chJ)) {
                cnt--;
            }
            // adding the new Char in window
            if (isVowel(chI)) {
                cnt++;
            }
            j++;
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;

    }
}

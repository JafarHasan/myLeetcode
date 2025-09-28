
class Solution {

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int maxV = 0, maxC = 0;
        //traversing the array O(26)=O(1)
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            if (isVowel(ch)) {
                maxV = Math.max(maxV, freq[ch - 'a']);
            } else {
                maxC = Math.max(maxC, freq[ch - 'a']);
            }
        }
        return maxV + maxC;
    }
}

class Solution2 {

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int maxV = 0, maxC = 0;
        //traversing the string O(N)
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                maxV = Math.max(maxV, freq[ch - 'a']);
            } else {
                maxC = Math.max(maxC, freq[ch - 'a']);
            }
        }
        return maxV + maxC;
    }
}

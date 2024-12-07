import java.util.*;

class Solution {
    // TC:O(N^2) SC:O(5)=SC:O(1)
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'o' || c == 'u' || c == 'e';
    }

    public int countVowelSubstrings(String word) {
        int ans = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);
                if (!isVowel(ch)) {
                    break;
                } else
                    set.add(ch);
                if (set.size() == 5) {
                    ans++;
                }

            }

        }
        return ans;

    }
}
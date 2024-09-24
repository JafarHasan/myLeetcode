import java.util.HashSet;
import java.util.Set;

class Solution1 {
    // 388/2028 passed wrong ans

    public int minExtraChar(String s, String[] dic) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < dic.length; i++) {
            String str = dic[i];
            int start = sb.indexOf(str);
            int end = start + str.length();
            if (start != -1) {
                sb.delete(start, end);
            }
        }
        return sb.length();
    }
}

class Solution {
    public int minExtraChar(String s, String[] dic) {
        Set<String> dictionary = new HashSet<>(Set.of(dic));
        int n = s.length();
        int[] dp = new int[n + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) {
            dp[i] = i; // Start with all characters being extra
        }

        for (int i = 1; i <= n; i++) {
            // Assume the last character is extra
            dp[i] = dp[i - 1] + 1;

            // Check for each word in the dictionary
            for (String word : dictionary) {
                int len = word.length();
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    dp[i] = Math.min(dp[i], dp[i - len]); // No extra characters if word matches
                }
            }
        }

        return dp[n]; // The minimum extra characters needed for the whole string
    }
}
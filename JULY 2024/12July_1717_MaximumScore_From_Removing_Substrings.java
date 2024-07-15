import java.util.*;

class Solution {

    // Method 1
    // TC:O(2N)=O(N) SC:O(N)
    public int maximumGain2(String s, int x, int y) {
        int n = s.length();
        String maxStr = "";
        String minStr = "";
        if (x > y) {
            maxStr = "ab";
            minStr = "ba";
        } else {
            maxStr = "ba";
            minStr = "ab";
        }

        /// first pass
        int score = 0;
        String temp1 = removeMaxSubstring(s, maxStr);
        int len1 = temp1.length();
        int charRemoved = (n - len1) / 2;
        score += (charRemoved) * (Math.max(x, y));

        // second pass
        String temp2 = removeMaxSubstring(temp1, minStr);

        charRemoved = (len1 - temp2.length()) / 2;
        score += (charRemoved) * (Math.min(x, y));

        return score;
    }

    public String removeMaxSubstring(String s, String sub) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            // if b found while removing ab or a found while removing ba as 2nd char
            if (ch == sub.charAt(1) && !st.isEmpty() && st.peek() == sub.charAt(0)) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();

    }

    // Method 2 Two Pointer j writing ,i reading
    // TC:O(N) SC:O(1) Without Stack
    public int maximumGain(String s, int x, int y) {
        // Ensure "ab" always has higher points than "ba"
        if (x < y) {
            // Swap points
            int temp = x;
            x = y;
            y = temp;
            // Reverse the string to maintain logic
            s = new StringBuilder(s).reverse().toString();
        }

        int aCount = 0, bCount = 0, totalPoints = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'a') {
                aCount++;
            } else if (currentChar == 'b') {
                if (aCount > 0) {
                    // Can form "ab", remove it and add points
                    aCount--;
                    totalPoints += x;
                } else {
                    // Can't form "ab", keep 'b' for potential future "ba"
                    bCount++;
                }
            } else {
                // Non 'a' or 'b' character encountered
                // Calculate points for any remaining "ba" pairs
                totalPoints += Math.min(bCount, aCount) * y;
                // Reset counters for next segment
                aCount = bCount = 0;
            }
        }

        // Calculate points for any remaining "ba" pairs at the end
        totalPoints += Math.min(bCount, aCount) * y;

        return totalPoints;
    }

}
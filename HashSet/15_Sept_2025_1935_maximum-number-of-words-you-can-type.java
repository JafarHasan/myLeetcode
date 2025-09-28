
import java.util.*;

class Solution {

    // TC:O(N*k) SC:O(N)
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            set.add(ch);
        }
        int broken = 0;
        String words[] = text.split(" ");
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (set.contains(ch)) {
                    broken++;
                    break;
                }
            }
        }
        return words.length - broken;

    }
}

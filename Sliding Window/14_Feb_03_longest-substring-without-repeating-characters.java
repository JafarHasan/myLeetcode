
import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int n = s.length();
        int ans = 0;
        Set<Character> unique = new HashSet<>();
        while (right < n) {
            //get current char
            char ch = s.charAt(right);
            //if already present in set so slide window untill it is removed from set
            if (unique.contains(ch)) {
                while (left <= right && unique.contains(ch)) {
                    unique.remove(s.charAt(left));
                    left++;
                }
            }
            //add current char in set
            unique.add(ch);
            //get the longest ans length
            ans = Math.max(ans, unique.size());
            right++;
        }
        return ans;
    }
}

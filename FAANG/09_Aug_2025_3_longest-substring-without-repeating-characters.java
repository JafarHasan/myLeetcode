import java.util.*;
class Solution {

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxlen = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();

        while (r < s.length()) {
            char ch = s.charAt(r);
            if (mpp.containsKey(ch)) {
                l = Math.max(mpp.get(ch) + 1, l);
            }
            mpp.put(ch, r);
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }

}

class Solution_UsingSet {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, n = s.length(), maxLen = 0;
        while (i < n) {
            if (set.contains(s.charAt(i))) {
                //remove it
                while (j < i && set.contains(s.charAt(i))) {
                    set.remove(s.charAt(j));
                    j++;
                }
            }
            set.add(s.charAt(i));
            maxLen = Math.max(maxLen, set.size());
            i++;

        }
        return maxLen;
    }
}

class Solution_UsingMap {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length(), maxLen = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                while (map.containsKey(ch) && j < i) {
                    map.put(s.charAt(j), map.getOrDefault(ch, 0) - 1);
                    if (map.get(s.charAt(j)) == 0) {
                        map.remove(s.charAt(j));
                    }
                    j++;

                }
            }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxLen = Math.max(maxLen, map.size());

            i++;
        }
        return maxLen;
    }
}

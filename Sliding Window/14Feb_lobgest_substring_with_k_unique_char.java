
import java.util.*;

class Solution {

    public static int longestkSubstr(int n, int k, String s) {
        //write code here
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0, right = 0;
        while (right < n) {
            //add the current char to map
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            //if map size if <=k get maxLength
            if (map.size() <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                //remove elements from map 1 by 1 untill map size is <=k
                while (map.size() > k) {
                    char leftChar = s.charAt(left);
                    //decrease freq of elements
                    map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                    //if element freq is 0 remove it from map
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                    //slide window
                    left++;
                }
                //get the maxLen
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;

        }
        return maxLen == s.length() ? -1 : maxLen;

    }

}

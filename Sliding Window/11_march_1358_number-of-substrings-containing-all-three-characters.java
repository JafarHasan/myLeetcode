
import java.util.*;

class Solution {

    ///TC:O(N) SC:O(3)=O(1)
    public int numberOfSubstrings(String s) {
        int i = 0;
        int cnt = 0;
        int j = 0;
        int n = s.length();
        int map[] = new int[3];// a=0,b=1,c=2
        while (j < n) {
            char ch = s.charAt(j);
            map[ch - 'a']++;
            while (map[0] > 0 && map[1] > 0 && map[2] > 0) {
                // abcabc
                // i
                // all the substring starting from i=(n-j);
                cnt += (n - j);
                // i need to increment i so remove ith char from map first
                ch = s.charAt(i);
                map[ch - 'a']--;
                i++;
            }
            j++;

        }
        return cnt;
    }

    public int numberOfSubstrings_using_Map(String s) {
        int i = 0;
        int cnt = 0;
        int j = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() == 3) {
                // abcabc
                // i
                // all the substring starting from i=(n-j);
                cnt += (n - j);
                // i need to increment i so remove ith char from map first
                ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }
            j++;

        }
        return cnt;
    }
}
s

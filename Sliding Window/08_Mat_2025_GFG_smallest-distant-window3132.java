
import java.util.*;
class Solution {
    public int findSubString(String str) {
        // code here
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        int size = set.size();
        if (size == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int len = str.length() + 1;
        for (int i = 0; i < str.length(); i++) {
            char chI = str.charAt(i);
            map.put(chI, map.getOrDefault(chI, 0) + 1);
            while (j < i && map.size() == size) {
                char chJ = str.charAt(j);
                map.put(chJ, map.get(chJ) - 1);
                if (map.get(chJ) == 0) {
                    map.remove(chJ);
                }

                len = Math.min(len, i - j + 1);
                j++;
            }

        }
        return len;

    }
}


import java.util.*;

class Solution {

    ///TC:O(NlogN+M) SC:O(1)
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String smallest = strs[0];
        String longest = strs[strs.length - 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < smallest.length(); i++) {
            if (smallest.charAt(i) == longest.charAt(i)) {
                sb.append(smallest.charAt(i)); 
            }else {
                break;
            }
        }
        return sb.toString();

    }
}

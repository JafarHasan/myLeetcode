
import java.util.*;

class Solution {

    // TC:O(nlogn) SC:O(1) constant space
    // THIS WILL WORK FOR BOTH I AND II PROBLEMS
    public int minimumPushes(String word) {
        int freqArr[] = new int[26];// 0-25 for a-z
        for (char ch : word.toCharArray()) {
            freqArr[ch - 'a']++;

        }
        Arrays.sort(freqArr);

        int result = 0;
        for (int i = 25; i >= 0; i--) {
            if (freqArr[i] == 0) {
                break;
            }
            int freq = freqArr[i];
            int press = (25 - i) / 8 + 1;
            result += press * freq;
        }
        return result;

    }
}
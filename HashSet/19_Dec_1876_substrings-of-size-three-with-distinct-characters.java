
import java.util.HashSet;
class Solution {
    //TC:O(N) SC:O(1)
    public int countGoodSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i <n - 2; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            char ch3 = s.charAt(i + 2);
            if (ch1 == ch2 || ch2 == ch3 || ch1 == ch3) {
                continue;
            }
            cnt++;

        }
        return cnt;
    }
}

class Solution2 {
    //TC:O(N) SC:O(3)->O(1)
    public int countGoodSubstrings(String s) {
        int n = s.length();
        if (n < 3)
            return 0;

        int cnt = 0;
        for (int i = 0; i <= n - 3; i++) {
            String str = s.substring(i, i + 3);
            HashSet<Character> set = new HashSet<>();
            for (char ch : str.toCharArray()) {
                set.add(ch);
            }
            if (set.size() == 3) {
                cnt++;
            }
        }

        return cnt;
    }
}
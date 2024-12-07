package StringQuestions;

import java.util.*;

class Solution {
    // TC:O(N) SC:O(1)
    // The minimized string will not contain duplicate characters.
    public int minimizedStringLength(String s) {
        int arr[] = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        int cnt = 0;
        for (int ele : arr) {
            if (ele != 0) {
                cnt++;
            }
        }
        return cnt;

    }
}

class Solution2 {
    // TC:O(N) SC:O(N)
    // The minimized string will not contain duplicate characters.
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        return set.size();
    }
}
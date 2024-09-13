import java.util.HashSet;

class Solution2 {
    // TC:O(n*k) n=words.length,k=max length string in words 12ms
    // SC:O(m) m=allowed.length;
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }
        int cnt = 0;
        for (String s : words) {
            boolean flag = true;
            for (char ch : s.toCharArray()) {
                if (!set.contains(ch)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        return cnt;
    }
}

// Using Array of 26 size instead of HashSet we can also use a boolean array
// true or false only
class Solution {
    // TC:O(n*k) n=words.length,k=max length string in words 6ms
    // SC:O(26)=O(1)
    public int countConsistentStrings(String allowed, String[] words) {
        int arr[] = new int[26];
        for (char ch : allowed.toCharArray()) {
            arr[ch - 'a']++;
        }
        int cnt = 0;
        for (String s : words) {
            boolean flag = true;
            for (char ch : s.toCharArray()) {
                if (arr[ch - 'a'] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        return cnt;
    }
}
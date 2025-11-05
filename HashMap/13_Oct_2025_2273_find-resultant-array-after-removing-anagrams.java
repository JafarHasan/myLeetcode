
import java.util.*;

class Solution {

    private boolean bothAreAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int arr[] = new int[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a']++;
            arr[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;

    }

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for (int i = 1; i < words.length; i++) {

            if (!bothAreAnagram(words[i], words[i - 1])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }
}

class Solution_Basic {

    private boolean bothAreAnagram(String a, String b) {
        int arr[] = new int[26];
        for (char c : a.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            arr[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;

    }

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prev = words[0];
        ans.add(prev);
        for (int i = 1; i < words.length; i++) {
            String temp = words[i];
            if (bothAreAnagram(prev, temp)) {
                continue;
            }
            ans.add(temp);
            prev = temp;
        }
        return ans;
    }
}

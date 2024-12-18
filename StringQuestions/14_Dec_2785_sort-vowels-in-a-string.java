package StringQuestions;

import java.util.*;

class Solution {
    // TC:O(N+N+N+nLogn=NlogN) SC:O(N+N)=O(N)
    private boolean isVowel(char ch) {
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u';
    }

    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        char[] c = s.toCharArray();
        ArrayList<Character> arr = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                arr.add(ch);
            }
        }
        Collections.sort(arr);
        int idx = 0;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (isVowel(ch)) {
                sb.setCharAt(i, arr.get(idx));
                idx++;
            }
        }
        return sb.toString();

    }
}

class Solution2 {
    // TC:O(N+N+N+NlogN=NlogN) SC:O(N+N)=O(N)
    private boolean isVowel(char ch) {
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u';
    }

    public String sortVowels(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                cnt++;
            }
        }
        char vowels[] = new char[cnt];
        int idx = 0;
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels[idx++] = ch;
            }
        }
        char temp[] = s.toCharArray();
        idx = 0;
        Arrays.sort(vowels);
        for (char ch : vowels) {
            System.out.print(ch + ",");
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                temp[i] = vowels[idx++];
            }
        }
        return new String(temp);

    }
}
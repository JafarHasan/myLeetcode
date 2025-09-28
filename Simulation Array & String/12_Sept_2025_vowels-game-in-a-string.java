
class Solution {

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public boolean doesAliceWin(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                return true;
            }
        }
        return false;
    }
}

class Solution_1 {

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public boolean doesAliceWin(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                cnt++;
            }
        }
        if (cnt == 0) {
            return false;
        }
        return true;
    }
}

class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for(int i = 0; i < word.length(); i++) {
            switch(word.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
                    hasVowel = true;
                    break;
                case 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z',
                     'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z':
                    hasConsonant = true;
                    break;
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                    break;
                default:
                    return false;
            }
        }

        return hasVowel && hasConsonant;
    }
}
class Solution2 {
    private boolean isVowel(char ch) {
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
                || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        int digit = 0, vowel = 0, con = 0, sp;
        for (char ch : word.toCharArray()) {
            if (ch == '@' || ch == '#' || ch == '$')
                return false;
            else if (ch >= '0' && ch <= '9')
                digit++;
            else if (isVowel(ch))
                vowel++;
            else
                con++;

        }
        return vowel > 0 && con > 0;
    }
}s

class Solution {

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U';
    }

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0, n = s.length(), j = n - 1;
        char chi = 'a';
        char chj = 'b';
        while (i < j) {
            chi = arr[i];
            chj = arr[j];
            //just skip the same vowels
            // if (chi == chj) {
            //     i++;
            //     j--;
            //     continue;
            // }
            if (isVowel(chi) && isVowel(chj)) {
                arr[i] = chj;
                arr[j] = chi;
                i++;
                j--;
            }
            while (i < j && !isVowel(arr[i])) {
                i++;
            }
            while (i < j && !isVowel(arr[j])) {
                j--;
            }

        }
        return new String(arr);
    }

}

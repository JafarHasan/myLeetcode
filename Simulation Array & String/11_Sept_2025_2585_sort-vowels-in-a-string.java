
import java.util.*;

class Solution {

    //TC:O(NlogN) SC:O(N)
    public String sortVowels(String s) {
        char arr[] = s.toCharArray();
        //collect all the vowels in a string
        StringBuilder vow = new StringBuilder();
        for (char ch : arr) {
            if (isVowel(ch)) {
                vow.append(ch);
            }
        }
        //convert this String in Array to char
        char temp[] = vow.toString().toCharArray();
        //sort vowles array
        Arrays.sort(temp);
        int j = 0;
        //replace all vowels in array with sorted vowels temp array
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                arr[i] = temp[j];
                j++;
            }
        }
        //return new sorted vowles array as a string
        return new String(arr);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U';
    }
}

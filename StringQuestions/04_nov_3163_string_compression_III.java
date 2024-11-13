
class Solution {
    //TC:O(N) SC:O(1)
    public String compressedString(String word) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word.length()) {
            char ch = word.charAt(i);
            int freq = 1;// found one freq of new ch
            // untill we found all duplicate char count its freq
            while (i + 1 < word.length() && ch == word.charAt(i + 1)) {
                freq++;
                i++;
            }
            // if freq<=9 append directly
            if (freq <= 9) {
                sb.append(freq).append(ch);
            } else {
                // while we are finding freq>9 append in parts like of freq=20 =9+9+2
                while (freq > 9) {
                    sb.append("9").append(ch);
                    freq -= 9;
                }
                // adding remainig (2) freq /
                /// freq will never be 0 here bcz for 10 also it will remain 1 after above while
                // loop
                sb.append(freq).append(ch);
            }
            i++;// move to the next unique char
        }
        return sb.toString();

    }
}

class Solution2 {
    // Failed at mrm output 2m2r expected 1m1r1m so we need to cound consecutive
    // char freq
    public String compressedString(String word) {
        int arr[] = new int[26];
        for (char ch : word.toCharArray()) {
            arr[ch - 'a']++;
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word.length()) {
            char ch = word.charAt(i);
            int freq = arr[ch - 'a'];
            int temp = freq;
            if (freq <= 9) {
                sb.append(freq).append(ch);
            } else {
                while (freq > 9) {
                    sb.append("9").append(ch);
                    freq -= 9;
                }
                if (freq != 0) {
                    sb.append(freq).append(ch);
                }
            }
            i = i + temp;
        }
        return sb.toString();

    }
}